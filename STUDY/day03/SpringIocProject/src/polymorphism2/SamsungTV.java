package polymorphism2;

public class SamsungTV implements TV {
	private Speaker speaker;

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public void powerOn(){
		System.out.println("SamsungTV---������ �Ҵ�.");
	}
	public void powerOff(){
		System.out.println("SamsungTV---������ ����.");
	}
	public void volumeUp(){
		speaker.volumeUp();
	}
	public void volumeDown(){
		speaker.volumeDown();
	}
}
