package xyz.bpazy.weatherfor.api;

import xyz.bpazy.weatherfor.models.XinZhiModel;

/**
 * Created by Ziyuan.
 * 2016/11/27 11:29
 */
public interface Message {
    void sendMessage(String target, XinZhiModel.XinZhiModelResult.DailyBean daily);
}
