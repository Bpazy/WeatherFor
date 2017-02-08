package xyz.bpazy.weatherfor.helper;

import xyz.bpazy.weatherfor.models.Config;

import java.io.*;

/**
 * Created by Ziyuan
 * on 2017/2/8
 */
public class ConfigHelper {
    
    public static Config getConfig() {
        BufferedReader reader = getConfigReader();
        return JsonUtils.fromJson(reader, Config.class);
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
}
