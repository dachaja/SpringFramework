package polymorphism2;

public class AppleSpeaker implements Speaker {
	public void volumeUp(){
		System.out.println("AppleSpeaker---소리를 올린다.");
	}
	public void volumeDown(){
		System.out.println("AppleSpeaker---소리를 내린다.");
	}
}
