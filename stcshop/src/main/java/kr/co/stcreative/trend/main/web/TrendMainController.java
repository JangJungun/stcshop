package kr.co.stcreative.trend.main.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TrendMainController {
	
	@GetMapping("/main/mainPage.do")
	public String goMainPage() {
		
		return "main/login";
	}
	
	//헤더 테스트용
	@GetMapping("/test.do")
	public String test() {
		
		return "cmm/header";
	}
	//헤더 테스트용
	@GetMapping("/test2.do")
	public String test2() {
		
		return "main/InquiryByTrend";
	}
}
