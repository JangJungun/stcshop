package kr.co.stcreative.trend.main.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import kr.co.stcreative.trend.main.service.TrendCatVO;

/**
 * <p>트렌드 카테고리 Mapper 인터페이스</p>
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
@Mapper("TrendCatMapper")
public interface TrendCatMapper {

	/**
     * <p>대분류값의 List를 데이터베이스에서 조회한다.</p>
     *
     * @return 대분류값의 List를 반환한다.
     */
	List<TrendCatVO> selectOptionsOne();
	
	/**
     * <p>중분류값의 List를 데이터베이스에서 조회한다.</p>
     *
     * @param vo 사용자가 선택한 대분류값의 정보를 담은 TrendCatVO 객체.
     * @return 중분류값의 List를 반환한다.
     */
	List<TrendCatVO> selectOptionsTwo(TrendCatVO vo);
	
	/**
     * <p>소분류값의 List를 데이터베이스에서 조회한다.</p>
     *
     * @param vo 사용자가 선택한 중분류값의 정보를 담은 TrendCatVO 객체.
     * @return 소분류값의 List를 반환한다.
     */
	List<TrendCatVO> selectOptionsThr(TrendCatVO vo);
	
	/**
     * <p>주어진 분류명 해당하는 분류코드값을 데이터베이스에서 조회한다.</p>
     *
     * @param category 분류명을 담은 문자열.
     * @return 분류코드값을 문자열 형태로 반환한다.
     */
	String getCategoryParam(@Param("category") String category);
	
}
