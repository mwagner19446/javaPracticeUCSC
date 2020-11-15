package homework1;
//included within an existing package that had all the classes.  Commenting out to make it easier for you to execute. 
//package helloWorld;

import java.util.Scanner;

public class HW1 {
	//NOTE:  I *believe* this is what you want for submission as per the Homework Template.java doc. 
	//1.1A Get familiar with the web port
	public static void exercise_1_1A() {
		System.out.println("I read through all the notes and watched the demo.  Excellent!"); 
	}
	//1.1B Download IDE
	public static void exercise_1_1B() {
		System.out.println("I downloaded Eclipse"); 
	}
	//1.2 Now change the code so that it displays Hello in one line, and Java World in another
	public static void exercise_1_2() {
		System.out.println("Hello");
		System.out.println("Java World");
	}
	//1.3 Create a public class to display HELLO as shown below
	public static void exercise_1_3() {
		System.out.println("***       ***    ********     ***          ***             ***   ");
		System.out.println("***       ***    ***          ***          ***          ***   ***");
		System.out.println("***       ***    ***          ***          ***          ***   ***");
		System.out.println("*************    ********     ***          ***          ***   ***");
		System.out.println("***       ***    ***          ***          ***          ***   ***");
		System.out.println("***       ***    ***          ***          ***          ***   ***");
		System.out.println("***       ***    ********     ********     ********        ***   ");
	}
	//Create another class to display the box as shown below
	public static void exercise_1_4() {
		System.out.println(" -------------------");
		System.out.println("|                  |");
		System.out.println("|                  |");
		System.out.println("|                  |");
		System.out.println("|                  |");
		System.out.println("|                  |");
		System.out.println("|                  |");
		System.out.println("|                  |");
		System.out.println("|                  |");
		System.out.println(" -------------------");
	}
	public static void main(String[] args) {
		//
		exercise_1_1A();
		exercise_1_1B();
		exercise_1_2(); 
		exercise_1_3(); 
		exercise_1_4(); 
	}

}
