package homework3;
import java.util.Scanner; 


//Item A: accept decimals instead of integers
//Item B: Once the input is displayed, as the user if they want to continue, if they say yes, then repeat the process
public class calculator {
	
	public static void main(String[] args) {
		float firstN; 
		float secondN; 
		char operator; 

		Scanner readInput = new Scanner(System.in); 
		System.out.println("Type a number, operator, number ---"+"separated by a space: "); 
		
		firstN = readInput.nextFloat();
		operator=readInput.next().charAt(0); 
		secondN=readInput.nextFloat();
			
		if (operator == '+')
			System.out.printf("%.2f + %.2f = %.2f", firstN, secondN, firstN+secondN); 
		else if (operator == '-')
			System.out.printf("%.2f - %.2f = %.2f", firstN, secondN, firstN-secondN);
		else if (operator == '*')
			System.out.printf("%.2f * %.2f = %.2f", firstN, secondN, firstN*secondN);
		else if (operator == '/')
			System.out.printf("%.2f / %.2f = %.2f", firstN, secondN, firstN/secondN);
		else if (operator == '%')
			System.out.printf("%.2f %% %.2f = %.2f", firstN, secondN, firstN%secondN);
		else 
			System.out.printf("Unknown operator");
		System.out.printf("\n\n");

	}
	
}
