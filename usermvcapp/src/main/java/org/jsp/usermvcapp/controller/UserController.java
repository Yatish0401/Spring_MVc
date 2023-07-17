package org.jsp.usermvcapp.controller;

import org.jsp.usermvcapp.dao.UserDao;
import org.jsp.usermvcapp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    
	@Autowired
	private UserDao dao;
	
	@RequestMapping("/open")
	public String openView(String view)
	{
		return view;
	}
	
	@PostMapping(value ="/register")
	public ModelAndView saveUser(@ModelAttribute User u , ModelAndView view)
	{
		u = dao.saveUser(u);
		view.addObject("msg", "user saved with id:" + u.getId());
		view.setViewName("print");
		return view;
		
	}
	
	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam int id , ModelAndView view)
	{
		User u = dao.findUserById(id);
		if(u!= null) {
			view.addObject("u", u);
			view.setViewName("update");
			return view;
		}
		else {
			view.addObject("msg", "the id is invalid");
			view.setViewName("print");
			return view;
		}
	}
	
	@RequestMapping(value ="/update")
	public ModelAndView updateUser(@ModelAttribute User u , ModelAndView view) {
		dao.updateUser(u);
		view.addObject("msg", "user updated");
		view.setViewName("print");
		return view;
	}
	
	@RequestMapping("/verify-phone")
	public ModelAndView verifyUser(@RequestParam long phone, @RequestParam String password,ModelAndView view)
	{
		User u = dao.verifyByUser(phone, password);
		if(u!= null)
		{
			view.addObject("u" , u);
			view.setViewName("view");
			return view;
			
		}
		else
		{
			view.addObject("msg","invalid phone Number or password");
			view.setViewName("print");
			return view;
		}
	}
	@RequestMapping("/verify-email")
	public ModelAndView verifyUser(@RequestParam String email, @RequestParam String password,ModelAndView view)
	{
		User u = dao.verifyByUser(email, password);
		if(u!= null)
		{
			view.addObject("u" , u);
			view.setViewName("view");
			return view;
			
		}
		else
		{
			view.addObject("msg","invalid email id or password");
			view.setViewName("print");
			return view;
		}
	}
	@RequestMapping("/verify-age")
	public ModelAndView verifyUser(@RequestParam int age, @RequestParam String password,ModelAndView view)
	{
		User u = dao.verifyByUser(age, password);
		if(u!= null)
		{
			view.addObject("u" , u);
			view.setViewName("view");
			return view;
			
		}
		else
		{
			view.addObject("msg","invalid age or password");
			view.setViewName("print");
			return view;
		}
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteUser(@RequestParam int id, ModelAndView view) {
		boolean deleted = dao.deleteUser(id);
		view.setViewName("print");
		if (deleted) {
			view.addObject("msg", "user deleted");
			return view;
		} else {
			view.addObject("msg", "Cannot delete User as the id is invalid");
			return view;
		}
	}
	

}
