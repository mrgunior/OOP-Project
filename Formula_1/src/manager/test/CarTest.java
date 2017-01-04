package manager.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import manager.model.Car;
import manager.model.Engine;
import manager.model.Upgrades;

public class CarTest
{
	private Car car;
	private Upgrades upgrades;
	int speed, acceleration, handling, braking, weight;

	@Before
	public void setUp()
	{		
		upgrades = new Upgrades(0,0,0,0,0,0,0);
		car = new Car(0,0,0,0,0, upgrades);
	}
	
	@Test
	public void testGetSpeed()
	{
		assertEquals("Speed is equal to speed in Constructor", car.getSpeed(),0);
	}
	
	@Test
	public void testSetSpeed()
	{
		car.setSpeed(1);
		assertEquals("Speed updated correctly via setSpeed()", car.getSpeed(),1);
	}
	
	@Test
	public void testGetAcceleration()
	{
		assertEquals("Acceleration is equal to acceleration in Constructor", car.getAcceleration(),0);
	}
	
	@Test
	public void testSetAcceleration()
	{
		car.setAcceleration(1);
		assertEquals("Speed updated correctly via setSpeed()", car.getAcceleration(),1);
	}
	
	@Test
	public void testGetHandling()
	{
		assertEquals("Handling is equal to handling in Constructor", car.getHandling(),0);
	}
	
	@Test
	public void testSetHandling()
	{
		car.setHandling(1);
		assertEquals("Handling updated correctly via setHandling()", car.getHandling(),1);
	}
	
	@Test
	public void testGetBraking()
	{
		assertEquals("Braking is equal to braking in Constructor", car.getBraking(),0);
	}
	
	@Test
	public void testSetBraking()
	{
		car.setBraking(1);
		assertEquals("Braking updated correctly via setBraking()", car.getBraking(),1);
	}
	
	@Test
	public void testGetWeight()
	{
		assertEquals("Weight is equal to weight in Constructor", car.getWeight(),0);
	}
	
	@Test
	public void testSetWeight()
	{
		car.setWeight(1);
		assertEquals("Weight updated correctly via setWeight()", car.getWeight(),1);
	}
	
	@Test
	public void testGetUpgrades()
	{
		assertTrue("Objects that are equal should be the same", upgrades.equals(car.getUpgrades()));
	}
	
	@Test
	public void testSetUpgrades()
	{
		Upgrades upgradesTest = new Upgrades(1,1,1,1,0,0,0);
		car.setUpgrades(upgradesTest);
		assertTrue("Objects that are equal should be the same", upgradesTest.equals(car.getUpgrades()));
	}

	@Test
	public void testConstructorCarSpeed()
	{
		assertEquals(car.getSpeed(), speed);
	}
	
	@Test
	public void testConstructorCarAcceleration()
	{
		assertEquals(car.getAcceleration(), acceleration);
	}
	
	@Test
	public void testConstructorCarHandling()
	{
		assertEquals(car.getHandling(), handling);
	}
	
	@Test
	public void testConstructorCarBraking()
	{
		assertEquals(car.getBraking(), braking);
	}
	
	@Test
	public void testConstructorCarWeight()
	{
		assertEquals(car.getWeight(), weight);
	}

	@Test
	public void testConstructorUpgrades()
	{
		assertEquals(car.getUpgrades(), upgrades);
	}
}
