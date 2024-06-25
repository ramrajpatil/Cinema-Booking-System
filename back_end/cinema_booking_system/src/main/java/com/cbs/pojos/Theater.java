package com.cbs.pojos;

import java.util.HashSet;
import java.util.Set;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "theaters")
public class Theater {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 20)
	private String theaterName;
	@Column(length = 40)
	private String address;
	private int capacity;
//	@Version
//	private Integer version;

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "city_id")
	@JsonIgnore
	private City city;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "theaters", cascade = {CascadeType.ALL})
	@JsonIgnore
	private Set<Movie> movies = new HashSet<>();
	
	
	@Override
	public String toString() {
		return "Theater id= " + id + "theaterName=" + theaterName + ", address=" + address + ", capacity="
				+ capacity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Theater other = (Theater) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Theater(Integer id, String theaterName, String address, int capacity) {
		super();
		this.id = id;
		this.theaterName = theaterName;
		this.address = address;
		this.capacity = capacity;
	}

	

	

}
