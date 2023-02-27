package radius.drone.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import radius.drone.util.DroneState;

@Entity
@Table(name="drone")
public class Drone {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="serianl_number")
	private String serialNumber;
	
	@Column(name="weight")
	private double weight;
	
	@Column(name="current_battery")
	private int currentBattery;
	
	@Column(name="state")
	@Enumerated(EnumType.STRING)
	private DroneState state;
	
	@OneToMany(mappedBy="drone")
	private  List<DroneJob> droneJobs ;
	
	@OneToMany(mappedBy="drone")
	private  List<DroneBatteryHistory> droneBatteryHistories ;
	
	@ManyToOne
	@JoinColumn(name="model_id", nullable=false)
	private  DroneModel droneModel ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
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

	public List<DroneJob> getDroneJobs() {
		return droneJobs;
	}

	public void setDroneJobs(List<DroneJob> droneJobs) {
		this.droneJobs = droneJobs;
	}

	public List<DroneBatteryHistory> getDroneBatteryHistories() {
		return droneBatteryHistories;
	}

	public void setDroneBatteryHistories(List<DroneBatteryHistory> droneBatteryHistories) {
		this.droneBatteryHistories = droneBatteryHistories;
	}

	public DroneModel getDroneModel() {
		return droneModel;
	}

	public void setDroneModel(DroneModel droneModel) {
		this.droneModel = droneModel;
	}

	
	
	
}