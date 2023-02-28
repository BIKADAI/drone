package radius.drone.form;

import radius.drone.util.DroneModel;
import radius.drone.util.DroneState;

public class DroneDTO {

	private String serialNumber;
	
	private DroneModel model;
	private int weight;
	private int currentBattery;
	private DroneState state;
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public DroneModel getModel() {
		return model;
	}
	public void setModel(DroneModel model) {
		this.model = model;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getCurrentBattery() {
		return currentBattery;
	}
	public void setCurrentBattery(int currentBattery) {
		this.currentBattery = currentBattery;
	}
	public DroneState getState() {
		return state;
	}
	public void setState(DroneState state) {
		this.state = state;
	}
	public DroneDTO(String serialNumber, DroneModel model, int weight, int currentBattery, DroneState state) {
		super();
		this.serialNumber = serialNumber;
		this.model = model;
		this.weight = weight;
		this.currentBattery = currentBattery;
		this.state = state;
	}
	
	
	

	
}
