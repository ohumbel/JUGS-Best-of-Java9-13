package exercises.part1_2;

/**
 * Beispielprogramm für den Workshop "Best of Java 9, 10 und 11" / das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017/2018 by Michael Inden 
 */
public class Exercise1a_var 
{
	public static void main(String[] args) 
	{
		funWithVar();
	}

	static void funWithVar()
	{
		var name = "Mike";
		var age = 42;
		System.out.println(String.format("%, %s", name, age));
	}
}
