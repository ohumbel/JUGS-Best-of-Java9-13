package solutions.part1_2;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Beispielprogramm für den Workshop "Best of Java 9, 10 und 11" / das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017/2018 by Michael Inden 
 */
public class Exercise6b_Strings 
{
	public static void main(String[] args) 
	{
		Function<? super Integer, ? extends String> mapper = num -> formatRightAligned(num, 10);
		
		Stream.of(2,4,7,3,1,9,5).map(mapper).
		                         forEach(System.out::println);
	}
	
	private static String formatRightAligned(final int num, final int desiredLength)
	{
		var multiNumbers = ("" + num).repeat(num);
		
		var padding = calcPadding(num, desiredLength);
		
		return "'" + padding + multiNumbers + "'";
	}

	private static String calcPadding(final int num, int desiredLength) {
		var padding = "";
		if (num < desiredLength)
		{
			padding = " ".repeat(desiredLength - num);
		}
		return padding;
	}
}
