package xyz.bpazy.weatherfor.api;

/**
 * Created by Ziyuan.
 * 2016/11/27 11:29
 */
public interface Message<T extends WeatherDaily> {
    void sendMessage(String target, T daily);
}
