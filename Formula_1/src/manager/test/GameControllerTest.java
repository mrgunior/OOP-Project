package manager.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import manager.controller.GameController;
import manager.model.Profile;
import manager.model.Upgrades;
import manager.model.Car;
import manager.model.Driver;

public class GameControllerTest 
{
	GameController gamecontroller;
	Profile testProfile;
	String teamname ="TestTeam", jsonFile = "src/manager/test/dataTest.dat";
	double highScore = 50.0, budget = 200.0;
	List<Car> cars = new ArrayList<Car>();
	Car car1, car2;
	List<Driver> drivers = new ArrayList<Driver>();
	Upgrades upgrades;
	
	@Before
	public void setUp() throws IOException
	{	
		gamecontroller = new GameController(jsonFile);
		testProfile = new Profile(highScore, budget, teamname);
		
		upgrades = new Upgrades(0,0,0,0,0,0,0);
		car1 = new Car(0,0,0,0,0, upgrades);
		car2 = new Car(0,0,0,0,0, upgrades);
		
		testProfile.setCars(cars);
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
		//highScore is 50 in the jsonFile
		assertFalse("After readJsonObjectAndInitialize has been called profile should have been created", gamecontroller.getProfile().equals(testProfile));
	}
	
	@Test
	public void testReadJsonObjectAndInitializeSameHighScore()
	{
		//highScore is 50 in the jsonFile
		//testProfile.setHighScore(50.0);
		/*
		System.out.println("Victor " + testProfile.getHighScore());
		System.out.println("Victor " + gamecontroller.getProfile().getHighScore());
		System.out.println("Victor " + testProfile.getBudget());
		System.out.println("Victor " + gamecontroller.getProfile().getBudget());*/
		assertTrue("After readJsonObjectAndInitialize has been called profile should have been created", gamecontroller.getProfile().equals(testProfile));
	}
}