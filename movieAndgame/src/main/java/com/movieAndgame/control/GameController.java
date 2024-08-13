package com.movieAndgame.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndgame.Dto.GameMemberDto;

@Controller
@RequestMapping("/game")
public class GameController {

	// localhost/game/index 매핑
	@GetMapping("/index")
	public String home(Model model) {
		
		return "game/index";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		
		model.addAttribute("gameMember" , new GameMemberDto());		
		return "game/member/login";
	}
	
	//회원 가입 양식 페이지 요청
	@GetMapping("/signUp")
	public String signup(Model model) {
		
		return "game/member/join";
	}
}




