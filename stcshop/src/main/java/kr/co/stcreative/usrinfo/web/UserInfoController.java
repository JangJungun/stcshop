package kr.co.stcreative.usrinfo.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.stcreative.trend.hst.service.TrendHstService;
import kr.co.stcreative.trend.hst.service.TrendInqHstVO;
import kr.co.stcreative.usrinfo.service.UsrInfoService;
import kr.co.stcreative.usrinfo.service.UsrInfoVO;

/**
 * <p>회원정보 및 이력관련 컨트롤러.</p>
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
public class UserInfoController {
	
	private UsrInfoService usrInfoService;
	private TrendHstService trendHstService;
	
	@Autowired
	public UserInfoController(UsrInfoService usrInfoService
							 ,TrendHstService trendHstService) {
		this.usrInfoService=usrInfoService;
		this.trendHstService=trendHstService;
	}
	
	//header 메뉴 active효과를 위한 경로정보를 model에 저장
	@ModelAttribute("currentMenu")
    public String currentMenu() {
        return "usrinfo";
    }
	
	/**
	 * <p>회원정보 수정 페이지로 이동한다.</p>
	 * 
	 * @param session 회원 정보를 조회하기 위해 세션에 있는 로그인된 사용자의 정보를 가져오기 위한 HttpSession 객체.
	 * @param model DB에서 조회된 회원정보를 담기위한 Model 객체.
	 * 
	 * @return 회원정보 조회 및 수정 페이지의 view 이름을 문자열로 반환한다.
	 */
	@GetMapping("/usrinfo.do")
	public String goInfoPage(HttpSession session, Model model) {
		
		UsrInfoVO userSession = (UsrInfoVO) session.getAttribute("user");
		
		UsrInfoVO userInfo = usrInfoService.getUserByUsrId(userSession.getUsrId());
		
		model.addAttribute("userInfo", userInfo);
		
		return "usrinfo/UserInfo";
	}
	
	/**
	 * <p>트렌드 통계조회 이력 페이지로 이동한다.</p>
	 * 
	 * @param session 이력조회를 위해 세션에 있는 로그인된 사용자의 정보를 가져오기 위한 HttpSession 객체
	 * @param model DB에서 조회된 회원의 이용이력정보를 담기위한 Model 객체
	 * @return 통계조회 이력페이지의 view이름을 문자열로 반환한다.
	 */
	@GetMapping("/usrhistory.do")
	public String goHisPage(HttpSession session, Model model) {
		
		UsrInfoVO userSession =(UsrInfoVO) session.getAttribute("user");
		String usrId = userSession.getUsrId();
		
		List<TrendInqHstVO> hstList = trendHstService.selectHstById(usrId);
		
		model.addAttribute("hstList", hstList);
		
		return "usrinfo/UserHistory";
	}
	
	/**
	 * <p>사용자 정보를 수정한다.</p>
	 * 
	 * @param usrInfoVO 수정할 사용자 정보를 담고 있는 UsrInfoVO 객체
	 * @param redirectAttributes 리다이렉트 시 성공/실패 메시지를 전달하는 객체
	 * @return 사용자 정보 페이지로 리다이렉트
	 */
	@PostMapping("/usrInfoModify.do")
	public String modify(UsrInfoVO usrInfoVO, RedirectAttributes redirectAttributes) {
		
		if(usrInfoService.modifyUsrInfo(usrInfoVO)) {
			//정보수정 성공,실패 메시지를 위해 페이지 redirect시 1회성으로 FlashAttribute에 저장
			redirectAttributes.addFlashAttribute("message", "정보가 수정되었습니다.");
		}else {
			redirectAttributes.addFlashAttribute("message", "정보수정에 실패하였습니다.");
		}
		
		return"redirect:/usrinfo.do";//회원정보페이지
		
	}
	
}
