package com.movieAndgame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndgame.Dao.GameMemberDaoImpl;
import com.movieAndgame.Dto.GameMemberDto;
import com.movieAndgame.Dto.GameMemberLogin;

@Service
public class GameMemberService {
	@Autowired
	private GameMemberDaoImpl gameMemberDaoImpl;
	
	//로그인
	public GameMemberDto login(GameMemberLogin gameMemberLogin) {
		return gameMemberDaoImpl.login(gameMemberLogin);
	}
	
	//회원 가입
	public void joinSave(GameMemberDto gameMemberDto) {
		gameMemberDaoImpl.insert(gameMemberDto);
	}
}
