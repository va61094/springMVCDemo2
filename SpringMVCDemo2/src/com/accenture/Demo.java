package com.accenture;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.pojo.User;
@Controller
public class Demo {

	@RequestMapping("/login.do")
	public ModelAndView display(ModelMap m){
		User u=new User();
		m.addAttribute("key", u);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("form");
		return mv;
		
	}
	@RequestMapping("/validate.do")
	public ModelAndView sample(@ModelAttribute("key")User u){
		ModelAndView mv= new ModelAndView();
		String name=u.getUname();
		String pwd= u.getPassword();
		if(name.equals("vai") && pwd.equals("hola"))
			mv.setViewName("success");
		else
			mv.setViewName("fail");
		return mv;
	}
}
