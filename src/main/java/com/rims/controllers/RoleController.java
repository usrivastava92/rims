package com.rims.controllers;

import java.util.HashMap;

import javax.inject.Inject;
import javax.inject.Named;

import com.rims.hibernate.entity.masters.RolePo;
import com.rims.hibernate.service.BaseService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/roles")
public class RoleController {

	@Inject
	@Named("baseServiceImpl")
	private BaseService baseServiceImpl;

	@GetMapping()
	public ModelAndView getAllRoles(ModelAndView modelAndView) {
		System.out.println("ROLE CONTROLLER : fetching all roles ");
		modelAndView.addObject("roles", baseServiceImpl.getEntityList(RolePo.class, new HashMap<>()));
		modelAndView.setViewName("masters/roles/roles");
		return modelAndView;
	}

	@GetMapping("/get/{id}")
	public ModelAndView getRole(ModelAndView modelAndView, @PathVariable Long id) {
		System.out.println("ROLE CONTROLLER : fetching user with id -> " + id);
		modelAndView.addObject("role", baseServiceImpl.getEntityById(RolePo.class, id));
		modelAndView.setViewName("masters/roles/role");
		return modelAndView;
	}

}
