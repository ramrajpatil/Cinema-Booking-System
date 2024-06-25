package com.cbs.pojos;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cities")
public class City {

	@Id
	private int pincode;
	@Column(length = 20)
	private String cityName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "city", cascade = {CascadeType.ALL})
	private Set<Theater> theaters= new HashSet<>();

	public City(int pincode, String cityName) {
		super();
		this.pincode = pincode;
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "City [pincode=" + pincode + ", cityName=" + cityName + "]";
	}
	
	

}