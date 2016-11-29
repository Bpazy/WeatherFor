package xyz.bpazy.weatherfor.impl;

import xyz.bpazy.weatherfor.api.Message;
import xyz.bpazy.weatherfor.api.WeatherClient;
import xyz.bpazy.weatherfor.api.WeatherDaily;
import xyz.bpazy.weatherfor.models.Config;
import xyz.bpazy.weatherfor.models.XinZhiModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ziyuan.
 * 2016/11/26 22:45
 */
public class App {
    private ArrayList<Message<WeatherDaily>> sender = new ArrayList<>();
    private Config config;

    public App(Config config) {
        this.config = config;
    }

    public void run() {
        List<Config.NumsBean> nums = config.getNums();
        WeatherClient<XinZhiModel> weatherClient = new DefaultWeatherClient();
        for (Config.NumsBean numBean : nums) {
            try {
                List<XinZhiModel.XinZhiModelResult> results =
                        weatherClient.getDailyWeather(numBean.getLocation(), 0, 1).getResults();
                XinZhiModel.XinZhiModelResult xinZhiModelResult = results.get(0);
                for (Message<WeatherDaily> m : sender) {
                    m.sendMessage(numBean.getNum(), xinZhiModelResult.getDaily().get(0));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setSender(Message message) {
        sender.clear();
        sender.add(message);
    }

    public void addSender(Message message) {
        sender.add(message);
    }
}
