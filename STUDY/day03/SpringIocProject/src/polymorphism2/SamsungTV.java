package polymorphism2;

public class SamsungTV implements TV {
	private Speaker speaker;

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public void powerOn(){
		System.out.println("SamsungTV---전원을 켠다.");
	}
	public void powerOff(){
		System.out.println("SamsungTV---전원을 끈다.");
	}
	public void volumeUp(){
		speaker.volumeUp();
	}
	public void volumeDown(){
		speaker.volumeDown();
	}
}
