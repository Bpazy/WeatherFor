package xyz.bpazy.weatherfor;

import xyz.bpazy.weatherfor.api.Activity;
import xyz.bpazy.weatherfor.helper.ConfigHelper;
import xyz.bpazy.weatherfor.helper.JsonUtils;
import xyz.bpazy.weatherfor.impl.AliMessage;
import xyz.bpazy.weatherfor.impl.App;
import xyz.bpazy.weatherfor.models.Config;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * Created by Ziyuan.
 * 2016/11/27 11:28
 */
public class Main {
    public static void main(String[] args) {
        Config config = ConfigHelper.getConfig();
        Timer timer = new Timer();
        timer.schedule(new Activity() {
            @Override
            public void exec() {
                App app = new App();
                app.addSender(new AliMessage());
                app.run();
            }
        }, config.getDate(), config.getInterval() * 1000 * 60 * 60);
    }
}
