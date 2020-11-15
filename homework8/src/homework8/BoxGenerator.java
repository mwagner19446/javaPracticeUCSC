package homework8;
import java.util.Scanner;


//Add Failure Handling

/**
 * This is a solution for HW#8
 * The class has three static methods and a main method. 
 * The drawHorizontalLine static method requires two parameters-- the vertical width as well as the character for the horizontal line.  It draws the horizontal line. 
 * The drawVerticalLine static method requires three parameters-- the horizontal height, the vertical width, as well as the character for the vertical line.  It uses nested iteration to create all the vertical lines. 
 * The drawBox static method requires four parameters-- the horizontal height, the vertical width, the character for the horizontal line, and the character for the vertical line.  It calls the drawHorizonalLine, drawVerticalline, and drawHorizontalLine again. 
 * 
 * The Main method will: 
 * A) Capture the user inputs
 * B) Execute the drawBox method
 * 
 * NOTE:  I modified your starter code to account to practice error-handling from the mid-term. 
 * 
 * @author michael
 * @date 9/25/2020
 */


public class BoxGenerator {

	/*
	 * Short description: The drawHorizontalLine prints out a horizontal line based on inputs that define the width and the character to be used. 
	 * <p>
	 * Long description: The drawHorizontalLine prints out a horizontal line based on inputs that define the width and the character to be used.  The integer represents the width of the box, and the character represents what should be printed as the horizontal line. 
	 * The width of the box is iterated through, printing the horizontal character. 
	 * <p>
	 * It is referenced by: {@link drawBox} method 
	 * It references: no other methods
	 * <p>
	 * @param wd1		Integer representing the width of the box. 
	 * @param hChar1	Character representing what should be printed out for the horizontal line. 
	 * @return NONE.  	(Static method.  Prints characters out) 
	 */
	private static void drawHorizontalLine(int wd1, char hChar1) {
		for (int x=1; x<= wd1;x++){ //iteration starts at 1, stops when the iterator is equal to the width
			System.out.print("" + hChar1); //prints out the hChar
			}
		System.out.print("\n");	//newline is printed out. 
	}
	

	/*
	 * Short description: The drawVerticalLine prints out two vertical lines based on inputs that define the height and width of a box as well as the character to be used. 
	 * <p>
	 * Long description: The drawVerticalLine prints out two vertical lines based on inputs that define the height and width of a box as well as the character to be used.
	 * There is nested iteration; 
	 * the outer iterator prints the vertical character for the height of the box on both sides; 
	 * the inner iterator prints spaces for the interior of the box, using the width of the box as the limit (subtracting two for the two sides) 
	 * <p>
	 * It is referenced by: {@link drawBox} method 
	 * It references: no other methods
	 * <p>
	 * @param hd1		Integer representing the height of the box. 
	 * @param wd1		Integer representing the width of the box
	 * @param vChar1	Character representing what should be printed out for the vertical line.  
	 * @return NONE.  	(Static method.  Prints characters out) 
	 */
	private static void drawVerticalLine(int ht1, int wd1, char vChar1) {
		for(int x=1;x<= ht1-2;x++){ //Outer iterator, manages the height of the box.  Subtracts two from the limit to account for the top and bottom horizontal line. 
			System.out.print(""+ vChar1); //prints left vertical line
			for (int y=1;y <= wd1-2;y++) { //Inner iterator, manages the width of the box.  Subtracts two to account for the left and right vertical lines. 
				System.out.print(" "); //prints space
			}
			System.out.print("" + vChar1 + "\n"); //prints right vertical line
		}
	}
	

	/*
	 * Short description: The drawBox prints out a box based on parameters provided for the box. 
	 * <p>
	 * Long description: The drawBox prints out a box based on parameters provided for the box.  
	 * First it calls the drawHorizontalLine method to draw the top line of the box. 
	 * Second it calls the drawVerticalLine method to iterator through the body of the box
	 * Third it calls the drawHorizontalLine method to draw the bottom of the line of the box. 
	 * <p>
	 * It is referenced by: {@link main} method 
	 * It references: {@link drawHorizontalLine} and {@link drawVerticalLine} methods
	 * <p>
	 * @param hd1		Integer representing the height of the box. 
	 * @param wd1		Integer representing the width of the box
	 * @param vChar1	Character representing what should be printed out for the vertical line. 
	 * @param hChar1	Character representing what should be printed out for the horizontal line.  
	 * @return NONE.  	(Static method.  Prints characters out) 
	 */
	public static void drawBox(int ht1, int wd1, char hChar1, char vChar1) {
		System.out.println("\nUsing for-loop and user values:");
		drawHorizontalLine(wd1,hChar1); //draws the top horizontal line
		drawVerticalLine(ht1, wd1,vChar1); //draws the body of the box
		drawHorizontalLine(wd1,hChar1); //draws the bottom horizontal line
	}
	
	
	public static void main (String[] args) {
		char hChar1, vChar1; //The characters printed in the box lines.  hChar are for the top and bottom lines; vChar is for the right and left lines. 
		int ht1=0, wd1=0; //Defines the height and width of the box
		char answer = 'y'; //determines if the box creation sequence stays open. 
		Scanner input1 = new Scanner(System.in); //Scanner object
		
		
		System.out.println("\nUsing for-loop and user values:");
		while (answer == 'y') {
			//Capture the box height
			boolean tryAgain=false; 
			do {
				System.out.print("\nPlease enter height of a box: ");
				if(input1.hasNextInt()) {
					ht1 = input1.nextInt();
					tryAgain=false; //exit criteria for loop 
				}
				else {
					System.out.print("You have entered invalid height.  Please try again\n\n");
					tryAgain=true; 
					input1.next(); //clean the buffer and allow for new Int
				}	
			}
			while(tryAgain); // continue iteration until you get a valid Integer

			//Capture the box width
			do {
				System.out.print("\nPlease enter width of a box:");
				if(input1.hasNextInt()) {
					wd1 = input1.nextInt();
					tryAgain=false; 
				}
				else {
					System.out.print("You have entered invalid height.  Please try again\n\n");
					tryAgain=true; 
					input1.next(); //clean the buffer and allow for new Int
				}	
			}
			while(tryAgain); // continue iteration until you get a valid Integer
			input1.nextLine(); //clean the buffer; prepare for string entry

			
			//Capture the horizontal character
			System.out.print("\nPlease enter the horizontal charcters to draw box: ");
			hChar1 = input1.nextLine().charAt(0);
			
			//Capture the vertical character
			System.out.print("\nPlease enter the vertical charcters to draw box: ");
			vChar1 = input1.nextLine().charAt(0);
	
			//executes drawBox
			drawBox(ht1, wd1, hChar1, vChar1); 
			
			//Continue Prompt
			System.out.print("\n\n"); //new space
			System.out.print("Continue? Type 'y' for yes:");
			answer = input1.nextLine().charAt(0);
			System.out.println("\n\nThank you for using my draw box program");
		}	
	}
}
