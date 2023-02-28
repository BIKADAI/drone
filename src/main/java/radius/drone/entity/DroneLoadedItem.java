package radius.drone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table
@Entity(name="drone_loaded_item")
public class DroneLoadedItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="weight")
	private int weight;
	
	@Column(name="code")
	private String code;
	
	@Lob
	@Column(name = "image", columnDefinition="BLOB")
	private byte[] image;
	
	@Column(name="quantity")
	private int quantity;

	@ManyToOne
	@JoinColumn(name="drone_job_id")
	private DroneJob droneJob;
	
	@ManyToOne
	@JoinColumn(name="item_type_id")
	private ItemType itemType;
	
	
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

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public DroneJob getDroneJob() {
		return droneJob;
	}

	public void setDroneJob(DroneJob droneJob) {
		this.droneJob = droneJob;
	}

	public ItemType getItemType() {
		return itemType;
	}

	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}
	

}
