package homework3;
import java.util.Scanner; 

//Get Values from user
//Add value C. Do Ternary for C as well. 
public class ternary {
	public static void main(String[] args) {
		int max; 
		int a; 
		int b; 
		int c; 
		char cont='y'; 
		
		Scanner readInput =new Scanner(System.in);
		
		while(cont=='y') {
			System.out.println("Type in values for A,B and C separated by a space"); 
			a=readInput.nextInt(); 
			b=readInput.nextInt();
			c=readInput.nextInt();
			
			max= (a>b) ? a:b;
			max= (max>c)? max:c; 
			System.out.println("The Max value is: "+max); 
			System.out.println("Continue? Type 'y' for Yes");
			cont=readInput.next().charAt(0);
		}
		System.out.println("Thank you for using my max program"); 
	}
}

