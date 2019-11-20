package exercises.part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;

/**
 * Beispielprogramm für den Workshop "Best of Java 9, 10 und 11" / das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017/2018 by Michael Inden 
 */
public class Exercise1_URLConnectionReaderExample
{
    public static void main(final String[] args) throws Exception
    {
        //readOraclePageJdk8();
        readOraclePageJdk11();
    }

	private static void readOraclePageJdk8() throws MalformedURLException, IOException 
	{
		final URL oracleUrl = new URL("https://www.oracle.com/index.html");
        final URLConnection connection = oracleUrl.openConnection();

        final String content = readContent(connection.getInputStream());
        System.out.println(content);
	}

    public static String readContent(final InputStream is) throws IOException
    {
        try (final InputStreamReader isr = new InputStreamReader(is); final BufferedReader br = new BufferedReader(isr))
        {
            final StringBuilder content = new StringBuilder();

            String line;
            while ((line = br.readLine()) != null)
            {
                content.append(line + "\n");
            }

            return content.toString();
        }
    }
    
    
    private static void readOraclePageJdk11() throws URISyntaxException, IOException,
    InterruptedException
    {
    final URI uri = new URI("https://www.oracle.com/index.html"); 
    final HttpClient httpClient = HttpClient.newHttpClient();
    final HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
    final BodyHandler<String> asString = HttpResponse.BodyHandlers.ofString();
    final HttpResponse<String> response = httpClient.send(request, asString);
    printResponseInfo(response);
    }
    

	private static void printResponseInfo(HttpResponse<String> response) {
		System.out.println(String.format("body:\n%s,\nstatus:\n%d", response.body(), response.statusCode()));
	}

}