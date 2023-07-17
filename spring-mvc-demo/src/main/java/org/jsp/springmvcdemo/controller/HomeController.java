package org.jsp.springmvcdemo.controller;

import org.jsp.springmvcdemo.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController 
{
	@RequestMapping("/open-home")
	public String OpenHome(Model model)
	{
		model.addAttribute("username","yatish singhal");
		return"home.jsp";
	}

	@RequestMapping(value="/findsum")
 public ModelAndView findsum(@RequestParam(name="n1") int n1 , @RequestParam(name="n2") int n2)
 {
	 String result = "the sum is :"+(n1 + n2);
	 ModelAndView view = new ModelAndView();
	 view.addObject("result" , result);
	 view.setViewName("print.jsp");
	 
	return view;
	 
 }
	
	@RequestMapping(value="/finddiff")
	 public ModelAndView finddiff(@RequestParam(name="n1") int n1 , @RequestParam(name="n2") int n2)
	 {
		 String result = "the difference is :"+(n1 - n2);
		 ModelAndView view = new ModelAndView();
		 view.addObject("result" , result);
		 view.setViewName("print.jsp");
		 
		return view;
		 
	 }

	@RequestMapping(value="/findprod")
	 public ModelAndView findprod(@RequestParam(name="n1") int n1 , @RequestParam(name="n2") int n2)
	 {
		 String result = "the product is :"+(n1 * n2);
		 ModelAndView view = new ModelAndView();
		 view.addObject("result" , result);
		 view.setViewName("print.jsp");
		 
		return view;
		 
	 }

	@RequestMapping(value="/finddiv")
	 public ModelAndView finddiv(@RequestParam(name="n1") int n1 , @RequestParam(name="n2") int n2)
	 {
		 String result = "the divison is :"+(n1 / n2);
		 ModelAndView view = new ModelAndView();
		 view.addObject("result" , result);
		 view.setViewName("print.jsp");
		 
		return view;
		 
	 }
	@RequestMapping(value ="/print")
	public ModelAndView printDetails(@ModelAttribute User u )
	{
		System.out.println("name :"+ u.getName() );
		System.out.println("phone :"+ u.getPhone());
		System.out.println("Email :"+ u.getEmail());
		System.out.println("age :" + u.getAge());
		System.out.println("password :" + u.getPassword());
	ModelAndView view = new ModelAndView();
	view.setViewName("print.jsp");;
	view.addObject("result", "the details are printed");
	return view;
	}

}