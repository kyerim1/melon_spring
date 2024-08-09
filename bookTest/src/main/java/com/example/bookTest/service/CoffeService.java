package com.example.bookTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookTest.Dao.CoffeDao;
import com.example.bookTest.Dto.CoffeDto;

@Service
public class CoffeService {
	
	@Autowired
	private CoffeDao coffeDao;
	
	
	public List<CoffeDto> selectAll(){
		
		return coffeDao.select();
	}
	
	
	public void menuInsert(CoffeDto coffeDto) {
		if( coffeDto != null)
			coffeDao.save(coffeDto);
	}
}









