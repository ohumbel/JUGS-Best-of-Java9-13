package solutions.part1_2;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Beispielprogramm für den Workshop "Java 9 Hands On" / das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017/2018 by Michael Inden 
 */
public class Exercise3_TakeAndDropWhileExample 
{
    public static void main(final String[] args) 
    {
		final Predicate<String> isBodyStart = s -> "<body>".equalsIgnoreCase(s);
		final Predicate<String> isBodyEnd = s -> "</body>".equalsIgnoreCase(s);
		
		final List<String> tokens = List.of("<html>", 
			  "<head>", "<title>This is TITLE</title>", "</head>",
		      "<body>",
	           	"<h1>Hello everyone @ Oracle Code One</h1>",
	           	"<p>Welcome to this hands-on lab</p>",
		      "</body>",
		    "</html>");
		
		extractor(tokens, isBodyStart, isBodyEnd).forEach(System.out::println);
		
		// REUSE to EXTRACT HEAD infos
		extractor(tokens, str -> str.equalsIgnoreCase("<HEAD>"), 
				          str -> str.equalsIgnoreCase("</HEAD>")).forEach(System.out::println);
		
		extractor(tokens, str -> str.equalsIgnoreCase("<body>"), 
                  str -> str.equalsIgnoreCase("</body>")).forEach(System.out::println);
    }

	private static List<String> extractor(List<String> tokens, Predicate<String> isStart, Predicate<String> isEnd) 
	{		
		return tokens.stream()
                .dropWhile(isStart.negate())
                .skip(1)
                .takeWhile(isEnd.negate()).collect(Collectors.toList());
	}
}

