package com.lcvc.ebuy_maven_ssm.web;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/hello")
public class HelloServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//HttpSession session=req.getSession();
		//session.setAttribute("name", "张三");
		//resp.sendRedirect("hello.jsp");
		
		req.setAttribute("name", "李四");
		req.getRequestDispatcher("hello.jsp").forward(req, resp);
	}
}
