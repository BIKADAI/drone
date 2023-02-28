package radius.drone.form;

import java.util.List;

public class LoadDroneDTO {
	
	private String serialNumber;
	private List <ItemDTO> items;
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public List<ItemDTO> getItems() {
		return items;
	}
	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}
	

}
