/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.asd.project.application.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.mum.asd.project.fw.customer.Member;
import edu.mum.asd.project.fw.customer.dao.MemberDAO;
import edu.mum.asd.project.fw.record.RecordFacade;
import edu.mum.asd.project.fw.report.dao.ReportDAO;
import edu.mum.asd.project.fw.report.model.Report;
import edu.mum.asd.project.fw.spot.Spot;
import edu.mum.asd.project.fw.spot.dao.SpotDAO;
import edu.mum.asd.project.fw.spot.dp.ParkingSpotsFacade;

/**
 *
 * @author 985965
 */
@WebServlet("/api/*")
public class ApiController extends BaseController {

    private static final long serialVersionUID = -5278344322421351810L;
    RecordFacade recordFacade = new RecordFacade();
    ParkingSpotsFacade parkingSpotsFacade = new ParkingSpotsFacade();
    ReportDAO report = new ReportDAO();
    MemberDAO memberDAO = new MemberDAO();
    SpotDAO spotDAO = new SpotDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String apiName = request.getPathInfo();
//        System.out.println("apiName: " + apiName);
        String json = "";
        Integer id;
        if ("/getCustomers".equals(apiName)) {
            List<Member> members = memberDAO.getMembers();
            json = new Gson().toJson(members);
        } else if ("/spotsByParking".equals(apiName)) {
            id = Integer.valueOf(request.getParameter("pId"));
            List<Spot> spots = parkingSpotsFacade.getSpotsParking(id);
            json = new Gson().toJson(spots);
        } else if ("/spotsdata".equals(apiName)) {
            id = Integer.valueOf(request.getParameter("pId"));
            List<Report> spot_records = parkingSpotsFacade.getSpotsData(id);
//            System.out.println( "price = " + spotDAO.calculatePrice(1) );
            json = new Gson().toJson(spot_records);
        } else if ("/spotCheckOut".equals(apiName)) {
            id = Integer.valueOf(request.getParameter("rId"));
            Double price = parkingSpotsFacade.calculatePrice(id);
            json = new Gson().toJson(price);
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String apiName = request.getPathInfo();
        String json = "";
        Integer id;
        if ("/spotCheckIn".equals(apiName)) {
            id = Integer.valueOf(request.getParameter("carTypeId"));
            Integer cId = null;
            if (request.getParameter("cusId") != null && !request.getParameter("cusId").isEmpty()) {
                cId = Integer.valueOf(request.getParameter("cusId"));
            }
            List<Integer> sIds = new ArrayList<>();
            String[] sids1 = request.getParameter("sId").split(",");
            for (int i = 0; i < sids1.length; i++) {
                sIds.add(Integer.valueOf(sids1[i]));
            }
            recordFacade.checkIn(id, sIds, cId);
            json = new Gson().toJson("success");
        } else if ("/spotCheckOut".equals(apiName)) {
            id = Integer.valueOf(request.getParameter("rId"));
            recordFacade.checkOut(id);
            json = new Gson().toJson("success");
        } else if ("/spotWash".equals(apiName)) {
            id = Integer.valueOf(request.getParameter("rId"));
            recordFacade.washCar(id);
            json = new Gson().toJson("success");
        } else if ("/parkWash".equals(apiName)) {
        	id = Integer.valueOf(request.getParameter("pId"));
        	recordFacade.parkWash(id);
        	json = new Gson().toJson("success");
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    public static void main(String[] args) {
        ApiController a = new ApiController();
//        List<Spot> spots = a.parkingSpotsFacade.getSpotsParking(24);
        List<Integer> sIds = new ArrayList<>();
        String[] ss = new String[]{"1", "2"};
        for (String i : ss) {
            sIds.add(Integer.valueOf(i));
        }
        System.out.println("" + sIds.toString());

    }
}
