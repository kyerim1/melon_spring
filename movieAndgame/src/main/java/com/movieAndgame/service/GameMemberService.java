package com.movieAndgame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndgame.Dao.GameMemberDaoImpl;
import com.movieAndgame.Dto.GameMemberDto;

@Service
public class GameMemberService {
	@Autowired
	private GameMemberDaoImpl gameMemberDaoImpl;
	
	public void joinSave(GameMemberDto gameMemberDto) {
		gameMemberDaoImpl.insert(gameMemberDto);
	}
}
