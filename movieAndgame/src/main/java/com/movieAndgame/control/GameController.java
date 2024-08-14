package com.movieAndgame.control;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndgame.Dto.GameMemberDto;
import com.movieAndgame.service.GameMemberService;

@Controller
@RequestMapping("/game")
public class GameController {

	@Autowired
	private GameMemberService gameMemberService;
	
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
		model.addAttribute("gameMemberDto",new GameMemberDto());
		return "game/member/join";
	}
	
	@PostMapping("/signUp")
	public String signUp(@Valid GameMemberDto gameMemeberDto,
			BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "game/member/join";
		}
		gameMemberService.joinSave(gameMemeberDto);
		return "redirect:/game/login";
		
	}
}




