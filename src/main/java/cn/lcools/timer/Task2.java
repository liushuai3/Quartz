package cn.lcools.timer;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Copyright: Copyright (c) 2020
 *
 * @ClassName: Task
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: liushuai
 * @date: 2020/7/14 16:10
 * *****
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2020/7/14     liushuai           v1.0.0               修改原因
 */
public class Task2 implements Job {
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("22222222222222222222222222"+jobExecutionContext.getJobDetail().getJobDataMap().get("j2"));
    }
}
