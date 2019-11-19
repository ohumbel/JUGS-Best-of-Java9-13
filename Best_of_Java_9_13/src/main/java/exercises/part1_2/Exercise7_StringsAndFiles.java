package exercises.part1_2;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

/**
 * Beispielprogramm für den Workshop "Best of Java 9, 10 und 11" / das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017/2018 by Michael Inden 
 */
public class Exercise7_StringsAndFiles 
{
	public static void main(String[] args) throws IOException 
	{
		final Path filePath = Paths.get("test.txt");
		
		// TODO
				
		final List<String> allLines = Collections.emptyList(); // TODO;
		allLines.forEach(System.out::println);
	}
}
