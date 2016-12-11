package manager.model;

public class Car {
	private Driver driver;
	private Engine engine;
	
	//Getters
	public Driver getDriver(){
		return this.driver;
	}
	
	public Engine getEngine(){
		return this.engine;
	}
	
	//Setters
	public void setDriverToCar(Driver driver){
		this.driver = driver;
	}
	
	public void setEngine(Engine engine){
		this.engine = engine;
	}
}
