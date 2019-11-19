package exercises.part1_2;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

/**
 * Beispielprogramm für den Workshop "Java 9 Hands On" / das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017/2018 by Michael Inden 
 */
public class Exercise5_Friday13thExample 
{
	public static void main(String[] args) 
	{
		final LocalDate start = LocalDate.of(2013, 1, 1);
		final LocalDate end = LocalDate.of(2018, 1, 1);
		
		// Aufgabe 7a
		final List<LocalDate> allFriday13th = /* TODO */ null;
		System.out.println(allFriday13th);

		final Predicate<LocalDate> isFriday13th = /* TODO */ null;
		// TODO
		
		// 7b
		final LocalDate start2010 = LocalDate.of(2010, 1, 1);
		final LocalDate end2017 = LocalDate.of(2018, 1, 1);
		
		final long allFeb29thsCount = /* TODO */ 0;
		
		System.out.println("February 29ths 2010-2017: " + allFeb29thsCount);
		
		// 7c		
		final Predicate<LocalDate> myBirthdayOnSunday = /* TODO */ null;
		final List<LocalDate> allBirthdaysOnSundays = /* TODO */ null;
		
		System.out.println("My Birthday on Sunday 2010-2017: " + allBirthdaysOnSundays);	
	}
}
