package solutions.part3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;
import java.util.function.Supplier;

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
        final CompletableFuture<List<String>> data2 = CompletableFuture.supplyAsync(()->retrieveData2());

        // Verbinde die Ergebnisse
        final CompletableFuture<List<String>> result = data1.thenCombine(data2, combineResults());

        // keine Ausgabe ohne diese Zeile!? => erst Terminal Operation stoesst Berechnung an
        System.out.println("result: " + result.get());
    }

    private static List<String> retrieveData1()
    {
    	System.out.println("retrieveData1(): " + Thread.currentThread().getName());
        return Arrays.asList("Jennifer", "Lili", "Carol");
    }

    private static List<String> retrieveData2()
    {
    	System.out.println("retrieveData2(): " + Thread.currentThread().getName());
        return Arrays.asList("Tim", "Tom", "Mike");
    }

    private static BiFunction<? super List<String>, ? super List<String>, ? extends List<String>> combineResults()
    {
    	System.out.println("combineResults(): " + Thread.currentThread().getName());
        return (list1, list2) -> {
        	final List<String> result = new ArrayList<>(list1);
        	result.addAll(list2);
            return result;
        };
    }
}