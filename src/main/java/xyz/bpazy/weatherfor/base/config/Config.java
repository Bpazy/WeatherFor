package xyz.bpazy.weatherfor.base.config;

import java.util.List;

/**
 * Created by Ziyuan.
 * 2016/11/27 0:54
 */
public class Config {
    private List<Num> nums;

    public List<Num> getNums() {
        return nums;
    }

    public void setNums(List<Num> nums) {
        this.nums = nums;
    }

    @Override
    public String toString() {
        return "Config{" +
                "nums=" + nums +
                '}';
    }
}
