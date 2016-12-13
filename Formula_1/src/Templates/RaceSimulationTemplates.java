import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class RaceSimulationTemplates {

	/* Using drivers:
	 * Max Verstappen: 		Average 96
	 * Nico Rosberg:		Average 95
	 * Lewis Hamilton:  	Average 94.7
	 * Sebastian Vettel: 	Average 94
	 * Daniel Ricciardo:	Average 92.3
	 * Kimi Raikkonnen:		Average 90.7
	 * Sergio Mendoza:		Average 85.7
	 * Fernando Alonso: 	Average 84
	 * Valtteri Bottas:		Average 82.3
	 * Nicolas Hulkenberg:	Average 79.7
	 * Carloz Junior:		Average 79
	 * Kevin Magnussen:		Average 78.7
	 * Felipe Massa:		Average 77.7
	 * Jensen Button:		Average 77.3
	 * Felipe Nasr: 		Average 77
	 * Romain Grosjean		Average 76.7
	 * Pascal Wehrlein		Average 75.3
	 * Marcus Ericsson		Average 75
	 * Daniil Kvyat			Average 74
	 * Jolyon Palmer		Average 72
	 * Esteban Ocon			Average 71
	 * Esteban Gutierrez	Average 70 
	 * 
	 * Using Cars:
	 * Stock car:	Average 50.0
	 * Average car:	Average 70.6
	 * Max car:		Average 91.3
	 * 
	 * Using tracks:
	 * Silverstone, UK: Difficulty: 2.6
	 * Monte Carlo, MO: Difficulty: 4.7
	 */

	static List<String> drivers = getDriverList();
	static double[] driverAvg = getDriverAvg();

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Want to test with our without randomzation? (Y/N): ");
		char choice = sc.next().charAt(0);

		while (!(choice == 'Y' || choice == 'N')) {
			System.out.print("Incorrect input: ");
			choice = sc.next().charAt(0);
		}

		System.out.print("\n");
		
		if (choice == 'Y') {
			/* Version 1 Has the most difference in results between drivers
			 * Results lie between 40 and 230 when using randomizer
			 * Depending on driver, car and track difficulty
			 * Since we are adding a randomizer between 0.8 and 1.2 the results will be slightly modified by the randomization
			 */
			testVersion(1);
		} else {
			/* Version 2 Has more difference in results between drivers than version 1, but less than version 3
			 * Results lie between 50 and 190
			 * Depending on driver, car and track difficulty
			 * Since we are adding a randomizer between 0.8 and 1.2 the results will be moderately modified by the randomization
			 */
			testVersion(0);
		}

	}

	private static double[] getDriverAvg() {

		double[] avarages = new double[22];

		avarages[0] = 96;
		avarages[1] = 95;
		avarages[2] = 94.7;
		avarages[3] = 94;
		avarages[4] = 92.3;
		avarages[5] = 90.7;
		avarages[6] = 85.7;
		avarages[7] = 84;
		avarages[8] = 82.3;
		avarages[9] = 79.7;
		avarages[10] = 79;
		avarages[11] = 78.7;
		avarages[12] = 77.7;
		avarages[13] = 77.3;
		avarages[14] = 77;
		avarages[15] = 76.7;
		avarages[16] = 75.3;
		avarages[17] = 75;
		avarages[18] = 74;
		avarages[19] = 72;
		avarages[20] = 71;
		avarages[21] = 70;

		return avarages;

	}

	private static List<String> getDriverList() {

		List<String> drivers= new ArrayList<String>();

		drivers.add("M. Verstappen");
		drivers.add("N. Rosberg");
		drivers.add("L. Hamilton");
		drivers.add("S. Vettel");
		drivers.add("D. Ricciardo");
		drivers.add("K. Raikkonnen");
		drivers.add("S.P. Mendoza");
		drivers.add("F. Alonso");
		drivers.add("V. Bottas");
		drivers.add("N. Hulkenberg");
		drivers.add("C.S. Junior");
		drivers.add("K. Magnussen");
		drivers.add("F. Massa");
		drivers.add("J. Button");
		drivers.add("F. Nasr");
		drivers.add("R. Grosjean");
		drivers.add("P. Wehrlein");
		drivers.add("M. Ericsson");
		drivers.add("D. Kvyat");
		drivers.add("J. Palmer");
		drivers.add("E. Ocon");
		drivers.add("E. Guttierrez");

		return drivers;
	}

	public static double calculateResult(double avgCar, double avgDriver, double trackDiff, double random) {

		//The higher the result, the faster the driver has finished
		double result = 0;

		result = (avgCar + avgDriver);
		result = result * (2/trackDiff);
		result = result * random;

		return result;

	}

	private static double random() {

		Random value = new Random();
		double random = 0.9 + (1.1 - 0.9) * value.nextDouble();

		return random;

	}

	public static void testVersion(double randomInput) {

		double random = randomInput;
		double results[] = new double[22];

		if (random == 0) {
			for (int i = 0; i < 22; i++) {
				if (i == 0) {
					System.out.println("Finished 1st: " + drivers.get(i));
				} else if (i == 1) {
					System.out.println("Finished 2nd: " + drivers.get(i));
				} else if (i == 2) {
					System.out.println("Finished 3rd: " + drivers.get(i));
				} else if (i == 20) {
					System.out.println("Finished 21st: " + drivers.get(i));
				} else if (i == 21) {
					System.out.println("Finished 22nd: " + drivers.get(i));
				} else {
					System.out.println("Finished " + (i+1) + "th: " + drivers.get(i));
				}
			}
		} else {
			for (int i = 0; i < 22; i++) {
				random = random();
				results[i] = calculateResult(50, driverAvg[i], 2.6, random);
			}
		}

		if (random != 0) {
			for (int k = 0; k < 22; k ++) {

				int biggest = 0;

				for (int j = 0; j < 22; j++) {
					if (results[j] > results[biggest]) {
						biggest = j;
					}
				}

				if (k == 0) {
					System.out.println("Finished 1st: " + drivers.get(biggest));
					results[biggest] = 0;
				} else if (k == 1) {
					System.out.println("Finished 2nd: " + drivers.get(biggest));
					results[biggest] = 0;
				} else if (k == 2) {
					System.out.println("Finished 3rd: " + drivers.get(biggest));
					results[biggest] = 0;
				} else if (k == 20) {
					System.out.println("Finished 21st: " + drivers.get(biggest));
					results[biggest] = 0;
				} else if (k == 21) {
					System.out.println("Finished 22nd: " + drivers.get(biggest));
					results[biggest] = 0;
				} else {
					System.out.println("Finished " + (k+1) + "th: " + drivers.get(biggest));
					results[biggest] = 0;
				}

			}

		}

	}

}