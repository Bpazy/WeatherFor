package xyz.bpazy.weatherfor.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.bpazy.weatherfor.api.Message;
import xyz.bpazy.weatherfor.api.WeatherClient;
import xyz.bpazy.weatherfor.base.config.Num;
import xyz.bpazy.weatherfor.helper.ConfigHelper;
import xyz.bpazy.weatherfor.models.XinZhiModel;
import xyz.bpazy.weatherfor.models.XinZhiModel.XinZhiModelResult.Daily;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ziyuan.
 * 2016/11/26 22:45
 */
public class App {
    private ArrayList<Message<Daily>> sender = new ArrayList<>();
    private Logger logger = LoggerFactory.getLogger(App.class);

    public void run() {
        logger.info("App run.{}", LocalDateTime.now());
        List<Num> nums = ConfigHelper.getConfig().getNums();
        WeatherClient<XinZhiModel> weatherClient = new DefaultWeatherClient();
        for (Num num : nums) {
            try {
                List<XinZhiModel.XinZhiModelResult> results =
                        weatherClient.getDailyWeather(num.getLocation(), 0, 1).getResults();
                XinZhiModel.XinZhiModelResult xinZhiModelResult = results.get(0);
                logger.info("Weather: {}", xinZhiModelResult);
                for (Message<Daily> m : sender) {
                    m.sendMessage(num.getNum(), xinZhiModelResult.getDaily().get(0));
                }
            } catch (Exception e) {
                logger.error("网络错误", e);
            }
        }
    }

    public void addSender(Message<Daily> message) {
        sender.add(message);
    }
}
