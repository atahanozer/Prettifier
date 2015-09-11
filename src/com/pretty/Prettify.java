package com.pretty;

import java.util.Scanner;

/**
 * Prettify class includes the main method and provides a scanner to user to enter a number to format. 
 * 
 * @author Atahan Ozer
 * @version 1.0
 */
public class Prettify {

	public static void main(String[] args) {
		//Scanner is used for getting user input
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please enter a number to format. Examples: 789 or 4560000.08 or 100,000,000:");

		try {
			String number = scanner.nextLine();
			PrettifyFormatter formatter = new PrettifyFormatter(number);
			System.out.println(formatter.getFormattedValue());
		} catch (Exception e) {
			System.out.println("An error occured during prettification.");
		} finally {
			scanner.close();
		}

	}
}
