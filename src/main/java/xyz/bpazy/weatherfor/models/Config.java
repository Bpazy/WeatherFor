package xyz.bpazy.weatherfor.models;

import java.util.List;

/**
 * Created by Ziyuan.
 * 2016/11/27 0:54
 */
public class Config {
    /**
     * nums : ["18651242070","15651298066"]
     * hour : 24
     * minute : 0
     * second : 0
     * interval : 24
     */

    private int hour;
    private int minute;
    private int second;
    private int interval;
    private List<String> nums;

    @Override
    public String toString() {
        return "Config{" +
                "hour=" + hour +
                ", minute=" + minute +
                ", second=" + second +
                ", interval=" + interval +
                ", nums=" + nums +
                '}';
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public List<String> getNums() {
        return nums;
    }

    public void setNums(List<String> nums) {
        this.nums = nums;
    }
}
