package homework4;
import java.util.Scanner; 

/**
 * This is a solution for Homework#4 
 * 
 * 	To make it easier to read, the requirements for BoxLoop have been broken into three different classes: 
 * 	BoxGenerator2 contains the following requirements from the homework:   
 *  4.3:  Use a Do-while loop
 *  4.5:  Ask the user for height, width and characters
 *  4.6:  Ask the user to continue
 *  
 * @author michael
 *
 */

public class BoxGenerator2 {
		public static void main(String[] args){
			int h,v,i,j; 	//h and v are the lengths of the length and the vertical of the box, respectively.  The user will enter these values in the initial prompt.  i and j are the iterators used.  		
			char hVal='-';  //By Default the value is '-'.  The user will be asked to modify. 
			char vVal='|';  //By Default the value is '|'.  The user will be asked to modify. 
			char cont='y'; //By Default, the value is 'y'.  If the user does not want to continue, they will enter something else, exiting the program.
			
			Scanner readInput=new Scanner(System.in);
			/*
			 * There are five sections of the code: 
			 * Section 1: User prompt to capture information.  This is the "do" part of a do-while loop.  All the other executions are part of this (ie: sections 2-4)  The while statement is the conditional to continue in section 5.  
			 * Section 2: Create the top horizontal line.  
			 * Section 3: Creates the body of the horizontal line. There is a nested do-while for the border and the interior  
			 * Section 4: Create the bottom horizontal line
			 * Section 5: User is prompted to continue.  If they do not select 'y' the while condition exits.  
			 */
			
			//Section 1: The do-while loop will prompt the user to enter in the parameters. 	
			do {
				i=0; 
				j=0;
				System.out.println("How long should the box be? NOTE:  Must be greater than 2"); 
				h=readInput.nextInt(); 
				System.out.println("How tall should the box be? NOTE:  Must be greater than 2");
				v=readInput.nextInt(); 
				System.out.println("What should the horizontal character be?"); 
				hVal=readInput.next().charAt(0); 
				System.out.println("What should the vertical character be?"); 
				vVal=readInput.next().charAt(0);
			//Section 2: Creates the top horizontal line using a do-while loop.  The first value is printed; the rest of the line is printed as part of the while. 	
				do{System.out.print(hVal);}
				while (i++<h-1);  //iterate h-1 to account for the initial while
				System.out.println(' ');
				i=0;

			/*Section 3:  Creates the body of the box using a nested do-while loop.  
			 *The first value is printed followed by a space.  
			 *The number of spaces is iterated through the while statement. 
			 *The final value is printed.  
			 *
			*/	
				do {System.out.print(vVal);
					do {System.out.print(' ');}
					while (i++<h-3); //iterate h-3 to account for the 2 characters on the border and the initial space of the do statement. 
					System.out.println(vVal); //prints the final value
					i=0; //rests the internal iterator
				}
				while(j++<v-3); // iterate v-3 to account for the 2 characters on the horizontal lines as well as the current line of the first do statement. 

			//Section 4: Creates the bottom horizontal line using a do-while loop	
				do{System.out.print(hVal);}
				while (i++<h-1);  
				System.out.println(' ');	
				
			//Section 5: Prompts the user to continue
				System.out.println("Do you want to continue?  Press 'y' if yes."); 
				cont=readInput.next().charAt(0);	
			}
		while(cont=='y'); //Exits if the user enters anything but 'y'
		}	

}
