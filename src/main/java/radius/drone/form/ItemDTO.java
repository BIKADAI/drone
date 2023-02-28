
package radius.drone.form;

public class ItemDTO {
	
	private String name;
	private int weight;
	private String code;
	private byte[] image;
	private int quantity;
	
	
	
	public ItemDTO(String name, int weight, String code, byte[] image, int quantity) {
		super();
		this.name = name;
		this.weight = weight;
		this.code = code;
		this.image = image;
		this.quantity = quantity;
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
	
	
}
