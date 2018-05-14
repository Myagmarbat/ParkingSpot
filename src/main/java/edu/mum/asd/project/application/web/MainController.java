package edu.mum.asd.project.application.web;

import edu.mum.asd.project.fw.customer.Member;
import edu.mum.asd.project.fw.customer.dao.MemberDAO;
import edu.mum.asd.project.fw.record.RecordFacade;
import edu.mum.asd.project.fw.spot.Parking;
import edu.mum.asd.project.fw.spot.dp.ParkingSpotsFacade;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController extends BaseController {

    private static final long serialVersionUID = -5278344322552351810L;
    RecordFacade recordFacade = new RecordFacade();
    ParkingSpotsFacade parkingSpotsFacade = new ParkingSpotsFacade();
    MemberDAO memberDAO = new MemberDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Parking> parkings = parkingSpotsFacade.getParking();
        List<Member> members = memberDAO.getMembers();
        request.setAttribute("members", members);
        request.setAttribute("parkings", parkings);
        System.out.println("request.getContextPath() = " + request.getContextPath());
        System.out.println("request.getRequestURI() = " + request.getRequestURI());
        System.out.println("request.getServletPath() = " + request.getServletContext().getContextPath());
        
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }
}
