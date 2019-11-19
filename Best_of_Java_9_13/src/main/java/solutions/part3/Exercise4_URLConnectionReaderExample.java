package solutions.part3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Beispielprogramm für den Workshop "Java 9 Hands On" / das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017/2018 by Michael Inden 
 */
public class Exercise4_URLConnectionReaderExample
{
    public static void main(final String[] args) throws IOException
    {
        readOraclePageJdk8();
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
}
