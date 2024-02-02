package kr.co.stcreative.trend.main.mapper;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import kr.co.stcreative.trend.main.service.CrawlingData;

/**
 * <p>크롤링 Mapper 인터페이스</p>
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
@Deprecated
public interface CrawlingDataMapper {
	
	/**
	 * 주간 인기검색어 TOP100의 정보를 DB에 저장한다.
	 * 
	 * @param data 주간 인기검색어 TOP100 정보를 담은 CrawlingData타입의 객체
	 */
	void insertCrawlingData(CrawlingData data);
	
}
