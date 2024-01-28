package kr.co.stcreative.trend.main.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.stcreative.trend.main.service.ApiDatalabKeywordService;
import kr.co.stcreative.trend.main.service.ApiDatalabTrendService;
import kr.co.stcreative.trend.main.service.ApiSearchService;
import kr.co.stcreative.trend.main.service.TrendInquiryVO;

@Controller
@RequestMapping("/main")
public class TrendMainController {
	
	//Api Service
	private ApiDatalabTrendService apiDatalabTrendService;
	private ApiDatalabKeywordService apiDatalabKeywordService;
	private ApiSearchService apiSearchService;
	
	@Autowired
	public TrendMainController(ApiDatalabTrendService apiDatalabTrendService
							  ,ApiDatalabKeywordService apiDatalabKeywordService
							  ,ApiSearchService apiSearchService) {
		
		this.apiDatalabTrendService=apiDatalabTrendService;
		this.apiDatalabKeywordService=apiDatalabKeywordService;
		this.apiSearchService=apiSearchService;
	}
	
	//login 페이지
	@GetMapping("/mainPage.do")
	public String goMainPage() {
		
		return "login";
	}
	
	//마이페이지
	@GetMapping("/info.do")
	public String goInfoPage(Model model) {
		
		model.addAttribute("currentMenu","info");
		
		return"main/TrendInfo";
	}
	
	//조회페이지 
	@GetMapping("/inquirytrend.do")
	public String goInquiryTrend(Model model) {
		
		model.addAttribute("currentMenu","inquirytrend");
		
		
		return "main/InquiryByTrend";
	}
	
	//트렌드 분석 요청 후 결과페이지
	@PostMapping("/inquiry.do")
	public String inq(TrendInquiryVO trendInquiryVO, Model model) {
		
		System.out.println(trendInquiryVO.toString());
		//String result = apiDatalabTrendService.getTrendData(trendInquiryVO);
		
		String result;
		//검색어가 없을땐 일반 통계조회 API, 검색이가 있을땐 검색어 통계조회 API로 이동
		if (trendInquiryVO.getKeyword() == null || trendInquiryVO.getKeyword().length == 0) {
			result = apiDatalabTrendService.getTrendData(trendInquiryVO);
		} else {
			// keyword 값이 있을 경우에는 검색어 통계조회 api 실행
			result = apiDatalabKeywordService.getTrendData(trendInquiryVO);
		}
		//상품추천을 위한 검색 api 실행
		String searchData[] = apiSearchService.getSearchData(trendInquiryVO);
		
		System.out.println("*result: "+result);
		
		for(String data:searchData) {
			System.out.println("*SearchData: "+data);
		}

		ObjectMapper mapper = new ObjectMapper();
		List<Map<String, Object>> list = new ArrayList<>();
		for (String data : searchData) {
		    try {
		        Map<String, Object> map = mapper.readValue(data, new TypeReference<Map<String, Object>>(){});
		        list.add(map);
		    } catch (JsonProcessingException e) {
		        e.printStackTrace();
		    }
		}
		model.addAttribute("searchData", list);
	    
		//model.addAttribute("searchData", searchData);

		model.addAttribute("trendData", result);
		    
		
		return "main/TrendResult";
	}
	
	
	
	
	
	
}
