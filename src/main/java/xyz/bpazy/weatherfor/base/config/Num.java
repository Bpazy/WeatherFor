package xyz.bpazy.weatherfor.base.config;

/**
 * Created by Ziyuan
 * on 2017/4/11
 */
public class Num {
    private String num;
    private String location;
    private String cron;

    @Override
    public String toString() {
        return "Num{" +
                "num='" + num + '\'' +
                ", location='" + location + '\'' +
                ", cron='" + cron + '\'' +
                '}';
    }

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

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }
}