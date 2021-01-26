import java.util.Scanner;
import java.util.InputMismatchException;

// *** Class starts here ***
public class Div{

	static int numerator;
	static int denominator;
	static int result;

	// *** Created Scanner to read input ***
	private static Scanner sc = new Scanner(System.in);

	
	public static void main(String[] args){
	
		getNumerator();
		getDenominator();
		
		// *** Printing the final statement ***
		System.out.println(numerator+" / "+denominator+" = "+result);
	}

	// *** Method to read numerator ***
	public static void getNumerator(){
		System.out.println("Please enter the numerator: ");
		
		try{
		numerator = sc.nextInt();
		}
		catch(InputMismatchException e1){ // *** Handling non-integer input ***
			System.out.println("Error: you must enter a whole number");
			sc.nextLine();
			// *** Recursion until acceptable value ***
			getNumerator();
		}
	}

	// *** Method to read denominator ***
	public static void getDenominator(){
                System.out.println("Please enter the denominator: ");
                
                try{
                denominator = sc.nextInt();
                }
                catch(InputMismatchException e2){ // *** Handling non-integer input ***
                        System.out.println("Error: you must enter a whole number");
                        sc.nextLine();
			// *** Recursion until acceptable value ***
			getDenominator();
		}

		// *** Calling "divide()" here to continue code after "ArithmeticException" ***
		divide(numerator, denominator);
        }

	// *** Method to perform division ***
	public static void divide(int a, int b){
		try{
		result = a/b;
		}
		catch(ArithmeticException e3){ // *** Handling division by zero ***
			System.out.println("Error: the denominator can't be zero");

			// *** Getting denominator again as it is zero ***
			Div.getDenominator();	
		}
	}
}
