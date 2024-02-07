package kr.co.stcreative.usrinfo.web;

import java.util.List;
import java.util.concurrent.Future;

import javax.servlet.http.HttpSession;

import org.egovframe.rte.fdl.cmmn.exception.FdlException;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.stcreative.trend.main.service.CrawlingData;
import kr.co.stcreative.trend.main.service.CrawlingService;
import kr.co.stcreative.usrinfo.service.LoginService;
import kr.co.stcreative.usrinfo.service.UsrInfoVO;

/**
 * <p>회원가입 ,로그인, 로그아웃 컨트롤러.</p>
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
@Controller
public class LoginController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private LoginService loginService;
	
	private CrawlingService crawlingService;
	
	private EgovIdGnrService objectIdGnrService;
	
	@Autowired
	public LoginController(LoginService loginService
						  ,CrawlingService crawlingService
						  ,@Qualifier("egovUsrIdGnrService") EgovIdGnrService objectIdGnrService) {
		this.loginService=loginService;
		this.crawlingService=crawlingService;
		this.objectIdGnrService=objectIdGnrService;
	}
	
	/**
	 * <p>로그인 페이지로 이동힌디.</p>
	 * 
	 * @param session 주간 인기검색어 TOP100을 세션에 저장해두기 위한 HttpSession 객체
	 * @return 로그인 페이지의 view 이름을 문자열로 반환한다.
	 */
	@GetMapping("/mainPage.do")
	public String goMainPage(HttpSession session) {
		Future<List<CrawlingData>> future = crawlingService.getPopularKeywords();
        session.setAttribute("future", future);
		
		return "login";
	}
	/**
	 * <p>회원가입 기능을 수행한다.</p>
	 * 
	 * @param vo 회원이 입력한 정보를 담은 UsrInfoVO 객체.
	 * @param model 회원가입시 발생하는 예외메세지를 담기위한 Model 객체.
	 * @return 로그인 페이지
	 */
	@PostMapping("/usrinfo/join.do")
	public String joinmember(UsrInfoVO vo, Model model, RedirectAttributes redirectAttributes) {
		logger.info("Join User ID: " + vo.getLgnAcntId());
		
		// 중복 ID 체크
	    if(loginService.isUserIdExist(vo.getLgnAcntId())) {
	    	redirectAttributes.addFlashAttribute("joinErrorMessage", "아이디가 중복되었습니다. 다른 아이디를 입력해주세요.");
	        logger.info("User ID 중복 : " + vo.getLgnAcntId());
	        return "redirect:/mainPage.do";
	    }
		
	    try {
			vo.setUsrId(objectIdGnrService.getNextStringId());
		} catch (FdlException e) {
			e.printStackTrace();
		}
	    vo.setGrpId("GROUP_00000000000002");//일반회원 권한 그룹
	    
	    
	    // db에 회원정보 저장
	    loginService.insertUser(vo);
	    
	    logger.info("Join success.");
	    
		return "redirect:/mainPage.do";
	}
	
	/**
	 * <p>로그인 기능을 수행하고 로그인 성공시에 안내페이지로 이동, 실패시에 로그인페이지로 이동한다.</p>
	 * 
	 * @param user 사용자가 입력한 정보를 담는 UsrInfoVO 객체.
	 * @param model 로그인시 성공 또는 실패 메시지를 담는 Model 객체.
	 * @param session 로그인 성공시 회원정보를 세션에 담기위한 HttpSession 객체.
	 * @return 로그인 성공시에 이용안내페이지로 이동, 실패시에 로그인페이지로 이동
	 */
	@PostMapping("/usrinfo/login.do")
	public String trylogin(UsrInfoVO user, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		logger.info("Login User ID: " + user.getLgnAcntId());
		
		
		if(loginService.login(user)) { 
            session.setAttribute("user", user); 
            //user.setUserLogin(true);
            logger.info("Login success User ID: " + user.getLgnAcntId());
			
            return "redirect:/main/info.do";
        } else {
            redirectAttributes.addFlashAttribute("loginErrorMessage", "로그인에 실패했습니다. 아이디 또는 비밀번호를 확인해주세요."); 
            logger.info("Login failed User ID: " + user.getLgnAcntId());
            return "redirect:/mainPage.do"; 
        }
		
		
	}
	
	/**
	 * <p>로그아웃 기능을 수행한다.</p>
	 * 
	 * @param session 세션에 저장되어있는 회원정보를 무효화 하기위한 HttpSession 객체
	 * @return 로그인페이지로 리다이렉트한다.
	 */
	@GetMapping("/logout.do")
	public String logout(HttpSession session) {
	    session.invalidate();
	    return "redirect:/mainPage.do";
	}
}
