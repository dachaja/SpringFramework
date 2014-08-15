package polymorphism2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("lg")
public class LGTV implements TV {
	@Autowired
	@Qualifier("appleSpeaker")
	private Speaker speaker;
	
	public LGTV() {
		super();
		System.out.println("LGTV ---> 객체  생성");
	}

	public void powerOn() {
		System.out.println("LGTV---전원을 켠다.");
	}

	public void powerOff() {
		System.out.println("LGTV---전원을 끈다.");
	}

	public void volumeUp() {
//		System.out.println("LGTV---소리를 올린다.");
		speaker.volumeUp();
	}

	public void volumeDown() {
//		System.out.println("LGTV---소리를 내린다.");
		speaker.volumeDown();
	}
}
