package solutions.part5;

/**
 * Beispielprogramm für den Workshop "Best of Java 9, 10 und 11" / das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017/2018/2019 by Michael Inden 
 */
public class Exercise3_TextBlocks_Placeholders 
{
	public static void main(final String[] args) 
	{
		String multiLineStringWithPlaceHoldersOld = String.format("HELLO \"%s\"!\n" +
				 "  HAVE %s\n" +
				 "  NICE \"%s\"!",
				 new Object[]{"WORLD", "A", "DAY"});
		System.out.println(multiLineStringWithPlaceHoldersOld);

		/*
		String multiLineStringWithPlaceHolders = """
			HELLO "%s"!
  			  HAVE %s
      	      NICE "%s"!
            """.formatted(new Object[]{"WORLD", "A", "DAY"});
        System.out.println(multiLineStringWithPlaceHolders);
        */
	}
}
