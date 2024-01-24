package kr.co.stcreative.trend.main.web;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.stcreative.trend.main.service.ApiDatalabTrendService;
import kr.co.stcreative.trend.main.service.TrendInquiryVO;

@Controller
@RequestMapping("/main")
public class TrendMainController {
	
	//Api Service
	private ApiDatalabTrendService apiDatalabTrendService;
	
	@Autowired
	public TrendMainController(ApiDatalabTrendService apiDatalabTrendService) {
		this.apiDatalabTrendService=apiDatalabTrendService;
	}
	
	
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
	
	@PostMapping("/inquiry.do")
	public String inq(TrendInquiryVO trendInquiryVO, Model model) {
		
		System.out.println(trendInquiryVO.toString());
		String result = apiDatalabTrendService.getTrendData(trendInquiryVO);
		
		System.out.println(result);
		model.addAttribute("trendData", result);
		    
		/*		try {
		    ObjectMapper mapper = new ObjectMapper();
		    JsonNode resultNode = mapper.readTree(result);
		    model.addAttribute("trendData", resultNode);
		} catch (JsonProcessingException e) {
		    e.printStackTrace();
		    // JSON 변환 오류 처리
		} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
		
		
		return "main/TrendResult";
	}
	
	
	
	//결과페이지 
	@GetMapping("/trendresult.do")
	public String test3() {
		
		return "main/TrendResult";
	}
	
	
}
