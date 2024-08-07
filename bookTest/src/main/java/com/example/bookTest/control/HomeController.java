package com.example.bookTest.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookTest.Dto.BookInfoDto;
import com.example.bookTest.Dto.InfoDto;

@Controller
public class HomeController {
	
	@GetMapping("/write")
	public String bookWrite() {
		return "bookWrite";
	}
	
	
	@GetMapping("/detail")
	public ModelAndView bookDetail( @ModelAttribute BookInfoDto bookInfoDto) {
		ModelAndView mv =new ModelAndView("bookDetail");
		mv.addObject("book", bookInfoDto);
		return mv;
	}
	
	
	
	// 요청 주소와 메서드를 매핑(연결) 시켜준다.
	@GetMapping("/home")
	public String homeView() { // 뷰 페이지만 제공 하는경우에 페이지 이름만넘긴다.
		return "home";
	}
	
	@GetMapping("/infoInput")
	public ModelAndView info( @ModelAttribute InfoDto infoDto ) {
	//	System.out.println( infoDto.getUName() );
	//  ModelAndView는 사용자에게 제공할 페이지와 데이터를 저장할수 있는 클래스이다.
	//  사용자에게 제공할 페이지는 객체 생성시 입력하거나 setViewName메서드로 입력하면된다.
		ModelAndView mv= new ModelAndView("info");
	//	mv.setViewName("info") 메서드로 제공 페이지입력
		
		String byear = infoDto.getUBirth().substring( 0, 4);
		int age=2024 - Integer.parseInt(byear);
		mv.addObject("ageData" , age); // 뷰 페이지에 전달할 데이터 설정
		
		return mv;
	}
}






