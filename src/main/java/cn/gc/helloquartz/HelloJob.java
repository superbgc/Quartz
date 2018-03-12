package cn.gc.helloquartz;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.TriggerKey;
/**
 * Quartz 业务逻辑层  实现Job 重写execute方法
 * 
 *  主要三个组件  Job Scheduler  trieger
 * @author Superb
 *
 */
public class HelloJob implements Job{
	private String message;
	private double math;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public double getMath() {
		return math;
	}

	public void setMath(double math) {
		this.math = math;
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		Date date=new Date();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(simpleDateFormat.format(date));
		//获取该job的基本信息  name是什么 属于哪个组
		JobKey key=context.getJobDetail().getKey();
		key.getName();
		key.getGroup();
		TriggerKey triggerKey=context.getTrigger().getKey();
		triggerKey.getName();
		triggerKey.getGroup();
		/*获取Scheduler传入JobDetail中的参数  和trigger中的参数 
		(1.直接从Map中获取，2.Job实现类添加对应Map中键值的属性，并加get set方法，然后使用属性自动会获取相应的值)*/
		//第一种方法
		//分开获取JobDetail和trigger的JobDataMap
		/*还可以拿到他们共同的JobDataMap  这种情况当jobDatil和trigger中有key值相同的情况  
		jobDataMap只获取trigger中的参数值
		JobDataMap mergerdDataMap=context.getMergedJobDataMap();*/
		/*JobDataMap jobDataMap=context.getJobDetail().getJobDataMap();
		String jobMessage=jobDataMap.getString("message");
		System.out.println(jobMessage);
		float f=jobDataMap.getFloat("math");
		System.out.println(f);
		JobDataMap triggerDataMap=context.getTrigger().getJobDataMap();
		String triMessage=triggerDataMap.getString("message");
		System.out.println(triMessage);
		double d=triggerDataMap.getDouble("math");
		System.out.println(d);*/
		
		//第二种方法  建立JobDataMap中对应键值的成员属性 加上get set方法 直接拿去成员变量得值
		System.out.println(message);
		System.out.println(math);
	}

}
