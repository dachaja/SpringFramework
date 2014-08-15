package polymorphism2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("samsung")
public class SamsungTV implements TV {
	@Autowired
	@Qualifier("appleSpeaker")
	//JDK 1.6 or Tomcat 6.0 or higher
	//@Resource(name="appleSpeaker");
	private Speaker speaker;

	public SamsungTV() {
		super();
		// TODO Auto-generated constructor stub
	}

	// constructor injection
	// public SamsungTV(SonySpeaker speaker) {
	// ioc 역제어
	public SamsungTV(Speaker speaker) {
		super();
		System.out.println("SamsungTV ---> 객체  생성");
		this.speaker = speaker;
	}

	// setter injection
	public void setInjection(Speaker speaker) {
		System.out.println("---> setter method 호출...");
		this.speaker = speaker;
	}

	public void setSpeaker(Speaker speaker) {
		System.out.println("---> setter setSpeaker method 호출...");
		this.speaker = speaker;
	}

	public void init() {
		System.out.println("--->SamsungTV init called...");
	}

	public void destory() {
		System.out.println("--->SamsungTV destory called...");
	}

	public void powerOn() {
		System.out.println("SamsungTV---전원을 켠다.");
	}

	public void powerOff() {
		System.out.println("SamsungTV---전원을 끈다.");
	}

	public void volumeUp() {
		// example 1
		// System.out.println("SamsungTV---소리를 올린다.");

		// example 2 - 순제어 방식
		// speaker = new SonySpeaker();
		// speaker.volumeUp();

		// example 3 - construction injection
		speaker.volumeUp();
	}

	public void volumeDown() {
		// example 1
		// System.out.println("SamsungTV---소리를 내린다.");

		// example 2 - 순제어 방식
		// speaker = new SonySpeaker();
		// speaker.volumeDown();

		// example 3 - construction injection
		speaker.volumeDown();

	}
}
