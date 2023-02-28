package radius.drone.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="item_type")
public class ItemType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(unique=true, name="name")
	private String name;
	
	@OneToMany(mappedBy="itemType")
    private List<DroneLoadedItem> droneLoadedItems;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DroneLoadedItem> getDroneLoadedItems() {
		return droneLoadedItems;
	}

	public void setDroneLoadedItems(List<DroneLoadedItem> droneLoadedItems) {
		this.droneLoadedItems = droneLoadedItems;
	}
	
	
	

}
