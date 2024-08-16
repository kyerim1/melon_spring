package com.movieAndgame.Dao;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndgame.Dto.GameMemberDto;
import com.movieAndgame.Dto.GameMemberLogin;

@Mapper
public interface GameMemberDaoImpl {
	public int insert(GameMemberDto gameMemberDto);
	public GameMemberDto login(GameMemberLogin gameMemberLogin);// 로그인
}
