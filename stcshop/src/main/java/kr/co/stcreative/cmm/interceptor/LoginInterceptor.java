package kr.co.stcreative.cmm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

/**
 * <p>로그인 상태 검증 인터셉터</p>
 * <p>사용자가 로그인하지 않았다면, 세션에 "expired" 속성을 추가하고 로그인 페이지로 리다이렉트한다.</p>
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
public class LoginInterceptor implements HandlerInterceptor {

	/**
     * <p>로그인 요청을 제외한 모든 요청이 컨트롤러에 도달하기 전에 호출되는 메소드</p>
     * 
     * @param request 사용자의 요청 정보를 담고 있는 HttpServletRequest 객체.
     * @param response 서버의 응답 정보를 담고 있는 HttpServletResponse 객체.
     * @param handler 요청을 처리할 핸들러 객체.
     * 
     * @return 사용자가 로그인 상태라면 true, 아니면 false를 반환.
     * @throws Exception 세션 정보의 조회 또는 리다이렉트 시에 발생할 수 있는 예외를 전달.
     */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {  // 세션에 "user"라는 이름의 속성이 없다면
        	session.setAttribute("expired", "true"); // 세션이 만료되었다는 메세지
            response.sendRedirect("/mainPage.do");  // 로그인 페이지로 리다이렉트
            return false;  
        }
        return true;  
	}

	
}
