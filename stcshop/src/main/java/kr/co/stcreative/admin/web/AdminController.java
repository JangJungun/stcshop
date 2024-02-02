package kr.co.stcreative.admin.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.stcreative.admin.service.AdminService;
import kr.co.stcreative.trend.hst.service.TrendInqHstVO;
import kr.co.stcreative.usrinfo.service.UsrInfoVO;

/**
 * <p>관리자 페이지 메인 컨트롤러.</p>
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
public class AdminController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private AdminService adminService;
	
	@Autowired
	public AdminController(AdminService adminService) {
		this.adminService=adminService;
	}
	
	/**
	 * <p>관리자 페이지로 이동한다.</p>
	 * 
	 * @param model 페이지로 이동할 때 헤더 메뉴바의 active 효과를 위한 Model객체
	 * @return 관리자 페이지의 view 이름을 문자열로 반환.
	 */
	@GetMapping("/admin.do")
	public String goAdminPage(Model model) {
		
		model.addAttribute("currentMenu","admin");
		
		List<UsrInfoVO> userLst = adminService.getUserLst();
		
		model.addAttribute("usrLst",userLst);
		
		return "admin/AdminPage";
	}
	
	/**
	 * <p>특정 회원의 이용내역을 조회한다.</p>
	 * 
	 * @param usrId 조회하고자 하는 사용자의 ID값
	 * @param lgnAcntId 조회하고자 하는 사용자의 계정 ID
	 * @param model 이용내역을 저장하기 위한 Model 객체
	 * @return 이용내역 조회 페이지의 view 이름을 문자열로 반환.
	 */
	@PostMapping("/getUserHst.do")
	public String getUserHst(@RequestParam("usrId") String usrId
						   , @RequestParam("lgnAcntId")String lgnAcntId, Model model) {
		
		List<TrendInqHstVO> userHst = adminService.getUserHst(usrId);
		
		model.addAttribute("usrHst",userHst);
		model.addAttribute("usrLgnAcntId",lgnAcntId);
		return "admin/AdminUsrHst";
	}
	
}
