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
 * Quartz ҵ���߼���  ʵ��Job ��дexecute����
 * 
 *  ��Ҫ�������  Job Scheduler  trieger
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
		//��ȡ��job�Ļ�����Ϣ  name��ʲô �����ĸ���
		JobKey key=context.getJobDetail().getKey();
		key.getName();
		key.getGroup();
		TriggerKey triggerKey=context.getTrigger().getKey();
		triggerKey.getName();
		triggerKey.getGroup();
		/*��ȡScheduler����JobDetail�еĲ���  ��trigger�еĲ��� 
		(1.ֱ�Ӵ�Map�л�ȡ��2.Jobʵ������Ӷ�ӦMap�м�ֵ�����ԣ�����get set������Ȼ��ʹ�������Զ����ȡ��Ӧ��ֵ)*/
		//��һ�ַ���
		//�ֿ���ȡJobDetail��trigger��JobDataMap
		/*�������õ����ǹ�ͬ��JobDataMap  ���������jobDatil��trigger����keyֵ��ͬ�����  
		jobDataMapֻ��ȡtrigger�еĲ���ֵ
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
		
		//�ڶ��ַ���  ����JobDataMap�ж�Ӧ��ֵ�ĳ�Ա���� ����get set���� ֱ����ȥ��Ա������ֵ
		System.out.println(message);
		System.out.println(math);
	}

}
