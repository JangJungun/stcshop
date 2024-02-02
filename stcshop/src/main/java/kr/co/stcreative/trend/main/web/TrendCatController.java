package kr.co.stcreative.trend.main.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.stcreative.trend.main.service.TrendCatService;
import kr.co.stcreative.trend.main.service.TrendCatVO;

/**
 * <p>트렌드 분류값 조회 컨트롤러.</p>
 * <p>사용자가 통계조회시 설정할 분류옵션을 동적으로 가져옴</p>
 *  
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 * 2024-01-22   장준근          신규개발
 *
 * </pre>
 * @author SI&컨설팅 사업본부 장준근
 * @since 1.0.0
 * 
 */
@Controller
public class TrendCatController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private TrendCatService trendCatService;
	
	@Autowired
	public TrendCatController(TrendCatService trendMainService) {
		
		this.trendCatService=trendMainService;
	}
	
	/**
	 * <p>대분류명, 분류코드를 가져오는 메서드</p>
	 * 
	 * @return 대분류명, 분류코드의 List를 반환
	 */
	@GetMapping("/getCategoryOne.do")
	@ResponseBody
	public List<TrendCatVO> selectOptionsOne() {
		logger.info("selectOptionsOne 진입");
		
		List<TrendCatVO> list = trendCatService.selectOptionsOne();
		
		return list;
	}
	
	/**
	 * <p>사용자가 선택한 대분류의 하위 중분류명, 분류코드를 가져오는 메서드</p>
	 * 
	 * @param TrendCatVO vo : 사용자가 선택한 대분류의 정보
	 * @return 중분류명, 분류코드의 List를 반환
	 */
	@GetMapping("/getCategoryTwo.do")
	@ResponseBody
	public List<TrendCatVO> selectOptionsTwo(TrendCatVO vo) {
		logger.info("selectOptionsTwo 진입");
		
		List<TrendCatVO> list = trendCatService.selectOptionsTwo(vo);
		
		return list;
	}
	
	/**
	 * <p>사용자가 선택한 중분류의 하위 소분류명, 분류코드를 가져오는 메서드</p>
	 * 
	 * @param TrendCatVO vo : 사용자가 선택한 중분류의 정보
	 * @return 소분류명, 분류코드의 List를 반환
	 */
	@GetMapping("/getCategoryThr.do")
	@ResponseBody
	public List<TrendCatVO> selectOptionsThr(TrendCatVO vo) {
		logger.info("selectOptionsThr 진입");
		
		List<TrendCatVO> list = trendCatService.selectOptionsThr(vo);
		
		return list;
	}
	
	
	
}
