package com.movieAndgame.control;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndgame.Dto.GameMemberDto;
import com.movieAndgame.Dto.GamePostDto;
import com.movieAndgame.service.GamePostService;


@Controller
@RequestMapping("/gamePost")
public class GamePostControl {

	@Autowired
	private GamePostService gamePostService;
	@GetMapping("/m")
	public String index(Model model) {
		
		model.addAttribute("mList",gamePostService.list());
		
		return "game/post/index";
	}
	
	@GetMapping("/write")
	public String write(Model model,HttpSession session) {
		if(session.getAttribute("user") ==null) {// 로그인 상태가 아니면 로그인페이지이동
			return "redirect:/game/login";
		}
		
		GamePostDto dto = new GamePostDto();		
		String name = ((GameMemberDto)session.getAttribute("user")).getNick_name();
		dto.setWriter(name);
		
		model.addAttribute("gamePostDto",dto);
		
		return "game/post/gamewrite";
	}
	
	
	@PostMapping("/write")
	public String write(@Valid GamePostDto gamePostDto,
			BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
			return "game/post/gamewrite";
		}
		gamePostService.write(gamePostDto);
		return "redirect:/gamePost/m";
	}
	@GetMapping("/view/{id}")
	public String detail(@PathVariable("id") int id, Model model) {
		model.addAttribute("gamePostDto", gamePostService.detail(id));
		return "game/post/detail";
	}
}
