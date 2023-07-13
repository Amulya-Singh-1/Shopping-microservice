package com.userService.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uId;
	private String name;
	private String phone;

	@Transient	
	List<Product> products=new ArrayList<>();

	public User(Integer uId, String name, String phone) {
		super();
		this.uId = uId;
		this.name = name;
		this.phone = phone;
	}

}
