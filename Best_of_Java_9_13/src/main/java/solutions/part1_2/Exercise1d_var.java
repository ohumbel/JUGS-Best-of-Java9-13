package solutions.part1_2;

import java.util.function.Predicate;

/**
 * Beispielprogramm für den Workshop "Best of Java 9, 10 und 11" / das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017/2018 by Michael Inden 
 */
public class Exercise1d_var 
{
	public static void main(String[] args) 
	{
		final Predicate<Long> isEven = n -> n % 2 == 0;
		var isOdd = isEven.negate();
		
		//var isEmpty = String::isEmpty;
		var isEmptyV1 = ( Predicate<String>)String::isEmpty;
		Predicate<String> isEmptyV2 = String::isEmpty;
	}
}
