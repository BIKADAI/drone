package radius.drone.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="drone_job")
public class DroneJob {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="starting_date")
	@Temporal(TemporalType.DATE)
	private Date startingDate;
	
	 @Column(name="battery_level")
	 private int batteryLevel;
	 
	 @ManyToOne
	 @JoinColumn(name="drone_id")
	 private Drone drone;
	 
	 @OneToMany(mappedBy="droneJob")
	 private List<DroneLoadedItem> droneLoadedItems;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public int getBatteryLevel() {
		return batteryLevel;
	}

	public void setBatteryLevel(int batteryLevel) {
		this.batteryLevel = batteryLevel;
	}

	public Drone getDrone() {
		return drone;
	}

	public void setDrone(Drone drone) {
		this.drone = drone;
	}

	public List<DroneLoadedItem> getDroneLoadedItems() {
		return droneLoadedItems;
	}

	public void setDroneLoadedItems(List<DroneLoadedItem> droneLoadedItems) {
		this.droneLoadedItems = droneLoadedItems;
	}
	 
	 

}
