package homework5;

/**
 * 
 * This is a solution for HW#5
 * The class displays a summary of a temperature array.  It includes: 
 * A) Day by Day listing of the temperature
 * B) Calculation of the Minimum temperature and display
 * C) Calculation of the Maximum temperature and display
 * D) Calculation of the Average temperature and display
 * 
 * @author michael
 * @date	9/7/2020
 *
 */


public class TemperatureSummaryDisplay {

	public static void main(String[] args) {
		int weeklyTemp[]= {69,70,71,68,66,71,70}; //Array containing the temperature values.  
		int max=weeklyTemp[0], min=weeklyTemp[0]; //Initialized values of the minimum and maximum temperature.  The array will be iterated over, so the initial value is the first element in the array. 
		float total=0, average; //The floats created to store the total and average
		
		//This iterates through the weeklyTemp Array and prints out the temperature that day
		for(int i=0; i<weeklyTemp.length; i++) {
			System.out.printf("The temperature on day %d was %d \n", i+1, weeklyTemp[i]);
			total+=weeklyTemp[i]; //Accumulates the aggregate temperature during the week.  Used to capture the average below. 
			min=(min<weeklyTemp[i])?min:weeklyTemp[i]; //Determine the min.  Replaces the Min value if the current value is lesser. 
			max=(max>weeklyTemp[i])?max:weeklyTemp[i]; //Determine the max.  Replaces the Max value if the current value is greater. 
 
		}
		System.out.println(" "); 
		System.out.printf("The Minimum Temperature is: %d \n",min);
		System.out.printf("The Maximum Temperature is: %d \n",max);
		System.out.printf("The Average Temperature for the week is: %.5f \n\n",total/weeklyTemp.length); //Calculates the Average Temperature during the week.  
		System.out.println("Thank you for using my homework #5 solution"); 
	}
}
