package com.movieAndgame.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndgame.Dao.GamePostDaoImpl;
import com.movieAndgame.Dto.GamePostDto;

@Service
public class GamePostService {

	@Autowired
	private GamePostDaoImpl gamePostDaoImpl;
	
	public List<GamePostDto> list(){
		return gamePostDaoImpl.findAll();
	}
	
	
	public void write(@Valid GamePostDto gamePostDto) {
		gamePostDaoImpl.save(gamePostDto);
		
	}

}
