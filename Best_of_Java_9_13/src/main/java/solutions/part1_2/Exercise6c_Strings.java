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
public class Exercise6c_Strings
{
	public static void main(String[] args) 
	{
		Function<? super Integer, ? extends String> mapper = num -> formatRightAligned(num, 10, '0');
		
		Stream.of(2,4,7,3,1,9,5).map(mapper).
		                         forEach(System.out::println);
		
		Function<? super Integer, ? extends String> mapper2 = num -> formatRightAligned(num, 10, '_');
		
		Stream.of(2,4,7,3,1,9,5).map(mapper2).
		                         forEach(System.out::println);
	}
	
	private static String formatRightAligned(final int num, final int desiredLength, final char fillChar)
	{
		var multiNumbers = ("" + num).repeat(num);
		
		var padding = calcPadding(num, desiredLength, fillChar);
		
		return "'" + padding + multiNumbers + "'";
	}

	private static String calcPadding(final int num, int desiredLength, final char fillChar)
	{
		var padding = "";
		if (num < desiredLength)
		{
			padding = String.valueOf(fillChar).repeat(desiredLength - num);
		}
		return padding;
	}
}
