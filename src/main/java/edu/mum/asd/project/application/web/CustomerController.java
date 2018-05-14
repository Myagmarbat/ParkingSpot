package edu.mum.asd.project.application.web;

import edu.mum.asd.project.fw.customer.Member;
import edu.mum.asd.project.fw.customer.MemberBuilder;
import edu.mum.asd.project.fw.customer.MemberDirector;
import edu.mum.asd.project.fw.customer.dao.MemberDAO;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.api.xdevapi.Collection;


public class CustomerController extends BaseController {

    private static final long serialVersionUID = -5278344322552351810L;

    private MemberDAO memberDAO = new MemberDAO();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> members = memberDAO.getMembers();
        for(Member m: members) {
        	if(m!=null) {
                System.out.println(m.getAddress());
        	}
        }
        request.setAttribute("members", members);
        RequestDispatcher rd = request.getRequestDispatcher("/application/customer.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fname = request.getParameter("firstname");
        String lname = request.getParameter("lastname");
        String email = request.getParameter("email");
        
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");
        Integer ctype = Integer.valueOf(request.getParameter("type"));
        MemberDirector md = new MemberDirector(new MemberBuilder(fname, lname, email, street, city, state, zip, ctype));
        md.construct();
        memberDAO.createMember(md.getMember());
        response.sendRedirect("customer");
    }

}
