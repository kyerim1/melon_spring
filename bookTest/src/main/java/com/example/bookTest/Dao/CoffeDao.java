package com.example.bookTest.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.bookTest.Dto.CoffeDto;

@Repository
public class CoffeDao {
	private final JdbcTemplate db;
	
	@Autowired
	public CoffeDao(JdbcTemplate jdbc) {
		this.db= jdbc;
	}
	
	public void save(CoffeDto coffeDto) {
		String sql="insert into coffe(item_name, price, decaffein) "+
				" values(?,?,?)";
		
		db.update(sql , coffeDto.getItemName(), coffeDto.getPrice(),
				coffeDto.getDecaffein() );
	}
}



