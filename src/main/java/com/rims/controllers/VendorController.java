package com.rims.controllers;

import java.util.HashMap;

import javax.inject.Inject;
import javax.inject.Named;

import com.rims.hibernate.entity.masters.VendorPo;
import com.rims.hibernate.service.BaseService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/vendors")
public class VendorController {

	@Inject
	@Named("baseServiceImpl")
	private BaseService baseServiceImpl;

	@GetMapping()
	public ModelAndView getAllVendors(ModelAndView modelAndView) {
		System.out.println("VENDORS CONTROLLER : fetching all vendors ");
		modelAndView.addObject("vendors", baseServiceImpl.getEntityList(VendorPo.class, new HashMap<>()));
		modelAndView.setViewName("masters/vendors/vendors");
		return modelAndView;
	}

	@GetMapping("/get/{id}")
	public ModelAndView getUser(ModelAndView modelAndView, @PathVariable Long id) {
		System.out.println("VENDORS CONTROLLER : fetching vendor with id -> " + id);
		modelAndView.addObject("vendor", baseServiceImpl.getEntityById(VendorPo.class, id));
		modelAndView.setViewName("masters/vendors/vendor");
		return modelAndView;
	}

}
