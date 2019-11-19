package exercises.part3;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Beispielprogramm für den Workshop "Java 9 Hands On" / das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017/2018 by Michael Inden 
 */
public class Exercise1b_CompletableFutureExample
{
    public static void main(final String[] args) throws IOException, InterruptedException, ExecutionException
    {
        // Datenermittlung parallel ausfuehren
        final CompletableFuture<List<String>> data1 = CompletableFuture.supplyAsync(()->retrieveData1());

        // TODO
    }

    private static List<String> retrieveData1()
    {
    	System.out.println("retrieveData1(): " + Thread.currentThread().getName());
        return Arrays.asList("Jennifer", "Lili", "Carol");
    }

    private static List<String> retrieveData2()
    {
    	System.out.println("retrieveData2(): " + Thread.currentThread().getName());
        return Collections.emptyList();
    }
}