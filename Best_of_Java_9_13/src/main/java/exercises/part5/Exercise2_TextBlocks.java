package exercises.part5;

/**
 * Beispielprogramm für den Workshop "Best of Java 9, 10 und 11" / das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017/2018/2019 by Michael Inden 
 */
public class Exercise2_TextBlocks 
{
	public static void main(final String[] args) 
	{
		String multiLineStringOld = "THIS IS\n" +
	            "A MULTI\n" +
	            "LINE STRING\n" +
	            "WITH A BACKSLASH \\\n";
			System.out.println(multiLineStringOld);

		String multiLineString = null; // TODO;
		System.out.println(multiLineString);
		
		String multiLineHtmlOld = "<html>\n" +
                "    <body>\n" +
                "        <p>Hello, world</p>\n" +
                "    </body>\n" +
                "</html>";
		System.out.println(multiLineHtmlOld);

		String multiLineHtml = null; // TODO;
		System.out.println(multiLineHtml);
		
		String java13FeatureObjOld = ""
				+ "{\n"
				+ "    \"version\": \"Java13\",\n"
				+ "    \"feature\": \"text blocks\",\n"
				+ "    \"attention\": \"preview!\"\n"
				+ "}\n";
		System.out.println(java13FeatureObjOld);

		String java13FeatureObj = null; // TODO;;
		System.out.println(java13FeatureObj);

	}
}
