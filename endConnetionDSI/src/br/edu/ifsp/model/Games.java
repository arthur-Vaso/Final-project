package br.edu.ifsp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "people")
public class Games {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String title;
	
	@Column
	private String description;
	
	@Column
	private String hardware;
	
	@Column(name="minimum_age")
	private String minimumAge;
	
	@Column(name="gender_one")
	private String genderOne;
	
	@Column(name="gender_two")
	private String genderTwo;
	
	@Column
	private String price;
	
	@Column
	private String amount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHardware() {
		return hardware;
	}

	public void setHardware(String hardware) {
		this.hardware = hardware;
	}

	public String getMinimumAge() {
		return minimumAge;
	}

	public void setMinimumAge(String minimumAge) {
		this.minimumAge = minimumAge;
	}

	public String getGenderOne() {
		return genderOne;
	}

	public void setGenderOne(String genderOne) {
		this.genderOne = genderOne;
	}

	public String getGenderTwo() {
		return genderTwo;
	}

	public void setGenderTwo(String genderTwo) {
		this.genderTwo = genderTwo;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	
}
