package xyz.bpazy.weatherfor;

import xyz.bpazy.weatherfor.api.Activity;
import xyz.bpazy.weatherfor.helper.JsonUtils;
import xyz.bpazy.weatherfor.impl.AliMessage;
import xyz.bpazy.weatherfor.impl.App;
import xyz.bpazy.weatherfor.models.Config;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Timer;

/**
 * Created by Ziyuan.
 * 2016/11/27 11:28
 */
public class Main {
    public static void main(String[] args) {
        BufferedReader reader = getConfigReader();
        Config config = JsonUtils.fromJson(reader, Config.class);
        Timer timer = new Timer();
        Calendar calendar = getCalendarFromConfig(config);
        timer.schedule(new Activity() {
            @Override
            public void exec() {
                App app = new App(config);
                app.addSender(new AliMessage());
                app.run();
            }
        }, calendar.getTime(), config.getInterval());
    }

    private static BufferedReader getConfigReader() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("example/weatherFor.json")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return reader;
    }

    private static Calendar getCalendarFromConfig(Config config) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, config.getHour());
        calendar.set(Calendar.MINUTE, config.getMinute());
        calendar.set(Calendar.SECOND, config.getSecond());
        return calendar;
    }
}
