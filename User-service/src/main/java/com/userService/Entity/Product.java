package com.userService.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Integer pId;
	private String productName;
	private Integer prouductPrice;
	private Integer uId;
}
