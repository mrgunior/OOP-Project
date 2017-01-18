package manager.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import manager.model.Profile;
import manager.model.Upgrades;
import manager.model.Car;
import manager.model.Driver;
import manager.model.GameController;

import static org.hamcrest.CoreMatchers.*;

public class GameControllerTest 
{/*
	private GameController gamecontroller;
	private Profile testProfile;
	private String teamname ="TestTeam", jsonFile = "src/manager/test/dataTest.json";
	private double highScore = 50.0, budget = 200.0;
	private List<Car> cars = new ArrayList<Car>();
	private Car car1, car2;
	private List<Driver> drivers = new ArrayList<Driver>();
	private Driver driver1, driver2;
	
	@Before
	public void setUp() throws IOException
	{	
		gamecontroller = new GameController(jsonFile);
		testProfile = new Profile(highScore, budget, teamname);
		
		car1 = new Car(0,0,0,0,0, new Upgrades(0,0,0,0,0,0,0));
		car2 = new Car(0,0,0,0,0, new Upgrades(1,1,1,1,1,1,1));
		cars.add(car1);
		cars.add(car2);
		
		driver1 = new Driver(0,0,"",0,0,0,0,0,0.0);
		driver2 = new Driver(0,0,"",0,0,0,0,0,0.0);
		drivers.add(driver1);
		drivers.add(driver2);
		
		testProfile.setCar(car1);
		testProfile.setDrivers(drivers);
	}
	
	@After
	public void tearDown() throws IOException
	{
		//need to do this otherwise after time you run a test it use recourse and not close it.
		gamecontroller.stopAutoSave();
	}
	
	//need fixing.
	@Test(timeout=2*60*1000)
	public void testAutoSaveIfItSavesEvery2Minutes()
	{
		//gamecontroller.autoSave();
	}
	
	//need fixing.
	@Test
	public void testStopAutoSave() throws IOException
	{
		//gamecontroller.stopAutoSave();
	}
	
	@Test
	public void testReadJsonObjectAndInitializeDifferentHighScore()
	{
		assertFalse("After readJsonObjectAndInitialize has been called profile should have been created", gamecontroller.getProfile().equals(testProfile));
	}
	
	@Test
	public void testReadJsonObjectAndInitializeSameHighScore()
	{	
		assertTrue("After readJsonObjectAndInitialize has been called profile should have been created", gamecontroller.getProfile().getHighScore() == testProfile.getHighScore());
	}
	
	@Test
	public void testReadJsonObjectAndInitializeSameBudget()
	{
		assertTrue("After readJsonObjectAndInitialize has been called profile should have been created", gamecontroller.getProfile().getBudget() == testProfile.getBudget());
	}
	
	@Test
	public void testReadJsonObjectAndInitializeSameTeamName()
	{
		assertTrue("After readJsonObjectAndInitialize has been called profile should have been created", gamecontroller.getProfile().getTeamName().equals(testProfile.getTeamName()));
	}
	
	@Test
	public void testReadJsonObjectAndInitializeSameCarList()
	{
		//System.out.print("victor"+gamecontroller.getProfile().getCars().toString());
		//assertEquals("both toString should be the same", gamecontroller.getProfile().getCars().toString(), equalTo("[<Car[speed: 0, braking: 0, acceleration: 0, weight: 0, handling: 0, Upgrades[weightRed: 0, down: 0, susp: 0, tires: 0, gearbox: 0, aero: 0, engine: 0]>]>, <Car[speed: 0, braking: 0, acceleration: 0, weight: 0, handling: 0, Upgrades[weightRed: 1, down: 1, susp: 1, tires: 1, gearbox: 1, aero: 1, engine: 1]>]>]"));
	}*/
}