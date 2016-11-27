package xyz.bpazy.weatherfor.impl;

import xyz.bpazy.weatherfor.api.Message;
import xyz.bpazy.weatherfor.api.WeatherClient;
import xyz.bpazy.weatherfor.models.Config;
import xyz.bpazy.weatherfor.models.XinZhiModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ziyuan.
 * 2016/11/26 22:45
 */
public class App {
    private ArrayList<Message> sender = new ArrayList<>();
    private Config config;

    public App(Config config) {
        this.config = config;
    }

    public void run() {
        List<Config.NumsBean> nums = config.getNums();
        WeatherClient<XinZhiModel> weatherClient = new DefaultWeatherClient();
        for (Config.NumsBean numBean : nums) {
            XinZhiModel.XinZhiModelResult xinZhiModelResult = weatherClient.getDailyWeather(numBean.getLocation(), 0,
                    1).getResults().get(0);
            for (Message m : sender) {
                m.sendMessage(numBean.getNum(), xinZhiModelResult.getDaily().get(0)); //TODO 增加天气接口
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
