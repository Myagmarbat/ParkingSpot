package edu.mum.asd.project.application.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.mum.asd.project.application.dao.LoginDao;
import edu.mum.asd.project.application.model.Staff;
import edu.mum.asd.project.fw.rulesets.RuleException;
import edu.mum.asd.project.fw.rulesets.RuleSet;
import edu.mum.asd.project.fw.rulesets.RuleSetFactory;

public class LoginController extends BaseController {
	private static final long serialVersionUID = 37368484966272651L;
	private Staff staff;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/application/loginprocess.jsp");
		rd.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		try {
//			RuleSet rules = RuleSetFactory.getRuleSet(LoginController.this);
//			rules.applyRules(LoginController.this);
			staff = new Staff();
			staff.setStaffName(request.getParameter("un"));
			staff.setStaffPass(request.getParameter("pw"));
			staff = LoginDao.login(staff);
			HttpSession session = request.getSession(true);
			session.setAttribute("staff", staff);
			response.sendRedirect(request.getContextPath());
		}
		/*catch (RuleException r) {
			request.setAttribute("message", r.getMessage());
		}*/
		catch (Throwable theException) {
			System.out.println(theException);
		}
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
	
}
