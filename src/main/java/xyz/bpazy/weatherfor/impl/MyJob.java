package xyz.bpazy.weatherfor.impl;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by Ziyuan
 * on 2017/4/11
 */
public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        App app = new App();
        app.addSender(new AliMessage());
        app.run();
    }
}
