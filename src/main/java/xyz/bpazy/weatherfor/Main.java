package xyz.bpazy.weatherfor;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.bpazy.weatherfor.api.Activity;
import xyz.bpazy.weatherfor.base.config.Config;
import xyz.bpazy.weatherfor.base.config.Num;
import xyz.bpazy.weatherfor.helper.ConfigHelper;
import xyz.bpazy.weatherfor.impl.AliMessage;
import xyz.bpazy.weatherfor.impl.App;
import xyz.bpazy.weatherfor.impl.MyJob;

import java.util.List;
import java.util.Timer;

/**
 * Created by Ziyuan.
 * 2016/11/27 11:28
 */
public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws SchedulerException {
        Config config = ConfigHelper.getConfig();
        logger.info("载入配置文件成功: {}", config);

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        List<Num> nums = config.getNums();
        for (Num num : nums) {
            scheduler.scheduleJob(buildJobDetail(num), buildCronTrigger(num));
        }
        scheduler.start();
    }

    private static JobDetail buildJobDetail(Num num) {
        return JobBuilder.newJob(MyJob.class)
                        .withIdentity("job" + num.getNum(), "group1")
                        .build();
    }

    private static CronTrigger buildCronTrigger(Num num) {
        return TriggerBuilder.newTrigger()
                        .withIdentity("trigger" + num.getNum(), "group1")
                        .withSchedule(CronScheduleBuilder.cronSchedule(num.getCron()))
                        .build();
    }
}
