package mgra.model;

import java.io.Serializable;

public class Car implements Serializable{
	
	
	
	private Long id;
	private String brand;
	private String model;
	private String capacity;
	
	public Car(Long id, String brand, String model, String capacity) {
		
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.capacity = capacity;
	}

	public Car() {
		this(0L,"","","");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	
	
}
