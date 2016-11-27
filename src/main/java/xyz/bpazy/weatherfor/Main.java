package xyz.bpazy.weatherfor;

import xyz.bpazy.weatherfor.api.Activity;
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
        BufferedReader reader = getConfigReader();
        Config config = JsonUtils.fromJson(reader, Config.class);
        Timer timer = new Timer();
        Date time = getCalendarFromConfig(config);
        timer.schedule(new Activity() {
            @Override
            public void exec() {
                App app = new App(config);
                app.addSender(new AliMessage());
                app.run();
            }
        }, time, config.getInterval() * 1000 * 60 * 60);
    }

    private static BufferedReader getConfigReader() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("weatherFor.json"), "UTF8"));
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return reader;
    }

    private static Date getCalendarFromConfig(Config config) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, config.getHour());
        cal.set(Calendar.MINUTE, config.getMinute());
        cal.set(Calendar.SECOND, config.getSecond());
        if (cal.getTime().before(new Date())) cal.add(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }
}
