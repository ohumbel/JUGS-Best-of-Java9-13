package exercises.part5;

/**
 * Beispielprogramm für den Workshop "Best of Java 9, 10 und 11" / das Buch
 * "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 *         Copyright 2017/2018/2019 by Michael Inden
 */
public class Exercise1_switch {
	public static void main(String[] args) {

		int value = 7;

		System.out.println("result: " + dumpEvenOddChecker(value));
	}

	@SuppressWarnings("preview")
	private static String dumpEvenOddChecker(int value) {
		return

		switch (value) {
		case 1, 3, 5, 7, 9:
			yield "odd";

		case 0, 2, 4, 6, 8, 10:
			yield "even";

		default:
			yield "only implemented for values < 10";
		};

	}
}
