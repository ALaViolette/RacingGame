package racingProject;
public class Car {
	private String make;
	private String model;
	private double quarterMile;

	public double getQuarterMileTime() {
		//this.quarterMile=quarterMile;
			quarterMile = (Math.random() * 10);
			return quarterMile;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Car make: " + make + "\t model: " + model;
	}

}
