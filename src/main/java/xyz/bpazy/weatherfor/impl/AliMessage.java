package xyz.bpazy.weatherfor.impl;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.bpazy.weatherfor.api.Message;
import xyz.bpazy.weatherfor.base.dayu.DayuAppKey;
import xyz.bpazy.weatherfor.helper.JsonUtils;
import xyz.bpazy.weatherfor.models.SmsWeather;
import xyz.bpazy.weatherfor.models.XinZhiModel.XinZhiModelResult.Daily;

import java.io.*;

/**
 * Created by Ziyuan.
 * 2016/11/27 11:48
 */
public class AliMessage implements Message<Daily> {
    private static final String url = "http://gw.api.taobao.com/router/rest";
    private static DayuAppKey appKey;

    public AliMessage() {
        appKey = getConfig();
    }

    private Logger logger = LoggerFactory.getLogger(AliMessage.class);

    @Override
    public void sendMessage(String target, Daily daily) {
        logger.info("Send to: {}", target);
        TaobaoClient client = new DefaultTaobaoClient(url, appKey.getAppKey(), appKey.getAppSecret());
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
            logger.info("{}", rsp.getBody());
        } catch (ApiException e) {
            logger.error("淘宝Client错误", e);
        }
    }

    private DayuAppKey getConfig() {
        BufferedReader reader = getConfigReader();
        return JsonUtils.fromJson(reader, DayuAppKey.class);
    }

    private BufferedReader getConfigReader() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("alidayu.json"), "UTF8"));
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            logger.error("没有找到配置文件", e);
            System.exit(0);
        }
        return reader;
    }
}
