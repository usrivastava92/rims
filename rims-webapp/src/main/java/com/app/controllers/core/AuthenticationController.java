package com.app.controllers.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.app.logging.BaseLoggers;
import com.app.hibernate.entity.masters.UserPo;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping({ "/login" })
	@ResponseBody
	public boolean login(@RequestParam("username") String username, @RequestParam("password") String password) {
		BaseLoggers.flowLogger.info("Login attempt by : " + username);
		UserPo userPo = new UserPo();
		userPo.setUsername(username);
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				username, password);
		usernamePasswordAuthenticationToken.setDetails(userPo);
		try {
			Authentication auth = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
			SecurityContextHolder.getContext().setAuthentication(auth);
			return auth.isAuthenticated();
		} catch (BadCredentialsException e) {
			return false;
		}
	}

	@GetMapping("/logout")
	public ModelAndView logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("logout", "true");
		modelAndView.setViewName("redirect:/landing-page");
		return modelAndView;
	}

}
