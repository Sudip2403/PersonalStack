package test;

public class Assert {

	public static boolean check(String a, String b) {
		return a.equals(b);
	}

	public static boolean check(int a, int b) {
		return a == b;
	}

	public static boolean check(long a, long b) {
		return a == b;
	}

	public static boolean check(Double a, Double b) {
		return a.compareTo(b) == 0;
	}
}
