package kr.co.stcreative.usrinfo.service;

/**
 * <p>회원정보 관리 서비스 인터페이스</p>
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
public interface UsrInfoService {

	/**
	 * <p>회원정보 조회/수정을 위해 DB에서 회원정보를 가져온다.</p>
	 * 
	 * @param id 정보를 조회하고자 하는 사용자의 id값
	 * @return 조회한 회원의 정보가 담긴 UsrInfoVO 객체
	 */
	UsrInfoVO getUserByUsrId(String id);
	
	/**
	 * <p>회원정보 수정의 성공/실패 여부를 반환한다.</p>
	 * 
	 * @param usrInfoVO 회원의 수정정보가 담긴 UsrInfoVO객체.
	 * @return 정보수정 성공/실패 여부를 반환.
	 */
	boolean modifyUsrInfo(UsrInfoVO usrInfoVO);
	
}
