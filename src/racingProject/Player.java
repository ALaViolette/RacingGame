package racingProject;

public class Player {


	private String name;
	private double cash;
	private Car vehicle;

	
	public Player(String n){
		name = n;
		cash = 100;
		
	}
	public void setCash(double c){
		cash = c;
	}

	public String getName(){
		return name;
	}
	
	public double getCash(){
		return cash;
	}
	
	
	public void setVehicle (Car car){
		vehicle = car;
		
	}
	
	public Car getVehicle(){
		
		return vehicle;
		
	}
}
