package kr.co.stcreative.cmm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import kr.co.stcreative.usrinfo.service.UsrInfoVO;

/**
 * <p>관리자 권한을 검증 인터셉터.</p>
 * 
 * <p>{@code preHandle} 메소드를 통해 요청이 처리되기 전에 세션에 저장된 사용자의 그룹 ID를 확인한다. 
 * 사용자가 관리자 권한이 아니라면, 접근 거부 페이지로 리다이렉트한다.</p>
 */
public class RoleCheckInterceptor implements HandlerInterceptor {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		UsrInfoVO sessionVO = (UsrInfoVO) session.getAttribute("user");
		logger.info("GrpId :"+sessionVO.getGrpId());
		if (!sessionVO.getGrpId().equals("GROUP_00000000000001")) {//관리자 권한이 아니라면
			response.sendRedirect("/authDenied.do"); //접근거부 페이지로 이동
			return false;
		}
		return true;
	}
}
