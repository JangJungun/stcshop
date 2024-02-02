package kr.co.stcreative.trend.hst.mapper;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import kr.co.stcreative.trend.hst.service.TrendInqGdsHstVO;

/**
 * <p>트렌드 검색어 조회이력 Mapper 인터페이스</p>
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
@Mapper
public interface TrendHstGdsMapper {
	
	/**
	 * <p>트렌드 검색어 조회의 이력을 저장한다.</p>
	 * 
	 * @param vo 사용자의 조회이력 정보가 담긴 TrendInqGdsHstVO객체.
	 */
	void insertInqGdsHst(TrendInqGdsHstVO vo);
	
}
