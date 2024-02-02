package kr.co.stcreative.usrinfo.mapper;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import kr.co.stcreative.usrinfo.service.UsrInfoVO;

/**
 * <p>로그인 Mapper 인터페이스</p>
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
@Mapper("LoginMapper")
public interface LoginMapper {
	
	/**
	 * <p>DB에 신규회원 정보를 삽입한다.</p>
	 * 
	 * @param vo 신규회원 정보가 담긴 UsrInfoVO객체
	 */
	void insertUser(UsrInfoVO vo);
	
	/**
	 * <p>회원 계정아이디로 회원정보를 조회한다.</p>
	 * 
	 * @param userId 회원 계정아이디의 문자열 값
	 * @return 회원정보가 담긴 UsrInfoVO 객체
	 */
	UsrInfoVO getUser(String userId);
	
}
