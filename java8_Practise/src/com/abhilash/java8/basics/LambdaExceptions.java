package com.abhilash.java8.basics;

import java.util.function.BiConsumer;

public class LambdaExceptions {

	public static void main(String[] args) {

		int[] someNumbers = { 1, 2, 3, 4, 5 };
		int key = 0;

		process(someNumbers, key, wrapperFunction((v, k) -> {
			  System.out.println(v / k);
		}));

	}

	private static void process(int[] someNumbers, int key,
			BiConsumer<Integer, Integer> sample) {
		for (int i : someNumbers)
			sample.accept(i, key);

	}

	public static BiConsumer<Integer, Integer> wrapperFunction(BiConsumer<Integer, Integer> sample) {
	
		return (v, k) -> {
			try{
				sample.accept(v, k);	
			}catch (ArithmeticException e){
				System.out.println("Handeled");
			}
				
		};
	}

}
