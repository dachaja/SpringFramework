package polymorphism2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		// 객체 공장을 생성한다.
		//example 1
		//delete_BeanFactory factory = new delete_BeanFactory();
		
		//example 2
		//BeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		
		//example 3
		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//example 4
		//ApplicationContext factory = new FileSystemXmlApplicationContext("resources/applicationContext.xml");
		
		// 공장으로부터 필요한 객체를 얻어낸다.
		//example 1
		TV tv = (TV)factory.getBean("samsung");
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		//example 2
//		TV tv1_a = new SamsungTV();
//		TV tv2_a = new SamsungTV();
//		TV tv3_a = new SamsungTV();
		
		//example 3
//		TV tv1 = (TV)factory.getBean("samsung");
//		TV tv2 = (TV)factory.getBean("samsung");
//		TV tv3 = (TV)factory.getBean("samsung");
	}
}
