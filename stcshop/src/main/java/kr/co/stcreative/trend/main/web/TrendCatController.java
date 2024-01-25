package kr.co.stcreative.trend.main.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.stcreative.trend.main.service.TrendCatService;
import kr.co.stcreative.trend.main.service.TrendCatVO;

@Controller
public class TrendCatController {
	//Trend Service 관련
	private TrendCatService trendMainService;
	
	@Autowired
	public TrendCatController(TrendCatService trendMainService) {
		
		this.trendMainService=trendMainService;
	}
	
	
	@GetMapping("/getCategoryOne.do")
	@ResponseBody
	public List<TrendCatVO> selectOptionsOne() {
		
		List<TrendCatVO> list = trendMainService.selectOptionsOne();
		
		return list;
	}
	
	@GetMapping("/getCategoryTwo.do")
	@ResponseBody
	public List<TrendCatVO> selectOptionsTwo(TrendCatVO vo) {
		
		List<TrendCatVO> list = trendMainService.selectOptionsTwo(vo);
		
		return list;
	}
	
	@GetMapping("/getCategoryThr.do")
	@ResponseBody
	public List<TrendCatVO> selectOptionsThr(TrendCatVO vo) {
		return trendMainService.selectOptionsThr(vo);
	}
	
	
	
}
