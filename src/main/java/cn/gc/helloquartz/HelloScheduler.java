package cn.gc.helloquartz;

import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class HelloScheduler {
	public static void main(String[] args) throws SchedulerException {
		//创建一个jobDetail实列与创建的Job绑定
		JobDetail jobDetail=JobBuilder.newJob(HelloJob.class).withIdentity("myJob", "group1")
				//jobDetail和trigger均可以使用usingJobData方法传入参数  
				//在我们的Job实现类中均可以JobExecutionContext获取这些参数值
				.usingJobData("message", "jobDetail")
				.usingJobData("math", 8.20F)
				.build();
		//创建一个Trigger实列 定义该job立即执行 并每2秒执行一次  
		/*Trigger trigger=TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1")
				.usingJobData("message", "trigger")
				.usingJobData("math", 55.0D)
				//设置触发器执行的开始时间和结束时间
				//.startAt(new Date()).endAt(new Date())
				//表示程序一启动就立马执行 
				.startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().
						//每两秒  无线重复的执行下去
						withIntervalInSeconds(2).repeatForever()).build();*/
		
		SimpleTrigger trigger=(SimpleTrigger)TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1")
				.startAt(new Date())
				//.endAt(triggerEndTime)
				.withSchedule(SimpleScheduleBuilder
						.simpleSchedule()
						//2秒执行一次
						.withIntervalInMilliseconds(2)
						//一直执行下去
						//.withRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY)
						//执行多少次
						.withRepeatCount(10)).build();
	
		//输出jobDetail的name值“myJob”
		System.out.println(jobDetail.getKey().getName());
		//输出jobDetail的group分组名   如果在创建jobDetail时不设置分组  则默认分在DEFAULT分组中
		System.out.println(jobDetail.getKey().getGroup());
		//trigger（触发器和上面jobDetail是一样可以获取name值和分组名）
		System.out.println(trigger.getKey().getName());
		System.out.println(trigger.getKey().getGroup());
		//创建schedule实列
		SchedulerFactory sFactory=new StdSchedulerFactory();
		Scheduler  scheduler=sFactory.getScheduler();
		scheduler.start();
		scheduler.scheduleJob(jobDetail, trigger);
	}
	
	//使用Trigger实现定时器
	public void Trigger() throws SchedulerException{
		//创建一个jobDetail实列与创建的Job绑定
		JobDetail jobDetail=JobBuilder.newJob(HelloJob.class).withIdentity("myJob", "group1")
				//jobDetail和trigger均可以使用usingJobData方法传入参数  
				//在我们的Job实现类中均可以JobExecutionContext获取这些参数值
				.usingJobData("message", "jobDetail")
				.usingJobData("math", 8.20F)
				.build();
		//创建一个Trigger实列 定义该job立即执行 并每2秒执行一次  
		Trigger trigger=TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1")
				.usingJobData("message", "trigger")
				.usingJobData("math", 55.0D)
				//设置触发器执行的开始时间和结束时间
				//.startAt(new Date()).endAt(new Date())
				//表示程序一启动就立马执行 
				.startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().
						//每两秒  无线重复的执行下去
						withIntervalInSeconds(2).repeatForever()).build();
		//输出jobDetail的name值“myJob”
		System.out.println(jobDetail.getKey().getName());
		//输出jobDetail的group分组名   如果在创建jobDetail时不设置分组  则默认分在DEFAULT分组中
		System.out.println(jobDetail.getKey().getGroup());
		//trigger（触发器和上面jobDetail是一样可以获取name值和分组名）
		System.out.println(trigger.getKey().getName());
		System.out.println(trigger.getKey().getGroup());
		//创建schedule实列
		SchedulerFactory sFactory=new StdSchedulerFactory();
		Scheduler  scheduler=sFactory.getScheduler();
		scheduler.start();
		scheduler.scheduleJob(jobDetail, trigger);
	}
	//使用SimpleTrigger进行定时任务的执行
	public void SimpleTrigger() throws SchedulerException{
		//创建一个jobDetail实列与创建的Job绑定
				JobDetail jobDetail=JobBuilder.newJob(HelloJob.class).withIdentity("myJob", "group1")
						//jobDetail和trigger均可以使用usingJobData方法传入参数  
						//在我们的Job实现类中均可以JobExecutionContext获取这些参数值
						.usingJobData("message", "jobDetail")
						.usingJobData("math", 8.20F)
						.build();			
				SimpleTrigger trigger=(SimpleTrigger)TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1")
						.startAt(new Date())
						//.endAt(triggerEndTime)
						.withSchedule(SimpleScheduleBuilder
								.simpleSchedule()
								//2秒执行一次
								.withIntervalInMilliseconds(2)
								//一直执行下去
								//.withRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY)
								//执行多少次
								.withRepeatCount(10)).build();
			
				//输出jobDetail的name值“myJob”
				System.out.println(jobDetail.getKey().getName());
				//输出jobDetail的group分组名   如果在创建jobDetail时不设置分组  则默认分在DEFAULT分组中
				System.out.println(jobDetail.getKey().getGroup());
				//trigger（触发器和上面jobDetail是一样可以获取name值和分组名）
				System.out.println(trigger.getKey().getName());
				System.out.println(trigger.getKey().getGroup());
				//创建schedule实列
				SchedulerFactory sFactory=new StdSchedulerFactory();
				Scheduler  scheduler=sFactory.getScheduler();
				scheduler.start();
				scheduler.scheduleJob(jobDetail, trigger);
	}
	
	//使用CronTrigger 来进行定时任务的调度   CornTrigger最强大  最常用
	public void CronTrigger(){
		//创建一个JobDetail与Job实列绑定                                         //不传入分组参数时  默认属于DEFAULT分组中
		JobDetail jobDetail=JobBuilder.newJob(HelloJob.class).withIdentity("myJob").build();
		CronTrigger trigger=(CronTrigger) TriggerBuilder.newTrigger()
				.withIdentity("cronTrigger", "group1")
				.withSchedule(
						//创建Cron表达式    格式（秒 分 时  日  月 周 年）
														//这个表示没秒都执行				
						CronScheduleBuilder.cronSchedule("* * * * ? * *")
						).build();
}
}