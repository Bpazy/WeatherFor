package xyz.bpazy.weatherfor.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.bpazy.weatherfor.models.Config;

import java.io.*;

/**
 * Created by Ziyuan
 * on 2017/2/8
 */
public class ConfigHelper {
    private static Logger logger = LoggerFactory.getLogger(ConfigHelper.class);

    public static Config getConfig() {
        BufferedReader reader = getConfigReader();
        return JsonUtils.fromJson(reader, Config.class);
    }

    private static BufferedReader getConfigReader() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("weatherFor.json"), "UTF8"));
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            logger.error("没有找到配置文件", e);
            System.exit(0);
        }
        return reader;
    }
}
