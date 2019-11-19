package solutions.part5;

/**
 * Beispielprogramm für den Workshop "Best of Java 9, 10 und 11" / das Buch
 * "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 *         Copyright 2017/2018/2019 by Michael Inden
 */
public class Exercise1_switch 
{
	public static void main(String[] args) 
	{
		int value = 7;

		dumpEvenOddChecker1a(value);
		
		String result1 = dumpEvenOddChecker1b(value);
		System.out.println("result1: " + result1);
		
		//String result2 = dumpEvenOddCheckerWithBreak1c(value);
		String result2 = dumpEvenOddChecker1cWithYieldJkDK13(value);
		System.out.println("result2: " + result2);
	}

	@SuppressWarnings("preview")
	private static void dumpEvenOddChecker1a(int value) 
	{
		String result = ""; // Eclipse benötigt das, Java Compiler nicht

		switch (value)
		{
		   case 1, 3, 5, 7, 9 -> result = "odd";
		   case 0, 2, 4, 6, 8, 10 -> result = "even";
		   default -> result = "only implemented for values < 10";
		}
		
		System.out.println("result: " + result);
	}

	@SuppressWarnings("preview")
	private static String dumpEvenOddChecker1b(int value) 
	{
		return switch (value)
		{
			case 1, 3, 5, 7, 9 -> "odd";
			case 0, 2, 4, 6, 8, 10 -> "even";
			default -> "only implemented for values < 10";
		};
	}
	
	/*
	@SuppressWarnings("preview")
	private static String dumpEvenOddCheckerWithBreak1c(int value) 
	{
		return switch (value)
		{
			case 1, 3, 5, 7, 9: break "odd";
			case 0, 2, 4, 6, 8, 10: break "even";
			default: break "only implemented for values < 10";
		};
	}
	*/

	@SuppressWarnings("preview")
	private static String dumpEvenOddChecker1cWithYieldJkDK13(int value) {
		return switch (value) {
			case 1, 3, 5, 7, 9:
				yield "odd";
			case 0, 2, 4, 6, 8, 10:
				yield "even";
			default:
				yield "only implemented for values < 10";
		};
	}
}
