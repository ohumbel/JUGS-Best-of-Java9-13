package exercises.part3;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.SubmissionPublisher;

/**
 * Beispielprogramm für den Workshop "Java 9 Hands On" / das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017/2018 by Michael Inden 
 */
public class NamePublisher implements Flow.Publisher<String> 
{
	private static final List<String> names = Arrays.asList("Tim", "Tom", "Mike", "Alex",
			    "Babs", "Jörg", "Karthi", "Marco", "Peter", "Numa", "Jan", "Carol");
	
	private int counter = 0;
	private final SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

	public void subscribe(final Subscriber<? super String> subscriber) 
	{
		publisher.subscribe(subscriber);
	}

	public void doWork() 
	{
		for (;;)
		{
			final String item = names.get(counter++ % names.size());
			
			publisher.submit(item);
			
			try 
			{
				Thread.sleep(1_000);
			} 
			catch (InterruptedException e) 
			{
				// ignore
			}
		}
	}
}