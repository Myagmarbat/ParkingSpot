<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<%@ page import="edu.mum.asd.project.application.model.Staff" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <!--<link rel="stylesheet"
                href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
                integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
                crossorigin="anonymous">-->

        <!--	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
                
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
                integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
                crossorigin="anonymous"></script>
        <script
                src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
                integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
                crossorigin="anonymous"></script>
        <script
                src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
                integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
                crossorigin="anonymous"></script>-->

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <style>
            .card-columns {
                @include media-breakpoint-only(lg) {
                    column-count: 4;
                }
                @include media-breakpoint-only(xl) {
                    column-count: 5;
                }
            }    
        </style>

    </head>

    <body class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light"> <a
            class="navbar-brand" href="index">Parking Lot Management</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<%
						String servletPath = request.getServletPath();
						int menuIdx = 0;
						if(servletPath.contains("index")){
							menuIdx = 0;
						} else if(servletPath.contains("customer")){
							menuIdx = 1;
						} else if(servletPath.contains("parking")){
							menuIdx = 2;
						} else if(servletPath.contains("report")){
							menuIdx = 3;
						}
				%>
           <div class="navbar-nav">
                <a class="nav-item nav-link <% if(menuIdx == 0){ %>active<%} %>" href="index">Home
                    <!-- <span class="sr-only">(current)</span> -->
                </a> <a class="nav-item nav-link <% if(menuIdx == 1){ %>active<%} %>" href="customer">Customer</a> <a
                    class="nav-item nav-link <% if(menuIdx == 2){ %>active<%} %>" href="parking">Parking</a> <a
                    class="nav-item nav-link <% if(menuIdx == 3){ %>active<%} %>" href="report">Report</a>
            </div>
        </div>
        <div>
            <% Staff user = (Staff) request.getSession().getAttribute("staff");
                if (user != null) {
                    out.println("Username: " + user.getStaffName());
            %>
            <a class="nav-item nav-link" href="logout">Logout</a>
            <% } else { %>
            <a class="nav-item nav-link" href="login">Login</a>
            <% }%>

        </div>
    </nav>