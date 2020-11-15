package homework3;
import java.util.Scanner; 

public class FirstJavaHello {


	//"You are a kid" if age is less than 13
	//"You are a teenager" if the age is between 13 and 19
	//"You are an adult" if the age is greater than 19
	public static void main(String[] args) {
		int yourAge; 
		
		Scanner readInput=new Scanner(System.in); 
		System.out.printf("How old are you?: "); 
		yourAge=readInput.nextInt(); 
		
		if(yourAge<13)
			System.out.printf("You are a kid\n"); 
		else if(yourAge>=13&&yourAge<=19)
			System.out.printf("You are a teenager\n"); 
		else 
			System.out.printf("You are an adult\n"); 

		/*else if(yourAge==50)
			System.out.printf("You are golden\n"); 
		else
			System.out.printf("You are not so golden\n"); 
		*/

	}

}
