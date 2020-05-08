package com.calculator;

import java.util.*;

public class Calculator {

	public static void main(String[] args){
		int no1,no2,operation;
		Scanner reader = new Scanner(System.in);

		while(true){
			System.out.println("1.Addition\n2.Subtraction\n3.Muliplication\n4.Division\n5.Exit");
			System.out.print("Choose the operation: ");
			operation = reader.nextInt();
			if(operation==5){System.out.println("Have a Nice Day :)");break;}
			else{
							System.out.print("Enter the numbers with a space: ");
							no1 = reader.nextInt();
							no2 = reader.nextInt();
							switch(operation){
								case 1:
									System.out.println("Sum of the numbers is "+add(no1,no2));
									break;
								case 2:
									System.out.println("Difference of the numbers is "+subtract(no1,no2));
									break;
								case 3:
									System.out.println("Product of the numbers is "+multiply(no1,no2));
									break;
								case 4:
									System.out.println("cofficient of the numbers is "+divide(no1,no2));
									break;
							}

						}
		}
	}

	public static int add(int a, int b) {
		return a + b;
	}

	public static int subtract(int a, int b) {
		return a - b;
	}

	public static long multiply(int a, int b) {
		return a * b;
	}

	public static double divide(int a, int b) {
		double result;
		if (b == 0) {
			throw new IllegalArgumentException("Divisor cannot divide by zero");
		} else {
			result = Double.valueOf(a)/Double.valueOf(b);
		}
		return result;
	}
}
