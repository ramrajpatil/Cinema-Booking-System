package com.cbs.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {

	@Column(length = 20)
	private String name;
	@Column(length = 20, unique = true)
	private String email;
	@Column(length = 20)
	private String password;
	@Enumerated(EnumType.STRING)
	private UserRole role;

	@Override
	public String toString() {
		return "User id=" + getId() + "name=" + name + ", email=" + email + ", password=" + password + ", role=" + role;
	}
}
