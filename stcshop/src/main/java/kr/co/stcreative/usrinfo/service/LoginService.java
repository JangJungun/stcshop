package kr.co.stcreative.usrinfo.service;

/**
 * <p>로그인 서비스 인터페이스</p>
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
public interface LoginService {

	/**
	 * <p>DB에 신규회원 정보를 삽입한다.</p>
	 * 
	 * @param vo 신규회원 정보가 담긴 UsrInfoVO객체
	 */
	void insertUser(UsrInfoVO vo);
	
	/**
	 * <p>회원가입시 사용자가 입력한 ID가 중복된 ID인지 검사한다.</p>
	 * 
	 * @param lgnAcntId 사용자가 입력한 ID의 문자열
	 * @return ID의 중복 여부를 반환
	 */
	boolean isUserIdExist(String lgnAcntId);
	
	/**
	 * <p>로그인시도시 사용자가 입력한 아이디,비밀번호가 유효한지 확인한다.</p>
	 * 
	 * @param user 사용자가 입력한 정보가 담긴 UsrInfoVO 객체
	 * @return 유효한 아이디, 비밀번호인지에 대한 여부를 반환
	 */
	boolean login(UsrInfoVO user);
	
}
