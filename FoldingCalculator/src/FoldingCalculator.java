import java.math.BigDecimal;
import java.util.Scanner;


public class FoldingCalculator {
	
	private static BigDecimal thickness = new BigDecimal("0.0039");
	private static BigDecimal littleNumber = thickness.multiply(new BigDecimal(Math.PI))
												.divide(new BigDecimal("6"));
	
	public static void calculateMinLength(int numFolds) {
		System.out.println("Minimum length of paper necessary to make " + numFolds + " folds:\n");
		BigDecimal bigNumber = new BigDecimal(Math.pow(2, numFolds));
		BigDecimal minLengthInInches = littleNumber.multiply(bigNumber.add(new BigDecimal("4")))
											.multiply(bigNumber.subtract(new BigDecimal("1")));
		System.out.println("In inches: " + minLengthInInches.toBigInteger());
		BigDecimal minLengthInFeet = minLengthInInches.divide(new BigDecimal("12"), 0, BigDecimal.ROUND_HALF_UP);
		System.out.println("In feet: " + minLengthInFeet.toPlainString());
		BigDecimal minLengthInMiles = minLengthInFeet.divide(new BigDecimal("5280"), 0, BigDecimal.ROUND_HALF_UP); 
		System.out.println("In miles: " + minLengthInMiles.toPlainString());
		BigDecimal minLengthInLightYears = minLengthInMiles.divide(new BigDecimal("5878499810000"), 0, BigDecimal.ROUND_HALF_UP);
		System.out.println("In light years: " + minLengthInLightYears.toPlainString());
	}

	public static void main(String[] args) {
		boolean calculateAgain = true;
		Scanner scan = new Scanner(System.in);
		
		while (calculateAgain) {
			System.out.println("How many folds would you like to make? ");
			String input = scan.next();
			
			try {
				int folds = Integer.parseInt(input);
				calculateMinLength(folds);
				System.out.println("\nCalculate another length (Y/N)?");
				String doItAgain = scan.next();
				if (doItAgain.equalsIgnoreCase("y") || doItAgain.equalsIgnoreCase("yes")) {
					calculateAgain = true;
				} else calculateAgain = false;
			} catch (Exception e) {
				System.out.println("That's not a valid number of folds.\n");
			}
		}
		scan.close();
	}

}
