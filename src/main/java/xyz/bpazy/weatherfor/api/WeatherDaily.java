package xyz.bpazy.weatherfor.api;

/**
 * Created by Ziyuan.
 * 2016/11/29 14:16
 * <p>
 * 每日天气
 */
public interface WeatherDaily {
    /**
     * 获取白天天气
     *
     * @return 天气
     */
    String getTextDay();

    /**
     * 获取最低气温
     *
     * @return 最低气温
     */
    String getLow();

    /**
     * 获取最高气温
     *
     * @return 最高气温
     */
    String getHigh();

    /**
     * 获取风向
     *
     * @return 风向
     */
    String getWindDirection();

    /**
     * 获取风力等级
     *
     * @return 风力等级
     */
    String getWindScale();
}
