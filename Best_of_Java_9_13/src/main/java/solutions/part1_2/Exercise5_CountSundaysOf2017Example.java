package solutions.part1_2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Beispielprogramm für den Workshop "Java 9 Hands On" / das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017/2018 by Michael Inden 
 */
public class Exercise5_CountSundaysOf2017Example 
{
	public static void main(String[] args) 
	{
		final LocalDate start = LocalDate.of(2017, 1, 1);
		final LocalDate end = LocalDate.of(2018, 1, 1);
		
		// Aufgabe 6 a 
		Stream<LocalDate> allSundays = allBetween(DayOfWeek.SUNDAY, start, end);
		System.out.println("#Sundays in 2017: " + allSundays.count());

		// Aufgabe 6 b
		List<LocalDate> allSundaysInRange5_10 = allBetween(DayOfWeek.SUNDAY, start, end).
			      skip(5).
			      limit(5).
			      collect(Collectors.toList());
		
		// [2017-02-05, 2017-02-12, 2017-02-19, 2017-02-26, 2017-03-05]
		System.out.println(allSundaysInRange5_10);
		
		
		// Bonus
		final LocalDate start2018 = LocalDate.of(2012, 1, 1);
		final LocalDate end2018 = LocalDate.of(2013, 1, 1);

		final Map<DayOfWeek, Long> dayToCountMapping= new TreeMap<>();
		for (final DayOfWeek day : DayOfWeek.values())
		{
			final long numberOfDaysOfType = allBetween(day, start2018, end2018).count();
			dayToCountMapping.put(day, numberOfDaysOfType);
		}
		dayToCountMapping.forEach((key, value) -> System.out.println("Day: "  + key + " / count; " + value));
	}

	// Tipp: 
	private static Stream<LocalDate> allBetween(DayOfWeek dayOfWeek, LocalDate start, LocalDate end) 
	{
		return start.datesUntil(end).filter(day -> day.getDayOfWeek() == dayOfWeek);
	}
}
