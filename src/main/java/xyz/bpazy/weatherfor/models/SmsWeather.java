package xyz.bpazy.weatherfor.models;

/**
 * Created by Ziyuan.
 * 2016/11/26 19:44
 */
public class SmsWeather {
    /**
     * date : 2016-11-27
     * content : 多云 1℃-12℃ 北南风3级
     */

    private String date;
    private String content;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
