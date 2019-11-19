package solutions.part1_2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
		final List<LocalDate> allFriday13th = start.datesUntil(end).
		      filter(day -> day.getDayOfWeek() == DayOfWeek.FRIDAY).
		      filter(day -> day.getDayOfMonth() == 13).
		      collect(Collectors.toList());

		System.out.println(allFriday13th);

		final Predicate<LocalDate> isFriday13th = day -> day.getDayOfWeek() == DayOfWeek.FRIDAY && 
				                                  day.getDayOfMonth() == 13;
		final Map<Integer, List<LocalDate>> allFriday13th_2 = start.datesUntil(end).
		      filter(isFriday13th).		    
		      collect(Collectors.groupingBy(day -> day.getYear()));
		final SortedMap<Integer, List<LocalDate>> sortedFriday13ths = new TreeMap<>(allFriday13th_2);
		sortedFriday13ths.forEach((key, value) -> System.out.println("Year " + key + ": " + value));
		
		// 7b
		final LocalDate start2010 = LocalDate.of(2010, 1, 1);
		final LocalDate end2017 = LocalDate.of(2018, 1, 1);
		
		final long allFeb29thsCount = start2010.datesUntil(end2017).
		      filter(day -> day.getMonth() == Month.FEBRUARY).
		      filter(day -> day.getDayOfMonth() == 29).
		      count();
		
		System.out.println("February 29ths 2010-2017: " + allFeb29thsCount);
		
		// Spezialfall: Geburtstag an einem Schaltjahr
		// 7c		
		final Predicate<LocalDate> myBirthdayOnSundayNormal = 
				day -> day.getDayOfWeek() == DayOfWeek.SUNDAY &&
				day.getMonth() == Month.FEBRUARY &&
                day.getDayOfMonth() == 7;
				
		final Predicate<LocalDate> isBirthdayForFeb29 = day-> {
			Year year = Year.of(day.getYear());
			if (year.isLeap())
			{
			    return day.getMonth() == Month.FEBRUARY &&
		                day.getDayOfMonth() == 29;	
			}
			else
			{
			    return day.getMonth() == Month.FEBRUARY &&
		                day.getDayOfMonth() == 28;	
			}			
		};
		final Predicate<LocalDate> onSonday = day -> day.getDayOfWeek() == DayOfWeek.SUNDAY;
		final Predicate<LocalDate> myBirthdayOnSundayFor29 = 
				onSonday.and(isBirthdayForFeb29);
						
		final List<LocalDate> allBirthdaysOnSundays = start2010.datesUntil(end2017).
			  filter(myBirthdayOnSundayFor29).
		      collect(Collectors.toList());
		
		System.out.println("My Birthday on Sunday 2010-2017: " + allBirthdaysOnSundays);	
	}
}
