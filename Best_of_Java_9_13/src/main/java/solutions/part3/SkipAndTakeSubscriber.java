package solutions.part3;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.function.Consumer;

/**
 * Beispielprogramm für den Workshop "Java 9 Hands On" / das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017/2018 by Michael Inden 
 */
class SkipAndTakeSubscriber implements Subscriber<String>
{
    final Consumer<String> consumer;

    private Subscription   subscription;

    private int count = 0;
    private final int skip;
    private final int take;

    SkipAndTakeSubscriber(final Consumer<String> consumer, final int skip, final int take)
    {
        this.consumer = consumer;
        this.skip = skip;
        this.take = take;
    }

    @Override
    public void onSubscribe(final Subscription subscription)
    {
        System.err.println("SkipAndTakeSubscriber - Subscription: " + subscription);
        this.subscription = subscription;
        this.subscription.request(skip + take);
    }

    @Override
    public void onError(final Throwable throwable)
    {
        throwable.printStackTrace();
    }

    @Override
    public void onNext(final String item)
    {
        count++;
        System.err.println("SkipAndTakeSubscriber " + count + " x onNext()");
        
        if (count >= skip)
        {
        	consumer.accept(item);
        }

        if (count >= skip + take)
        {
            subscription.cancel();
        }       
    }

    @Override
    public void onComplete()
    {
        System.err.println("onComplete()");
    }
}