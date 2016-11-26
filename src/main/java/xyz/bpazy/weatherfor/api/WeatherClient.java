package xyz.bpazy.weatherfor.api;

/**
 * Created by Ziyuan.
 * 2016/11/26 22:34
 */
public interface WeatherClient<T> {
    T getDailyWeather(String city, int start, int days);
}
