package edu.mum.asd.project.application.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController extends BaseController {
	private static final long serialVersionUID = 37368484966272651L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		HttpSession session = request.getSession(false);
		if(session != null)
		    session.invalidate();
		response.sendRedirect(request.getContextPath());
	}
}
