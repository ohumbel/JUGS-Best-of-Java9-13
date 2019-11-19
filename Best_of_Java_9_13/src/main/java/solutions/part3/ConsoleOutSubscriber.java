package solutions.part3;

import java.time.LocalDateTime;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

/**
 * Beispielprogramm für den Workshop "Java 9 Hands On" / das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017/2018 by Michael Inden 
 */
class ConsoleOutSubscriber implements Subscriber<String> 
{
	public void onSubscribe(final Subscription subscription) 
	{
		subscription.request(Long.MAX_VALUE);
	}

	public void onNext(final String item) 
	{
		System.out.println(LocalDateTime.now() + " onNext(): " + item);
	}

	public void onComplete() 
	{	
		System.out.println(LocalDateTime.now() + " onComplete()");
	}

	public void onError(final Throwable throwable) 
	{
		throwable.printStackTrace();
	}
}