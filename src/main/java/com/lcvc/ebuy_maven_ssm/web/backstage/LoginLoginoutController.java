package com.lcvc.ebuy_maven_ssm.web.backstage;import com.lcvc.ebuy_maven_ssm.dao.AdminDao;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;import javax.servlet.http.HttpServletRequest;@Controllerpublic class LoginLoginoutController {	AdminDao adminDao=new AdminDao();	@RequestMapping(value = "/backstage/login", method = RequestMethod.POST)	public String login(String username,String password) {		if(adminDao.login(username, password)){			return "/jsp/backstage/main.html";		}else{			return "/jsp/backstage/login.jsp";		}	}}