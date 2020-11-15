package homework8;
import java.util.Scanner; 

//experiment with moving the variables in and out of the main method.  

/**
 * This is a solution for HW#8
 * The class has six static methods and a main method. 
 
 * The getTemperatures static method captures seven temperature observations for the week. It stores the values in a static array. 
 * The printTemperatures static method prints the seven temperature observations from the static array.   
 * The getMax determines the max value in the array by iteration.  It requires a parameter for the max value and returns the max value after the iteration.   
 * The getMin determines the min value in the array by iteration.  It requires a parameter for the min value and returns the min value after the iteration. 
 * The getAverage determines the average value of the array by iteration.  It requires a parameter for the average value and returns the average value after the iteration.  
 * The printStatistics prints out the values for Max, Min, and Average.  It requires parameters for max, min, and average.  It executes getMin, getMax, and getAverage. 
 * 
 * The Main method will: execute getTemperature, printTemperature, and printStatistics
 * 
 * @author michael
 * @date 9/25/2020
 */



public class TemperatureSummaryDisplay {
	public static Scanner getInput; //Creates a Scanner Object to accept inputs
	public static int weeklyTemp[] = { 69, 70, 71, 68, 66, 71, 70 }; //Creates a default weeklyTemp array.  These values get overwritten. 
	
	
	
	/*
	 * Short description: The getTemperature method captures seven temperatures for the week. 
	 * <p>
	 * Long description: The getTemperature method captures seven floats and store them in an in the weeklyTemp array. It uses an outer do-while loop to capture the temperatures and a nested for loop to insert those values into the array. 
	 * NOTE:  I've modified your starter code to practice the error-handling techniques from the midterm.  
	 * <p>
	 * It is referenced by: No other methods.  
	 * It references: {@link #main} method  
	 * <p>
	 * @param NONE.  (Accesses the weeklyTemp array and Scanner getInput object)
	 * @return NONE.  (Static method.  Updates the class array for weeklyTemp directly) 
	 */
	public static void getTemperatures(){
		getInput=new Scanner(System.in);
		boolean tryAgain=false; //set to false
		
		do{
			System.out.println("Please enter 7 temperatures for the week: ");
			for(int i=0; i<weeklyTemp.length; i++) {
				if(getInput.hasNextInt()) {
					weeklyTemp[i]=getInput.nextInt();
					tryAgain=false; //set to false; ensures do-while loop doesn't run again.  
				}
				else {
					System.out.print("You have entered invalid temperatures.  Please try again\n\n");
					getInput.next(); //clear buffer 
					tryAgain=true; //set to true; ensures do-while loop runs again
					break; //breaks the "for" loop
				}
			}
		}
		while(tryAgain); 
	}
	
	
	/*
	 * Short description: The printTemperatures method iterates through the weeklyTemp array and prints out the values.  
	 * <p>
	 * Long description: The printTemperatures method iterates through the weeklyTemp array and prints out the values. It uses a for loop to print out the values from the weeklyTemp array. 
	 * <p>
	 * It is referenced by: No other methods.  
	 * It references: {@link #main} method  
	 * <p>
	 * @param NONE.  (Accesses the weeklyTemp array and Scanner getInput object)
	 * @return NONE.  (Static method.  Updates the class array for weeklyTemp directly) 
	 */
	public static void printTemperatures() {
		for (int i = 0; i < weeklyTemp.length; i++) {
			System.out.printf("\nThe temperature on day %d "+"was: %d ", i + 1, weeklyTemp[i]);
			}
			System.out.printf("\n\n");
	}
	
	/*
	 * Short description: The getMax method returns the max value from the weeklyTemp array 
	 * <p>
	 * Long description: The getMax method returns the max value from the weeklyTemp array.  It iterates through the weeklyTemp array and compares the current max with the current value.  If the current value of is higher, it overwrites the max value. 
	 * <p>
	 * It is referenced by: {@link #printStatistics} method    
	 * It references: No other methods.   
	 * <p>
	 * @param Max  an Integer that represents the maximum value. 
	 * @return Max 	a modified Integer that represents the maximum value.  
	 */
	public static int getMax(int max) {
		for (int i = 0; i < 7; i++) {
			if (i == 0)
				max = weeklyTemp[i];
			if (weeklyTemp[i] > max)
				max = weeklyTemp[i];
		}
		return max; 
	}

	
	/*
	 * Short description: The getMin method returns the min value from the weeklyTemp array 
	 * <p>
	 * Long description: The getMin method returns the min value from the weeklyTemp array.  It iterates through the weeklyTemp array and compares the current min with the current value.  If the current value of is lower, it overwrites the min value. 
	 * <p>
	 * It is referenced by: {@link #printStatistics} method    
	 * It references: No other methods.   
	 * <p>
	 * @param min  an Integer that represents the minimum value. 
	 * @return min 	a modified Integer that represents the minimum value.  
	 */
	public static int getMin (int min) {
		for (int i = 0; i < 7; i++) {
			if (i == 0)
				min = weeklyTemp[i];
			if (weeklyTemp[i] < min)
				min = weeklyTemp[i];
		}
		return min; 
	}
	
	
	
	/*
	 * Short description: The getAverage method returns the average value from the weeklyTemp array 
	 * <p>
	 * Long description: The getAverage method returns the average value from the weeklyTemp array.  It iterates through the weeklyTemp array, adding the total value of the array.  It divides the total value by the array length, and returns the average value as a float. 
	 * <p>
	 * It is referenced by: {@link #printStatistics} method    
	 * It references: No other methods.   
	 * <p>
	 * @param average  a float that represents the average value. 
	 * @return average 	a modified float that represents the average value.  
	 */
	public static float getAverage(float average) {
		float total = 0;  
		for (int i = 0; i < 7; i++) {
			total += weeklyTemp[i];
		}
		average = total / weeklyTemp.length;
		return average; 
	}


	/*
	 * Short description: The printStatistics method prints the min, max, and average values from the weeklyTemp array.  
	 * <p>
	 * Long description: The printStatistics method prints the min, max, and average values from the weeklyTemp array.  It call the getMin, getMax, and getAverage methods from within print statements.  Those methods access the weeklyTemp array.  
	 * <p>
	 * It is referenced by: {@link #main} method    
	 * It references:   {@link #getMin} method
	 * 					{@link #getMax} method
	 * 					{@link #getAverage} method  
	 * <p>
	 * @param Max  		an Integer that represents the maximum value.
	 * @param Min		an Integer that represents the minimum value.   
	 * @param Average	a float representing the average value of the weeklyTemp Array.
	 *  
	 * @return NONE.  (Static Method.  Prints out details.)  
	 */
	public static void printStatistics(int max, int min, float average) {
		System.out.printf("The Minimum temperature is: %d\n", getMin(min));
		System.out.printf("The Maximum temperature is: %d\n", getMax(max));
		System.out.println("The average temperature for the week is:" + getAverage(average));
	}
	
	public static void main (String[] args) {
		int max = 0;  //Stores the max value
		int min = 0;  //Stores the min value
		float average=0;  //Stores the Average value
		
		//Captures the temperature from the user
		getTemperatures(); 
		//Prints the temperature for the user
		printTemperatures(); 
		//Prints the statistics from the user
		printStatistics(max, min, average); 
	}
}
