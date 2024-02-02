package kr.co.stcreative.trend.main.service;

import java.util.List;

/**
 * <p>트렌드 카테고리 서비스 인터페이스</p>
 *  
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
public interface TrendCatService {

	/**
	 * <p>대분류값의 List를 가져옴</p>
	 * 
	 * @return 대분류값의 List
	 */
	List<TrendCatVO> selectOptionsOne();
    
	/**
	 * <p>중분류값의 List를 가져옴</p>
	 * 
	 * @param 사용자가 선택한 대분류값의 정보
	 * @return 중분류값의 List
	 */
	List<TrendCatVO> selectOptionsTwo(TrendCatVO vo);
    
	/**
	 * <p>소분류값의 List를 가져옴</p>
	 * 
	 * @param 사용자가 선택한 중분류값의 정보
	 * @return 소분류값의 List
	 */
	List<TrendCatVO> selectOptionsThr(TrendCatVO vo);
	
}
