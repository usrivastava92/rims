package com.app.controllers;

import java.util.HashMap;

import javax.inject.Inject;
import javax.inject.Named;

import com.app.hibernate.entity.masters.ProductPo;
import com.app.hibernate.service.BaseService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Inject
	@Named("baseServiceImpl")
	private BaseService baseServiceImpl;

	@GetMapping()
	public ModelAndView getAllUsers(ModelAndView modelAndView) {
		System.out.println("PRODUCTS CONTROLLER : fetching all products ");
		modelAndView.addObject("products", baseServiceImpl.getEntityList(ProductPo.class, new HashMap<>()));
		modelAndView.setViewName("products");
		return modelAndView;
	}

	@GetMapping("/get/{id}")
	public ModelAndView getUser(ModelAndView modelAndView, @PathVariable Long id) {
		System.out.println("PRODUCTS CONTROLLER : fetching product with id -> " + id);
		modelAndView.addObject("product", baseServiceImpl.getEntityById(ProductPo.class, id));
		modelAndView.setViewName("product");
		return modelAndView;
	}

}
