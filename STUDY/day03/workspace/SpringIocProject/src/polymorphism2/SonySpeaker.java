package polymorphism2;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker{
	public void volumeUp() {
		System.out.println("SonySpeaker---소리를 올린다.");
	}
	public void volumeDown() {
		System.out.println("SonySpeaker---소리를 내린다.");
	}
}
