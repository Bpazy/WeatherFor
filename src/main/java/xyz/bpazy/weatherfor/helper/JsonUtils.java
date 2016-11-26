package xyz.bpazy.weatherfor.helper;

import com.google.gson.Gson;

import java.io.Reader;

/**
 * Created by Ziyuan.
 * 2016/11/26 22:49
 */
public class JsonUtils {
    private static Gson gson = new Gson();

    public static <T> T fromJson(String json, Class<T> c) {
        return gson.fromJson(json, c);
    }

    public static String toJson(Object src) {
        return gson.toJson(src);
    }

    public static <T> T fromJson(Reader reader, Class<T> src) {
        return gson.fromJson(reader, src);
    }
}
