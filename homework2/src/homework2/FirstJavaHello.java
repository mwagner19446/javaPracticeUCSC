package homework2; 

// Modify the program and use only one print statement to show the same output.  
public class FirstJavaHello {

	public static void main(String[] args) {
		int radius=2; 
		double area; 
		final double pi=3.142; 
		
		area= pi * radius * radius; 
		
		//System.out.println("The area is: ");
		//System.out.println(area)
		System.out.printf("The area is: %.2f", area); 
	}

}
