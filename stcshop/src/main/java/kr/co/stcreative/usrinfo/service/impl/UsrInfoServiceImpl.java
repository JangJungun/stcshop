package kr.co.stcreative.usrinfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.stcreative.usrinfo.mapper.UsrInfoMapper;
import kr.co.stcreative.usrinfo.service.UsrInfoService;
import kr.co.stcreative.usrinfo.service.UsrInfoVO;

/**
 * <p>회원정보 관리 서비스 인터페이스의 구현체</p>
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
@Service
public class UsrInfoServiceImpl implements UsrInfoService {

	private UsrInfoMapper usrInfoMapper;
	
	@Autowired
	public UsrInfoServiceImpl(UsrInfoMapper usrInfoMapper) {
		this.usrInfoMapper=usrInfoMapper;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public UsrInfoVO getUserByUsrId(String id) {
		UsrInfoVO user = usrInfoMapper.getUserByUsrId(id);
		return user;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean modifyUsrInfo(UsrInfoVO usrInfoVO) {
		
		return usrInfoMapper.modifyUsrInfo(usrInfoVO) > 0;
	}

}
