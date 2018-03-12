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
		//����һ��jobDetailʵ���봴����Job��
		JobDetail jobDetail=JobBuilder.newJob(HelloJob.class).withIdentity("myJob", "group1")
				//jobDetail��trigger������ʹ��usingJobData�����������  
				//�����ǵ�Jobʵ�����о�����JobExecutionContext��ȡ��Щ����ֵ
				.usingJobData("message", "jobDetail")
				.usingJobData("math", 8.20F)
				.build();
		//����һ��Triggerʵ�� �����job����ִ�� ��ÿ2��ִ��һ��  
		/*Trigger trigger=TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1")
				.usingJobData("message", "trigger")
				.usingJobData("math", 55.0D)
				//���ô�����ִ�еĿ�ʼʱ��ͽ���ʱ��
				//.startAt(new Date()).endAt(new Date())
				//��ʾ����һ����������ִ�� 
				.startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().
						//ÿ����  �����ظ���ִ����ȥ
						withIntervalInSeconds(2).repeatForever()).build();*/
		
		SimpleTrigger trigger=(SimpleTrigger)TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1")
				.startAt(new Date())
				//.endAt(triggerEndTime)
				.withSchedule(SimpleScheduleBuilder
						.simpleSchedule()
						//2��ִ��һ��
						.withIntervalInMilliseconds(2)
						//һֱִ����ȥ
						//.withRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY)
						//ִ�ж��ٴ�
						.withRepeatCount(10)).build();
	
		//���jobDetail��nameֵ��myJob��
		System.out.println(jobDetail.getKey().getName());
		//���jobDetail��group������   ����ڴ���jobDetailʱ�����÷���  ��Ĭ�Ϸ���DEFAULT������
		System.out.println(jobDetail.getKey().getGroup());
		//trigger��������������jobDetail��һ�����Ի�ȡnameֵ�ͷ�������
		System.out.println(trigger.getKey().getName());
		System.out.println(trigger.getKey().getGroup());
		//����scheduleʵ��
		SchedulerFactory sFactory=new StdSchedulerFactory();
		Scheduler  scheduler=sFactory.getScheduler();
		scheduler.start();
		scheduler.scheduleJob(jobDetail, trigger);
	}
	
	//ʹ��Triggerʵ�ֶ�ʱ��
	public void Trigger() throws SchedulerException{
		//����һ��jobDetailʵ���봴����Job��
		JobDetail jobDetail=JobBuilder.newJob(HelloJob.class).withIdentity("myJob", "group1")
				//jobDetail��trigger������ʹ��usingJobData�����������  
				//�����ǵ�Jobʵ�����о�����JobExecutionContext��ȡ��Щ����ֵ
				.usingJobData("message", "jobDetail")
				.usingJobData("math", 8.20F)
				.build();
		//����һ��Triggerʵ�� �����job����ִ�� ��ÿ2��ִ��һ��  
		Trigger trigger=TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1")
				.usingJobData("message", "trigger")
				.usingJobData("math", 55.0D)
				//���ô�����ִ�еĿ�ʼʱ��ͽ���ʱ��
				//.startAt(new Date()).endAt(new Date())
				//��ʾ����һ����������ִ�� 
				.startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().
						//ÿ����  �����ظ���ִ����ȥ
						withIntervalInSeconds(2).repeatForever()).build();
		//���jobDetail��nameֵ��myJob��
		System.out.println(jobDetail.getKey().getName());
		//���jobDetail��group������   ����ڴ���jobDetailʱ�����÷���  ��Ĭ�Ϸ���DEFAULT������
		System.out.println(jobDetail.getKey().getGroup());
		//trigger��������������jobDetail��һ�����Ի�ȡnameֵ�ͷ�������
		System.out.println(trigger.getKey().getName());
		System.out.println(trigger.getKey().getGroup());
		//����scheduleʵ��
		SchedulerFactory sFactory=new StdSchedulerFactory();
		Scheduler  scheduler=sFactory.getScheduler();
		scheduler.start();
		scheduler.scheduleJob(jobDetail, trigger);
	}
	//ʹ��SimpleTrigger���ж�ʱ�����ִ��
	public void SimpleTrigger() throws SchedulerException{
		//����һ��jobDetailʵ���봴����Job��
				JobDetail jobDetail=JobBuilder.newJob(HelloJob.class).withIdentity("myJob", "group1")
						//jobDetail��trigger������ʹ��usingJobData�����������  
						//�����ǵ�Jobʵ�����о�����JobExecutionContext��ȡ��Щ����ֵ
						.usingJobData("message", "jobDetail")
						.usingJobData("math", 8.20F)
						.build();			
				SimpleTrigger trigger=(SimpleTrigger)TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1")
						.startAt(new Date())
						//.endAt(triggerEndTime)
						.withSchedule(SimpleScheduleBuilder
								.simpleSchedule()
								//2��ִ��һ��
								.withIntervalInMilliseconds(2)
								//һֱִ����ȥ
								//.withRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY)
								//ִ�ж��ٴ�
								.withRepeatCount(10)).build();
			
				//���jobDetail��nameֵ��myJob��
				System.out.println(jobDetail.getKey().getName());
				//���jobDetail��group������   ����ڴ���jobDetailʱ�����÷���  ��Ĭ�Ϸ���DEFAULT������
				System.out.println(jobDetail.getKey().getGroup());
				//trigger��������������jobDetail��һ�����Ի�ȡnameֵ�ͷ�������
				System.out.println(trigger.getKey().getName());
				System.out.println(trigger.getKey().getGroup());
				//����scheduleʵ��
				SchedulerFactory sFactory=new StdSchedulerFactory();
				Scheduler  scheduler=sFactory.getScheduler();
				scheduler.start();
				scheduler.scheduleJob(jobDetail, trigger);
	}
	
	//ʹ��CronTrigger �����ж�ʱ����ĵ���   CornTrigger��ǿ��  ���
	public void CronTrigger(){
		//����һ��JobDetail��Jobʵ�а�                                         //������������ʱ  Ĭ������DEFAULT������
		JobDetail jobDetail=JobBuilder.newJob(HelloJob.class).withIdentity("myJob").build();
		CronTrigger trigger=(CronTrigger) TriggerBuilder.newTrigger()
				.withIdentity("cronTrigger", "group1")
				.withSchedule(
						//����Cron���ʽ    ��ʽ���� �� ʱ  ��  �� �� �꣩
														//�����ʾû�붼ִ��				
						CronScheduleBuilder.cronSchedule("* * * * ? * *")
						).build();
}
}