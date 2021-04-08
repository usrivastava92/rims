package com.rims.controllers;

import java.util.HashMap;

import javax.inject.Inject;
import javax.inject.Named;

import com.rims.hibernate.entity.masters.RolePo;
import com.rims.hibernate.entity.masters.UserPo;
import com.rims.hibernate.service.BaseService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/inventory")
public class InventoryController {

	@Inject
	@Named("baseServiceImpl")
	private BaseService baseServiceImpl;

	@GetMapping()
	public ModelAndView getAllUsers(ModelAndView modelAndView) {
		System.out.println("INVENTORY CONTROLLER : fetching all inventories ");
		modelAndView.addObject("inventory", baseServiceImpl.getEntityList(UserPo.class, new HashMap<>()));
		modelAndView.setViewName("inventory");
		return modelAndView;
	}

	@GetMapping("/get/{id}")
	public ModelAndView getUser(ModelAndView modelAndView, @PathVariable Long id) {
		System.out.println("INVENTORY CONTROLLER : fetching inventory with id -> " + id);
		modelAndView.addObject("inventory", baseServiceImpl.getEntityById(RolePo.class, id));
		modelAndView.setViewName("inventory");
		return modelAndView;
	}

}
