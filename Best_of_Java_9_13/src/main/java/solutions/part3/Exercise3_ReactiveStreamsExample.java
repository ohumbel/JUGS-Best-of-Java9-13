package solutions.part3;

import java.io.IOException;

/**
 * Beispielprogramm für den Workshop "Java 9 Hands On" / das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017/2018 by Michael Inden 
 */
public class Exercise3_ReactiveStreamsExample 
{
	public static void main(final String[] args) throws IOException,
	                                                     InterruptedException
	{
		final NamePublisher publisher = new NamePublisher(); 
		//publisher.subscribe(new ConsoleOutSubscriber());
		publisher.subscribe(new SkipAndTakeSubscriber(System.out::println, 4, 3));
		
		publisher.doWork();
		
		Thread.sleep(1_000); // auf das Ende der Verarbeitung warten
	}	
}

