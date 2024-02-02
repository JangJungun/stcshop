package kr.co.stcreative.admin.service;

import java.util.List;

import kr.co.stcreative.trend.hst.service.TrendInqHstVO;
import kr.co.stcreative.usrinfo.service.UsrInfoVO;

/**
 * <p>관리자 페이지 서비스 인터페이스</p>
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
public interface AdminService {
	
	/**
	 * <p>DB에 저장되어 있는 회원정보의 List를 가져온다.</p>
	 * 
	 * @return 회원정보의 List
	 */
	List<UsrInfoVO> getUserLst();
	
	/**
	 * <p>DB에 저장되어 있는 회원의 이용내역 List를 가져온다.</p>
	 * 
	 * @param usrId 조회하고자 하는 회원의 ID
	 * @return 회원 이용내역의 List
	 */
	List<TrendInqHstVO> getUserHst(String usrId);
}
