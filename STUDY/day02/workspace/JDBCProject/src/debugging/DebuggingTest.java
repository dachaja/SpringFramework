package debugging;

public class DebuggingTest {
	public static void main(String[] args) {
		System.out.println("process start....");

		callMethodA(10);
		callMethodB();

		System.out.println("process end....");
	}

	private static void callMethodB() {
		for (int i = 0; i < 9; i++) {
			System.out.println(i + "번째 숫자");
		}
	}

	private static void callMethodA(int i) {
		System.out.println(i);
	}
}
