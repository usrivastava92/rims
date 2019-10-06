package com.app.controllers;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.app.hibernate.entity.UserPo;
import com.app.hibernate.service.BaseService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {

	@Inject
	@Named("baseServiceImpl")
	private BaseService baseServiceImpl;

	@GetMapping()
	public ModelAndView getAllUsers(ModelAndView modelAndView) {
		System.out.println("USER CONTROLLER : fetching all users ");
		modelAndView.addObject("users", baseServiceImpl.getEntityList(UserPo.class, new HashMap<>()));
		modelAndView.setViewName("users");
		return modelAndView;
	}

	@GetMapping("/get/{id}")
	public ModelAndView getUser(ModelAndView modelAndView, @PathVariable Long id) {
		System.out.println("USER CONTROLLER : fetching user with id -> " + id);
		modelAndView.addObject("user", baseServiceImpl.getEntityById(UserPo.class, id));
		modelAndView.setViewName("user");
		return modelAndView;
	}

}
