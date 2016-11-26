package xyz.bpazy.weatherfor.api;

import java.util.TimerTask;

/**
 * Created by Ziyuan.
 * 2016/11/27 0:10
 */
public abstract class Activity extends TimerTask {
    @Override
    public void run() {
        exec();
    }

    public abstract void exec();
}
