package manager.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jdk.nashorn.internal.ir.LiteralNode.ArrayLiteralNode;
import manager.controller.GameController;

public class RaceSimulation
{

	/*
	 * Using drivers: Max Verstappen: Average 96 Nico Rosberg: Average 95 Lewis Hamilton: Average 94.7
	 * Sebastian Vettel: Average 94 Daniel Ricciardo: Average 92.3 Kimi Raikkonnen: Average 90.7 Sergio P�rez:
	 * Average 85.7 Fernando Alonso: Average 84 Valtteri Bottas: Average 82.3 Nicolas Hulkenberg: Average 79.7
	 * Carloz Sainz Junior: Average 79 Kevin Magnussen: Average 78.7 Felipe Massa: Average 77.7 Jensen Button:
	 * Average 77.3 Felipe Nasr: Average 77 Romain Grosjean Average 76.7 Pascal Wehrlein Average 75.3 Marcus
	 * Ericsson Average 75 Daniil Kvyat Average 74 Jolyon Palmer Average 72 Rio Haryanto Average 71 Esteban
	 * Gutierrez Average 70
	 * 
	 * Using Cars: Stock car: Average 50.0 Average car: Average 70.6 Max car: Average 91.3
	 * 
	 * Using tracks: Baku City Circuit, AZ: Difficulty: 2.33 Spa-Francorchamps, BE: Difficulty: 1.33
	 * Silverstone, UK: Difficulty: 4.00 Monza, IT: Difficulty: 2.78 Monte Carlo, MO: Difficulty: 5.32
	 */

	// Filling the lists with driver names and their averages
	static ArrayList<Driver>	drivers		= getDriverList();
	static ArrayList<Car>		cars 		= getCarList();
	
	public static void main(String args[])
	{

		// for (int j = 0; j < seasons; j++) {
		// if (!(simulation.equals("Y") || seasons == 1)) {
		// System.out.println("\nSeason " + (j+1) + " of " + seasons);
		// } else {
		// }
		// for (int i = 1; i <= races; i++) {
		// if (simulation.equals("Y")) {
		// System.out.println("Result of race " + i + "\n");
		// }
		//
		// if (i%5 == 0) {
		// System.out.print("Racing on Baku City Circuit, Azerbaijan\n");
		// testVersion(2.33);
		// } else if (i%5 == 1) {
		// System.out.print("Racing on Spa-Francorchamps, Belgium\n");
		// testVersion(1.33);
		// } else if (i%5 == 2) {
		// System.out.print("Racing on Silverstone, United Kingdom\n");
		// testVersion(4);
		// } else if (i%5 == 3) {
		// System.out.print("Racing on Monza, Italy\n");
		// testVersion(2.78);
		// } else {
		// System.out.print("Racing on Monte Carlo, Monaco\n");
		// testVersion(5.32);
		// }
		//
		// }
		//
		//

		Results results = runSimulation(5.32);
		results.sortResultsByTime();
		System.out.println("Result: " + results.toString());
	}

	private static ArrayList<Driver> getDriverList()
	{
		return GameController.getDrivers();
	}
	
	private static ArrayList<Car> getCarList() {
		
		return GameController.readCarsFromJSON();
		
	}

	public static double calculateResult(double avgCar, double avgDriver, double trackDiff, double random)
	{

		// The higher the result, the faster the driver has finished
		double result = 0;

		/*
		 * The race results depend on the driver stat average and the car he/she is driving. We multiply the
		 * result by 2 over the track difficulty, later we will add more factors like weather etc. Lastly we
		 * multiply it by the random value generated by the random function to make it more realistic. Drivers
		 * can have a good or bad day and this affects the driver his race results
		 */
		result = (avgCar + avgDriver);
		result = result * (2 / trackDiff);
		result = result * random;

		return result;

	}

	private static double random()
	{
		// Generating a random value between 1.1 and 0.9
		Random value = new Random();
		double random = 0.9 + (1.1 - 0.9) * value.nextDouble();
		return random;
	}

	public static Results runSimulation(double trackDiff)
	{
		// Real results to be returned
		Results simulationResults = new Results();
		// Raw results
		double results[] = new double[22];

		for (int i = 0; i < 22; i++)
		{
			double random = random();

			Car car;
			if (drivers.get(i).getTeamId() == Profile.getTeamID())
			{
				car = Profile.getCar();
			}
			else
			{
				car = cars.get(drivers.get(i).getTeamId()-1);
			}
			double carAverage = 0;
			carAverage = ((car.getAcceleration() + car.getBraking() + car.getHandling() + car.getSpeed())/4);
			
			double driverAverage = drivers.get(i).getAveragePerformance();
			
			results[i] = calculateResult(carAverage, driverAverage, trackDiff, random);

			// Normalize time for simulation
			double time = 200 / (results[i] - 30);

			// Create result for the driver and add to the results
			DriverResult resultForLoop = new DriverResult(i + 1, drivers.get(i), time * 1000);
			simulationResults.addResult(resultForLoop);
		}

		return simulationResults;
	}
}