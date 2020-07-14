package cn.lcools.timer;

import org.junit.Test;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Copyright: Copyright (c) 2020
 *
 * @ClassName: TimerTest
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: liushuai
 * @date: 2020/7/14 16:11
 * *****
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2020/7/14     liushuai           v1.0.0               修改原因
 */
public class TimerTest {

    @Test
    public void test() throws Exception {
        //创建一个scheduler
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.getContext().put("skey", "svalue");

        //创建一个Trigger

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .usingJobData("t1", "tv1")
                .withSchedule(CronScheduleBuilder.cronSchedule("1/5 * * * * ? *")).build();

        //创建一个job
        JobDetail job = JobBuilder.newJob(Task.class)
                .usingJobData("j1", "jv1")
                .withIdentity("myjob", "mygroup").build();


        Trigger trigger2 = TriggerBuilder.newTrigger()
                .withIdentity("trigger2", "group1")
                .usingJobData("t2", "tv2")
                .withSchedule(CronScheduleBuilder.cronSchedule("1/2 * * * * ? *")).build();

        JobDetail job2 = JobBuilder.newJob(Task2.class)
                .usingJobData("j2", "jv2")
                .withIdentity("myjob2", "mygroup").build();

        //注册trigger并启动scheduler
        scheduler.scheduleJob(job, trigger);
        scheduler.scheduleJob(job2, trigger2);
        scheduler.start();

        Thread.sleep(100000000);
    }
}
