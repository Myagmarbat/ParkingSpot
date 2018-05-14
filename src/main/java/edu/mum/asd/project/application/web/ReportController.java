package edu.mum.asd.project.application.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.mum.asd.project.fw.report.dao.ReportDAO;
import edu.mum.asd.project.fw.report.model.Report;

public class ReportController extends BaseController {

    private static final long serialVersionUID = -5278344322552351810L;
    private ReportDAO reportDAO = new ReportDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String searchWord = request.getParameter("searchWord");
    	System.out.println("searchWord = " + searchWord);
    	List<Report> reports = reportDAO.getReports(searchWord, null);
    	request.setAttribute("reports", reports);
    	
        RequestDispatcher rd = request.getRequestDispatcher("/application/report.jsp");
        rd.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
    }
}
