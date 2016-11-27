package xyz.bpazy.weatherfor.impl;

import com.github.kevinsawicki.http.HttpRequest;
import xyz.bpazy.weatherfor.api.WeatherClient;
import xyz.bpazy.weatherfor.helper.JsonUtils;
import xyz.bpazy.weatherfor.models.XinZhiModel;

/**
 * Created by Ziyuan.
 * 2016/11/26 22:29
 */
public class DefaultWeatherClient implements WeatherClient<XinZhiModel> {

    private static final String KEY = "lyiogbra1v2euq1k";

    @Override
    public XinZhiModel getDailyWeather(String city, int start, int days) {
        String body = "";
        for (int i = 0; i < 3; i++) {
            body = getWeather(city, start, days);
        }
        if ("".equals(body)) throw new RuntimeException();
        return JsonUtils.fromJson(body, XinZhiModel.class);
    }

    private String getWeather(String city, int start, int days) {
        return HttpRequest.get("https://api.thinkpage.cn/v3/weather/daily.json", true,
                "key", KEY,
                "location", city,
                "start", start,
                "days", days).body();
    }
}
