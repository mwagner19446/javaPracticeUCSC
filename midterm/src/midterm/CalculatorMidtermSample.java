package midterm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
* @author John Doe
* Description: This application gives choice to add, subtract, multiply and divide two numbers. After successful calculation it lets user calculate again or exit the system
*
*/

public class CalculatorMidtermSample {
	/**
	 * Adds two numbers passed as two elements of an array and prints the result
	 * @param array of two floats
	 *
	 */
	public static void add(float[] numbers) {
		System.out.printf("Result of adding %.2f and %.2f is %.2f\n",numbers[0], numbers[1], numbers[0] + numbers[1]);
		}
	
	/**
	 * Subtracts two numbers passed as two elements of an array and prints the result
	 * @param array
	 * of two floats
	 * */
	public static void subtract(float[] numbers) {
		System.out.printf("Result of subtracting %.2f and %.2f is %.2f\n",numbers[0], numbers[1], numbers[0] - numbers[1]);
		}
	/**
	 * Multiplies two numbers passed as two elements of an array and prints the result
	 * * @param array of two floats
	 */
	
	public static void multiply(float[] numbers) {
		System.out.printf("Result of multiplying %.2f and %.2f is %.2f\n",numbers[0], numbers[1], numbers[0] * numbers[1]);
		}
	/**
	* Divides two numbers passed as two elements of an array and prints the
	* result	
	* @param array
	*of two floats
	**/

	public static void divide(float[] numbers) {
		System.out.printf("Result of dividing %.2f by %.2f is %.2f\n",numbers[0], numbers[1], numbers[0] / numbers[1]);
		}
	/**
	 * returns a valid menu choice between 1 and 5 entered by user this gets two
	 * floats together
	 ** @param none
	 **
	 **/

	public static int getValidOption(Scanner readInput) {
		int option = -9999;
		boolean tryAgain = false;
		do {
			printMenu();
			// Scanner readInput = new Scanner(System.in);
			System.out.printf("\nWhat would you like to do? ");
			if (readInput.hasNextInt()) {
				option = readInput.nextInt();
				if (option < 1 || option > 5) {
					System.out.print("\nInvalid choice. Please try again.\n");
					// Print error for invalid value
					tryAgain = true;
				} else
					tryAgain = false;
			} else {
				System.out.print("\nInvalid entry. Please try again.\n"); // Print error for non-numeric value
				tryAgain = true;
			}
			// no matter what, clear the buffer
			readInput.nextLine();
		} while (tryAgain);
			return option;
	}	
	
	
	/**
	 * Returns array of two valid floats bigger than -999999
	 *
	 * @param option
	 * selected by user ( 1 to 4)
	 *
	 */

	public static float[] getTwoFloats(int calcOption, Scanner readInput) {
		float floatNumbers[] = { -999999, -999999 };
		do {
			String calcOperation = (calcOption == 1) ? "add"
							: (calcOption == 2) ? "subtract"
							: (calcOption == 3) ? "multiply"
							: "divide";
			System.out.printf("\nPlease enter two numbers to %s separated by a space:",calcOperation);
			if (readInput.hasNextFloat()) {
				floatNumbers[0] = readInput.nextFloat();
				if (readInput.hasNextFloat()) {
					floatNumbers[1] = readInput.nextFloat();
					if (floatNumbers[1] == 0
							&& calcOperation.equalsIgnoreCase("divide"))	
						// Print error for dividing by zero
					{
						System.out.printf("Cannot divide by zero. Please try again.\n");
						floatNumbers[1] = -999999; // reset it
					}
				} else
					System.out.print("Invalid floats. Please re-enter.\n"); //Print error for non-numeric value
			} else
				System.out.print("Invalid floats. Please re-enter.\n"); // Print error for non-numeric value
	// no matter what, clear the buffer
			readInput.nextLine();
		} 
		while (floatNumbers[0] == -999999 || floatNumbers[1] == -999999);
		return floatNumbers;
	}
	/**
	* Prints the Calculation menu choice
	*
	* @param none
	*
	*/
	public static void printMenu() {
		System.out.printf("\n");
		System.out.printf("Welcome to John Doe's Handy Calculator\n\n");
		System.out.printf("\t1.Addition\n");
		System.out.printf("\t2.Subtraction\n");
		System.out.printf("\t3.Multiplication\n");
		System.out.printf("\t4.Division\n");
		System.out.printf("\t5.Exit\n\n");
	}
	/**
	* Returns the key entered by the user
	*
	* @param None
	*
	*/
	public static String pressAnyKeyToContinue() {
		String toContinue = null;
		System.out.print("Press the ENTER key to continue...");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			toContinue = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return toContinue;
	}
	/**
	* Main method. It calls getvalidOption to get the user's choice, calls
	* getTwoFloats to get two valid floats and calls different calculation
	* methods to do the calc It continues until user selects 5 to exit
	*
	* @param command
	*
	line arguments
	**/
	public static void main(String[] args) {
		int calcOption;
		String toContinue = null;
		Scanner readInput = new Scanner(System.in); 
			do {
				calcOption = getValidOption(readInput);
				switch (calcOption) {
				case 1:
					add(getTwoFloats(calcOption, readInput));
					break;
				case 2:
					subtract(getTwoFloats(calcOption, readInput));
					break;
				case 3:
					multiply(getTwoFloats(calcOption, readInput));
					break;
				case 4:
					divide(getTwoFloats(calcOption, readInput));
					break;
				case 5:
					System.out.printf("\nThank you for using John Doe's Calculator.\n");
					break;
				}
				toContinue = pressAnyKeyToContinue();
			} while (calcOption != 5 && toContinue != null);
			System.out.print("Have a nice day!\n");
			readInput.close(); // make sure to close it
		}// main
	}
