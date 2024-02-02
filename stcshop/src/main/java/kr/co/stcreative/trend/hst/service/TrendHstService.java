package kr.co.stcreative.trend.hst.service;

import java.util.List;

/**
 * <p>트렌드 조회이력 서비스 인터페이스</p>
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
public interface TrendHstService {
	
	/**
	 * <p>트렌드 분류 조회의 이력을 저장한다.</p>
	 * 
	 * @param vo 사용자의 조회이력 정보가 담긴 TrendInqHstVO객체.
	 */
	void insertInqHst(TrendInqHstVO vo);
	
	/**
	 * <p>트렌드 검색어 조회의 이력을 저장한다.</p>
	 * 
	 * @param vo 사용자의 조회이력 정보가 담긴 TrendInqGdsHstVO객체.
	 */
	void insertInqGdsHst(TrendInqGdsHstVO vo);
	
	/**
	 * <p>트렌드 조회이력을 조회한다.</p>
	 * 
	 * @param id 조회하고자 하는 사용자의 ID 값
	 * @return 트렌드 조회이력의 List
	 */
	List<TrendInqHstVO> selectHstById(String id);
	
}
