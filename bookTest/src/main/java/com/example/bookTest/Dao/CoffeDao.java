package com.example.bookTest.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.bookTest.Dto.CoffeDto;

@Repository
public class CoffeDao {
	private final JdbcTemplate db;
	
	@Autowired
	public CoffeDao(JdbcTemplate jdbc) {
		this.db= jdbc;
	}
	
	// 커피 삭제
	public void	delete(int bid) {
		String sql="delete from coffe where coffe_id=?";
		
		db.update(sql, bid);
	}
	
	
	
	// 커피메뉴상세 
	public CoffeDto findById(int cid) {
		String sql="select * from coffe where coffe_id=?";
		
		CoffeDto dto = db.queryForObject(sql, new CoffeDtoRowMapper(), cid);
		
		return dto;
	}
	
	
	public List<CoffeDto> select(){
		String sql="select * from coffe";
		
		List<CoffeDto> list = db.query(sql , new CoffeDtoRowMapper() );
		
		return list;
	}
	
	
	public void save(CoffeDto coffeDto) {
		String sql="insert into coffe(item_name, price, decaffein) "+
				" values(?,?,?)";
		
		db.update(sql , coffeDto.getItemName(), coffeDto.getPrice(),
				coffeDto.isDecaffein() );
	}
	
	public class CoffeDtoRowMapper implements RowMapper<CoffeDto>{

		@Override
		public CoffeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			CoffeDto dto = new CoffeDto();
			dto.setDecaffein(rs.getBoolean("decaffein"));
			dto.setPrice( rs.getInt("price"));
			dto.setItemName( rs.getString("item_name"));
			dto.setCoffeId( rs.getInt("coffe_id"));
			return dto;
		}
		
	}

	public void update(CoffeDto coffeDto) {
		
		String sql = "update coffe set item_name=? , price=?, decaffein=? "+
				" where coffe_id=?";
		
		db.update(sql , coffeDto.getItemName(), coffeDto.getPrice(), 
				coffeDto.isDecaffein() , coffeDto.getCoffeId());
		
	}
}



