package com.app.controllers.masters;

import java.util.HashMap;
import com.app.logging.BaseLoggers;
import javax.inject.Inject;
import javax.inject.Named;

import com.app.hibernate.entity.masters.RolePo;
import com.app.hibernate.entity.masters.UserPo;
import com.app.hibernate.service.BaseService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sales")
public class SalesController {

	@Inject
	@Named("baseServiceImpl")
	private BaseService baseServiceImpl;

	@GetMapping()
	public ModelAndView getAllSales(ModelAndView modelAndView) {
		BaseLoggers.flowLogger.info("SALES CONTROLLER : fetching all sales ");
		modelAndView.addObject("sales", baseServiceImpl.getEntityList(UserPo.class, new HashMap<>()));
		modelAndView.setViewName("sales");
		return modelAndView;
	}

	@GetMapping("/dashboard")
	public ModelAndView goToSalesDashboard(ModelAndView modelAndView) {
		BaseLoggers.flowLogger.info("SALES CONTROLLER : redirecting to sales dashboard");
		modelAndView.setViewName("sales-dashboard");
		return modelAndView;
	}

	@GetMapping("/get/{id}")
	public ModelAndView getSale(ModelAndView modelAndView, @PathVariable Long id) {
		BaseLoggers.flowLogger.info("SALES CONTROLLER : fetching with id -> " + id);
		modelAndView.addObject("sale", baseServiceImpl.getEntityById(RolePo.class, id));
		modelAndView.setViewName("sale");
		return modelAndView;
	}

}
