package solutions.part4;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.util.concurrent.CompletableFuture;

/**
 * Beispielprogramm für den Workshop "Best of Java 9, 10 und 11" / das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017/2018 by Michael Inden 
 */
public class Exercise1b_Http2_Async
{
    public static void main(final String[] args) throws Exception
    {
        final URI uri = new URI("https://www.oracle.com/index.html");

        final HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        final BodyHandler<String> asString = HttpResponse.BodyHandlers.ofString();

        final HttpClient httpClient = HttpClient.newHttpClient();
        final CompletableFuture<HttpResponse<String>> asyncResponse = 
                                                      httpClient.sendAsync(request, 
                                                                           asString);
        asyncResponse.thenAccept(response -> printResponseInfo(response));

        waitForCompletion();
        if (asyncResponse.isDone())
        {
            final HttpResponse<String> response = asyncResponse.get();
            printResponseInfo(response);
        }
        else
        {
            asyncResponse.cancel(true);
            System.err.println("timeout");
        }
    }

    private static void waitForCompletion() throws InterruptedException
    {
        for (int i = 0; i < 10; i++)
        {
            System.out.println("Step " + i);
            Thread.sleep(200);
        }
    }

    private static void printResponseInfo(final HttpResponse<String> response)
    {
        final int responseCode = response.statusCode();
        final String responseBody = response.body();

        System.out.println("Status: " + responseCode);
        System.out.println("Body:   " + responseBody);
    }
}
