package com.abhilash.java8.basics;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Lambdas {

	private static void printPerson(List<Person> people, Predicate<Person> condition, Consumer<Person> rint) {
		for (Person each : people) {
			if(condition.test(each)){
				rint.accept(each);	
			}
			
			
			
		}
	}

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(
				new Person("Abhilash", "Omkam", 26), 
				new Person("Shak", "Cork",66), 
				new Person("Zuxi", "Yaach", 86), 
				new Person("Query", "Hair", 16), 
				new Person("Nuil", "Koul", 46),
				new Person("Fratu", "Huoyt", 76));

		// Comparator<Person> com = ( p1, p2) ->
		// p1.getLastName().compareTo(p2.getLastName());
		Collections.sort(people,
				(p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
		// printPerson(people);

		printPerson(people, (p) -> {
				if(p.getLastName().startsWith("Y")){
					return true;	
				}
				return false;
			}, p -> System.out.println(p));
		
		System.out.println();
		
		printPerson(people, (p) ->true, (p) -> System.out.println(p));
	}

}

interface Condition {
	boolean test(Person p);
}
