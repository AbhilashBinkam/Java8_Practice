package com.abhilash.java8.basics;


/**
 * @author Abhilash
 * 
 *  In @2 implementation, we are using a variable value b = 20 which is not part of the parameters. During these situations the 
 *  compiler assumes that the variable value will not be changes and to be marked as final. i.e. final int b = 20;
 *  Till Java 7 we need to define the final for the variables that are shared across, but from java 8 the compiler is capable of 
 *  understanding that the value will not be changes. 
 *  
 *  The execution of the process method happens in doProcess method but the doProcess method doesn't have a variable b during those 
 *  cases we need to make sure that the value shared across doesn't change
 *  
 *  In Java 8 the compiler treats int b = 20 to be effectively final
 *  
 *  To view the error with variable b just uncomment the part 3
 *
 */
public class ClosureExamle {
	
	public static void main(String[] args) {
		
		int a = 10;
		int b = 20;
		
		doProcess(a, i -> System.out.println(i + b)); //1
		
		doProcess(a, new Process() {      //2

			@Override
			public void process(int i) {
				//b = 40;                 //3 
				System.out.println(i + b);
				
			}
			
		});
	}
	
	public static void doProcess(int i, Process p){
		p.process(i);
	}

}

interface Process{
	void process(int i);
}

