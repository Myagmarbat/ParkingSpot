package edu.mum.asd.project.application.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.mum.asd.project.fw.spot.dp.ParkingSpotsFacade;
import edu.mum.asd.project.fw.spot.model.ParkingSpotInsert;

public class ParkingController extends BaseController {

    private static final long serialVersionUID = -5278344322552351810L;
    ParkingSpotsFacade f = new ParkingSpotsFacade();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Spot> spots = f.getSpotsParking(10);
//        request.setAttribute("spots", spots);
//        request.setAttribute("parkings", f.getParking());
//    	List<ParkingInfo> pa = f.countParkings();
    	
//    	for( int i = 0; i < pa.size(); i++) {
//    		System.out.println(pa.get(i).getParkName());
//    	}
        request.setAttribute("parkings", f.countParkings());
        request.setAttribute("spots", f.getSpotsParking(10));
        RequestDispatcher rd = request.getRequestDispatcher("/application/parking.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<ParkingSpotInsert> l = new ArrayList<>();
    	String[] qty = request.getParameterValues("qty");
    	String[] qType = request.getParameterValues("qtyType");
    	for(int i = 0; i < qty.length; i++) {
    		l.add(new ParkingSpotInsert(Integer.parseInt(qty[i]), Integer.parseInt(qType[i])));
    	}
    	f.Process(request.getParameter("name"), l);
    	
    	response.sendRedirect("parking");
    }

}
