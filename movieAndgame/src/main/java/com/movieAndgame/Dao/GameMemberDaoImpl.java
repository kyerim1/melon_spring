package com.movieAndgame.Dao;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndgame.Dto.GameMemberDto;

@Mapper
public interface GameMemberDaoImpl {
	public int insert(GameMemberDto gameMemberDto);
}
