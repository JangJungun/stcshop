package kr.co.stcreative.usrinfo.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.stcreative.usrinfo.mapper.LoginMapper;
import kr.co.stcreative.usrinfo.service.LoginService;
import kr.co.stcreative.usrinfo.service.UsrInfoVO;

/**
 * <p>로그인 서비스 인터페이스의 구현체</p>
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
@Service("LoginService")
public class LoginServiceImpl implements LoginService{
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private LoginMapper loginMapper;
	
	@Autowired
	public LoginServiceImpl(LoginMapper loginMapper) {
		this.loginMapper=loginMapper;	
	}
	
	/**
	 * {@inheritDoc}
	 * <p>비밀번호 암호화를 위한 salt값을 생성한 후 vo객체에 담고 DB에 저장한다.</p>
	 */
	@Override
	public void insertUser(UsrInfoVO vo) {
		String salt = generateSalt();
		vo.setLgnAcntPswd(hashPassword(vo.getLgnAcntPswd(), salt));
		vo.setSalt(salt);
		logger.info("salt value:"+salt);
		loginMapper.insertUser(vo);
	}

	/**
	 * {@inheritDoc}
	 * <p>ID 중복여부를 DB에서 조회하여 중복여부를 반환한다.</p>
	 */
	@Override
	public boolean isUserIdExist(String lgnAcntId) {
		return loginMapper.getUser(lgnAcntId) != null;
	}
	
	/**
	 * <p>비밀번호 암호화를 위한 salt값을 생성한다</p>
	 * 
	 * @return Base64로 인코딩된 salt값의 문자열을 반환한다.
	 */
	public String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);  // salt는 Base64로 인코딩
    }
	
	/**
	 * <p>입력받은 비밀번호를 salt를 이용하여 SHA-256방식으로 암호화한다.</p>
	 * 
	 * @param password 암호화할 비밀번호의 문자열
	 * @param salt 비밀번호에 추가할 솔트
	 * @return SHA-256 방식으로 암호화된 16진수 형태의 문자열
	 * @throws RuntimeException 암호화 과정에서 오류가 발생했을 경우 발생
	 */
	public String hashPassword(String password, String salt) {
        try {
            String saltedPassword = password + salt;
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(saltedPassword.getBytes());

            // 16진수로 변환
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            
            return hexString.toString();  // 16진수로 반환
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("암호화 도중 오류가 발생했습니다.", e);
        }
    }
	

	/**
	 * {@inheritDoc}
	 * 
	 * @param user 사용자의 아이디와 비밀번호 정보를 담은 UsrInfoVO 객체.
	 * @return 로그인 성공 여부. 아이디와 비밀번호가 일치하면 true, 그렇지 않으면 false를 반환.
	 * @see #hashPassword(String, String) 비밀번호 암호화 메서드
	 */
	@Override
	public boolean login(UsrInfoVO user) {
		UsrInfoVO userFromDB = loginMapper.getUser(user.getLgnAcntId());
	    if (userFromDB != null && hashPassword(user.getLgnAcntPswd(), userFromDB.getSalt()).equals(userFromDB.getLgnAcntPswd())) {
	    	// 암호화 처리된 값 set
	    	user.setLgnAcntPswd(userFromDB.getLgnAcntPswd());
	        //session.setAttribute("user", user); 에 저장할 값
	        user.setGrpId(userFromDB.getGrpId());
	        user.setNickNm(userFromDB.getNickNm());
	        user.setUsrId(userFromDB.getUsrId());
	        return true;
	    } else {
	        return false;
	    }
	}	
}
