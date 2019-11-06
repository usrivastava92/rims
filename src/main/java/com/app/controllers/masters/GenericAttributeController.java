package com.app.controllers.masters;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.app.hibernate.entity.masters.GenericAttributePo;
import com.app.hibernate.service.BaseService;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/genericattributes")
public class GenericAttributeController {

	@Inject
	@Named("baseServiceImpl")
	private BaseService baseServiceImpl;

	@GetMapping()
	public ModelAndView toGenericAttributes(ModelAndView modelAndView) {
		modelAndView.setViewName("masters/generic-attributes/genericAttributes");
		return modelAndView;
	}

	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<GenericAttributePo> getAllGenericAttributes() {
		System.out.println("GENERIC ATTRIBUTE CONTROLLER : fetching all generic attributes ");
		return baseServiceImpl.getEntityList(GenericAttributePo.class, new HashMap<>());
	}

	@GetMapping("/get/{id}")
	public ModelAndView getUser(ModelAndView modelAndView, @PathVariable Long id) {
		System.out.println("GENERIC ATTRIBUTE CONTROLLER : fetching generic attribute with id -> " + id);
		modelAndView.addObject("genericAttribute", baseServiceImpl.getEntityById(GenericAttributePo.class, id));
		modelAndView.setViewName("masters/generic-attributes/genericAttribute");
		return modelAndView;
	}

}
