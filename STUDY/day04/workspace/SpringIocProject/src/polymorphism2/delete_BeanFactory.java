package polymorphism2;

public class delete_BeanFactory {
	public Object getBean(String beanName) {
		if(beanName.equals("samsung")) {
			return new SamsungTV();
		} else if(beanName.equals("lg")) {
			return new LGTV();
		}
		return null;
	}
}
