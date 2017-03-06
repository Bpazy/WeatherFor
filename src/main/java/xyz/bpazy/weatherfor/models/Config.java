package xyz.bpazy.weatherfor.models;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Ziyuan.
 * 2016/11/27 0:54
 */
public class Config {

    private int hour;
    private int minute;
    private int second;
    private int interval;
    private List<Nums> nums;

    public Date getDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, this.getHour());
        cal.set(Calendar.MINUTE, this.getMinute());
        cal.set(Calendar.SECOND, this.getSecond());
        if (cal.getTime().before(new Date())) cal.add(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
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

    public List<Nums> getNums() {
        return nums;
    }

    public void setNums(List<Nums> nums) {
        this.nums = nums;
    }

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

    public static class Nums {

        private String num;
        private String location;

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        @Override
        public String toString() {
            return "Nums{" +
                    "num='" + num + '\'' +
                    ", location='" + location + '\'' +
                    '}';
        }
    }
}
