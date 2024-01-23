package kr.co.stcreative.admin.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AdminController {

	@GetMapping("/admin.do")
	public String goAdminPage(Model model) {
		
		model.addAttribute("currentMenu","admin");
		
		return "/admin/AdminPage";
	}
	
}
