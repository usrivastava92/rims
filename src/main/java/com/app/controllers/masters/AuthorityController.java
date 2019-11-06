package com.app.controllers.masters;

import java.util.HashMap;

import javax.inject.Inject;
import javax.inject.Named;

import com.app.hibernate.entity.masters.AuthorityPo;
import com.app.hibernate.service.BaseService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/authorities")
public class AuthorityController {

	@Inject
	@Named("baseServiceImpl")
	private BaseService baseServiceImpl;

	@GetMapping()
	public ModelAndView getAllAuthorities(ModelAndView modelAndView) {
		System.out.println("AUTHORITY CONTROLLER : fetching all roles ");
		modelAndView.addObject("authorities", baseServiceImpl.getEntityList(AuthorityPo.class, new HashMap<>()));
		modelAndView.setViewName("masters/authorities/authorities");
		return modelAndView;
	}

	@GetMapping("/get/{id}")
	public ModelAndView getAllAuthority(ModelAndView modelAndView, @PathVariable Long id) {
		System.out.println("AUTHORITY CONTROLLER : fetching user with id -> " + id);
		modelAndView.addObject("authority", baseServiceImpl.getEntityById(AuthorityPo.class, id));
		modelAndView.setViewName("masters/authorities/authority");
		return modelAndView;
	}

}
