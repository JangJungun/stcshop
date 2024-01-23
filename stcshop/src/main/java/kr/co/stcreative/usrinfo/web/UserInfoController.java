package kr.co.stcreative.usrinfo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UserInfoController {
	
	//header 메뉴 active효과를 위한 경로정보를 model에 저장
	@ModelAttribute("currentMenu")
    public String currentMenu() {
        return "usrinfo";
    }
	
	
	@GetMapping("/usrinfo.do")
	public String goInfoPage() {
		

		
		return "usrinfo/UserInfo";
	}
	
	@GetMapping("/usrhistory.do")
	public String goHisPage() {
		
		
		return "usrinfo/UserHistory";
	}
	
}
