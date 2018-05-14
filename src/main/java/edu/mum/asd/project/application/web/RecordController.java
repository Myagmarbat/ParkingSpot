/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.asd.project.application.web;

import edu.mum.asd.project.fw.record.Record;
import edu.mum.asd.project.fw.record.RecordFacade;
import edu.mum.asd.project.fw.record.model.RecordFilter;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 985965
 */
public class RecordController extends BaseController{
    RecordFacade f = new RecordFacade();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RecordFilter filter = new RecordFilter();
//        filter.setAvailable(false);
        List<Record> records = f.getRecords(filter);
        request.setAttribute("records", records);
        RequestDispatcher rd = request.getRequestDispatcher("/application/record.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fname = request.getParameter("firstname");
        String lname = request.getParameter("lastname");
        String email = request.getParameter("email");
        response.sendRedirect("customer");
    }
    
}
