package com.app.controllers;

import java.util.HashMap;

import javax.inject.Inject;
import javax.inject.Named;

import com.app.hibernate.entity.RolePo;
import com.app.hibernate.service.BaseService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/genericattributes")
public class GenericAttributeController {

	@Inject
	@Named("baseServiceImpl")
	private BaseService baseServiceImpl;

	@GetMapping()
	public ModelAndView getAllUsers(ModelAndView modelAndView) {
		System.out.println("GENERIC ATTRIBUTE CONTROLLER : fetching all generic attributes ");
		modelAndView.addObject("genericAttributes", baseServiceImpl.getEntityList(RolePo.class, new HashMap<>()));
		modelAndView.setViewName("genericAttributes");
		return modelAndView;
	}

	@GetMapping("/get/{id}")
	public ModelAndView getUser(ModelAndView modelAndView, @PathVariable Long id) {
		System.out.println("GENERIC ATTRIBUTE CONTROLLER : fetching generic attribute with id -> " + id);
		modelAndView.addObject("genericAttribute", baseServiceImpl.getEntityById(RolePo.class, id));
		modelAndView.setViewName("genericAttribute");
		return modelAndView;
	}

}
