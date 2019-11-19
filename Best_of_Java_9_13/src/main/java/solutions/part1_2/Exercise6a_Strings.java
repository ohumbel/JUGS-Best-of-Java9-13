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
public class Exercise6a_Strings 
{
	public static void main(String[] args) 
	{
		Function<? super Integer, ? extends String> mapper = num -> ("" + num).repeat(num);
		
		Stream.of(2,4,7,3,1,9,5).map(mapper).
		                         forEach(System.out::println);
	}
}
