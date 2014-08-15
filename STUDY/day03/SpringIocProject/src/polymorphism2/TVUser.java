package polymorphism2;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class TVUser {
	public static void main(String[] args) {		
		// 객체 공장을 생성한다.
//		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		ApplicationContext factory = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 공장으로부터 필요한 객체를 얻어낸다.
		TV tv = (TV)factory.getBean("lgTV");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}
}











