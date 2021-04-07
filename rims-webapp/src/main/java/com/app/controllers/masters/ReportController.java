package com.app.controllers.masters;

import java.util.HashMap;
import com.app.logging.BaseLoggers;
import javax.inject.Inject;
import javax.inject.Named;

import com.app.hibernate.entity.masters.ReportPo;
import com.app.hibernate.service.BaseService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/reports")
public class ReportController {

	@Inject
	@Named("baseServiceImpl")
	private BaseService baseServiceImpl;

	@GetMapping()
	public ModelAndView getAllReports(ModelAndView modelAndView) {
		BaseLoggers.flowLogger.info("REPORT CONTROLLER : fetching all reports ");
		modelAndView.addObject("reports", baseServiceImpl.getEntityList(ReportPo.class, new HashMap<>()));
		modelAndView.setViewName("masters/reports/reports");
		return modelAndView;
	}

	@GetMapping("/get/{id}")
	public ModelAndView generateReport(ModelAndView modelAndView, @PathVariable Long id) {
		BaseLoggers.flowLogger.info("REPORT CONTROLLER : fetching report with id -> " + id);
		modelAndView.addObject("authority", baseServiceImpl.getEntityById(ReportPo.class, id));
		modelAndView.setViewName("masters/reports/report");
		return modelAndView;
	}

}
