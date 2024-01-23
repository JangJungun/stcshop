package kr.co.stcreative.trend.main.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class TrendMainController {
	
	@GetMapping("/mainPage.do")
	public String goMainPage() {
		
		return "login";
	}
	
	@GetMapping("/info.do")
	public String goInfoPage(Model model) {
		
		model.addAttribute("currentMenu","info");
		
		return"main/TrendInfo";
	}
	
	//헤더 테스트용
	@GetMapping("/test.do")
	public String test() {
		
		return "cmm/header";
	}
	//조회페이지 
	@GetMapping("/inquirytrend.do")
	public String goInquiryTrend(Model model) {
		
		model.addAttribute("currentMenu","inquirytrend");
		
		
		return "main/InquiryByTrend";
	}
	
	@GetMapping("/inquiry.do")
	public String inq() {
		
		return "";
	}
	
	
	
	//결과페이지 
	@GetMapping("/trendresult.do")
	public String test3() {
		
		return "main/TrendResult";
	}
	
	
}
