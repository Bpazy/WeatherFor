package xyz.bpazy.weatherfor.impl;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import xyz.bpazy.weatherfor.api.Message;
import xyz.bpazy.weatherfor.helper.JsonUtils;
import xyz.bpazy.weatherfor.models.SmsWeather;
import xyz.bpazy.weatherfor.models.XinZhiModel;

/**
 * Created by Ziyuan.
 * 2016/11/27 11:48
 */
public class AliMessage implements Message {
    private String url = "http://gw.api.taobao.com/router/rest";
    private String appkey = "23547902";
    private String secret = "411d353292ea57c0689579d84fad6fc8";
    private TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);

    @Override
    public void sendMessage(String target, XinZhiModel.XinZhiModelResult.DailyBean daily) {
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
        req.setRecNum(target);
        req.setSmsTemplateCode("SMS_30115191");
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
