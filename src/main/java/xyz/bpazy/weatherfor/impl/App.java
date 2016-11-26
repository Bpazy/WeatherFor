package xyz.bpazy.weatherfor.impl;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import xyz.bpazy.weatherfor.api.Activity;
import xyz.bpazy.weatherfor.api.WeatherClient;
import xyz.bpazy.weatherfor.helper.JsonUtils;
import xyz.bpazy.weatherfor.models.Config;
import xyz.bpazy.weatherfor.models.SmsWeather;
import xyz.bpazy.weatherfor.models.XinZhiModel;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;

/**
 * Created by Ziyuan.
 * 2016/11/26 22:45
 */
public class App {
    private String url = "http://gw.api.taobao.com/router/rest";
    private String appkey = "23547902";
    private String secret = "411d353292ea57c0689579d84fad6fc8";

    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("weatherFor.json")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
        Config config = JsonUtils.fromJson(reader, Config.class);
        long period = 1000 * 60 * 60 * 24; // 24h
        Timer timer = new Timer();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, config.getHour());
        calendar.set(Calendar.MINUTE, config.getMinute());
        calendar.set(Calendar.SECOND, config.getSecond());
        timer.schedule(new Activity() {
            @Override
            public void exec() {
                App app = new App();
                app.run(config.getNums(), "SMS_30115191");
            }
        }, calendar.getTime(), period);
    }

    public void run(List<String> nums, String smsNo) {
        WeatherClient<XinZhiModel> weather = new DefaultWeatherClient();
        XinZhiModel cityWeather = weather.getDailyWeather("nanjing", 1, 1);
        XinZhiModel.XinZhiModelResult result = cityWeather.getResults().get(0);
        XinZhiModel.XinZhiModelResult.DailyBean daily = result.getDaily().get(0);

        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        for (String num : nums) {
            sendMessage(num, smsNo, daily, client);
        }
    }

    private void sendMessage(String num, String smsNo, XinZhiModel.XinZhiModelResult.DailyBean daily, TaobaoClient
            client) {
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setSmsType("normal");
        req.setSmsFreeSignName("子元天气");
        SmsWeather weather2 = new SmsWeather();
        String content = String.format("%s %s℃-%s℃ %s风%s级", // 多云 1℃-12℃ 北南风3级
                daily.getTextDay(),
                daily.getLow(),
                daily.getHigh(),
                daily.getWindDirection(),
                daily.getWindScale());
        weather2.setContent(content);
        weather2.setDate(daily.getDate()); // 2016-11-27
        req.setSmsParamString(JsonUtils.toJson(weather2));
        req.setRecNum(num);
        req.setSmsTemplateCode(smsNo);
        AlibabaAliqinFcSmsNumSendResponse rsp;
        try {
            rsp = client.execute(req);
            System.out.println(rsp.getBody());
        } catch (ApiException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
