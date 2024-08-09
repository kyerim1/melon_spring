package com.example.bookTest.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookTest.Dto.BookDto;
import com.example.bookTest.Dto.CoffeDto;
import com.example.bookTest.service.CoffeService;

@Controller
public class CoffeControl {

	@Autowired
	private CoffeService coffeService;
	
	@GetMapping("/coffe")
	public ModelAndView home() {
		ModelAndView mv =new ModelAndView("coffe/index");
		
		List<CoffeDto> list = coffeService.selectAll();
		mv.addObject("list", list);
		
		return mv;
	}
	
	
	@GetMapping("/coffeReg")
	public String write() {
		return "coffe/coffeForm";
	}
	
	@PostMapping("/coffeSave")
	public String menuSave( @ModelAttribute CoffeDto coffeDto) {
		coffeService.menuInsert(coffeDto);		
		return "redirect:/coffe";
	}
	
	
	@GetMapping("/coffee/view")
	public ModelAndView view(@RequestParam("id") int id) {
		
		CoffeDto dto = coffeService.getMenu(id);
		return new ModelAndView("coffe/view").addObject("menu",dto);
	}
	
	
	@GetMapping("/coffee/delete")
	public String remove( @RequestParam("id") int id) {
		coffeService.remove(id);
		return "redirect:/coffe";		
	}
	
	
}






