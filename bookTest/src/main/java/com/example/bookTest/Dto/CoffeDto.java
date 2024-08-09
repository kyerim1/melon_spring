package com.example.bookTest.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CoffeDto {
	private int coffeId;
	private String itemName;
	private int price;
	private boolean decaffein;
}
