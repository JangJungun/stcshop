package kr.co.stcreative.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.stcreative.admin.mapper.AdminMapper;
import kr.co.stcreative.admin.service.AdminService;
import kr.co.stcreative.trend.hst.service.TrendInqHstVO;
import kr.co.stcreative.usrinfo.service.UsrInfoVO;

/**
 * <p>관리자 페이지 서비스 인터페이스의 구현체</p>
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
public class AdminServiceImpl implements AdminService{

	private AdminMapper adminMapper;
	
	@Autowired
	public AdminServiceImpl(AdminMapper adminMapper) {
		this.adminMapper=adminMapper;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UsrInfoVO> getUserLst() {
		List<UsrInfoVO> userLst = adminMapper.getUserLst();
		return userLst;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<TrendInqHstVO> getUserHst(String usrId) {
		List<TrendInqHstVO> userHst = adminMapper.getUserHst(usrId);
		return userHst;
	}

}
