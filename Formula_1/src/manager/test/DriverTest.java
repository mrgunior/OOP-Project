package manager.test;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import manager.model.Driver;

public class DriverTest 
{
	private Driver driver;
	private String name;
	private int number, speed, acceleration, turning;
	private double averagePerformance, salary;

	@Before
	public void setUp() 
	{ 
		name = "Victor Wernet";
		number = 33;
		speed = 80;
		acceleration = 75;
		turning = 69;
		averagePerformance = 138000.0; //(double)(speed*acceleration*turning)/(double)3
		salary = 3.0; //3 mil
		
		driver = new Driver(name, number, speed, acceleration, turning, salary);
	}
	
	@Test
	public void testGetName()
	{
		assertEquals("driver name has been initialized correctly via constructor", driver.getName(), name);
	}
	
	@Test
	public void testSetName()
	{
		driver.setName("Bob");
		assertTrue("driver name has been set correctly via setName()", driver.getName().equals("Bob"));
	}
	
	@Test
	public void testGetNumber()
	{
		assertEquals("driver name has been initialized correctly via constructor", driver.getNumber(), number);
	}
	
	@Test
	public void testSetNumber()
	{
		driver.setNumber(1);
		assertTrue("driver number has been set correctly via setNumber()", driver.getNumber()==1);
	}
	
	@Test
	public void testGetSpeed()
	{
		assertEquals("driver speed has been initialized correctly via constructor", driver.getSpeed(), speed);
	}
	
	@Test
	public void testSetSpeed()
	{
		driver.setSpeed(1);
		assertTrue("driver speed has been set correctly via setSpeed()", driver.getSpeed()==1);
	}
	
	@Test
	public void testGetAcceleration()
	{
		assertEquals("driver acceleration has been initialized correctly via constructor", driver.getAcceleration(), acceleration);
	}
	
	@Test
	public void testSetAcceleration()
	{
		driver.setAcceleration(1);
		assertTrue("driver acceleration has been set correctly via setAcceleration()", driver.getAcceleration()==1);
	}
	
	@Test
	public void testGetTurning()
	{
		assertEquals("driver turning has been initialized correctly via constructor", driver.getTurning(), turning);
	}
	
	@Test
	public void testSetTurning()
	{
		driver.setTurning(1);
		assertTrue("driver turning has been set correctly via setTurning()", driver.getTurning()==1);
	}
	
	@Test
	public void testGetAveragePerformance()
	{
		assertEquals("Average performance is calculated correctly with regards to arithmetic calculations", driver.getAveragePerformance(), averagePerformance, 0.001);
	}
	
	@Test
	public void testGetSalary()
	{
		assertEquals("", driver.getSalary(), salary, 0.001);
	}
	
	@Test
	public void testSetSalary()
	{
		driver.setSalary(1.0);
		assertTrue("driver salary has been set correctly via setSalary()", driver.getSalary()==1.0);
	}
}