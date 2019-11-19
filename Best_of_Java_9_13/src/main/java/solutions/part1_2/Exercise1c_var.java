package solutions.part1_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Beispielprogramm für den Workshop "Best of Java 9, 10 und 11" / das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017/2018 by Michael Inden 
 */
public class Exercise1c_var 
{
	public static void main(String[] args) 
	{
		funWithVar();
	}

	static void funWithVar()
	{
		List<String> names = new ArrayList<>(); // Achtung: nicht direkt durh var ersetzbar
		var names1 = new ArrayList<String>();   // erfordert das einfügen ds Typs auf der rechten Seite
		var names2 = new ArrayList<String>();
	}
}
