package edu.mum.asd.project.application.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import edu.mum.asd.project.fw.report.dao.ReportDAO;
import edu.mum.asd.project.fw.report.model.Report;

// Extend HttpServlet class
public class DownLoadExcelServlet extends HttpServlet {
    private static final long serialVersionUID = 2067115822080269398L;
    private ReportDAO reportDAO = new ReportDAO();
 
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        	String searchWord = request.getParameter("searchWord");
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=Report.xls");
            HSSFWorkbook workbook = createExcel(searchWord);
            workbook.write(response.getOutputStream());
        } catch (Exception e) {
            throw new ServletException("Exception in DownLoad Excel Servlet", e);
        }
    }
 
    private HSSFWorkbook createExcel(String searchWord) {
    	List<Report> reports = reportDAO.getReports(searchWord, null);
//    	request.setAttribute("reports", reports);
    	
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet worksheet = workbook.createSheet("Report");
        for(int i = 0; i < reports.size(); i++) {
        	Report report = reports.get(i);
        	
        	HSSFRow row = worksheet.createRow(i);
            HSSFCell cell0 = row.createCell(0);
            cell0.setCellValue(report.getCustomerId());
            HSSFCell cell1 = row.createCell(1);
            cell1.setCellValue(report.getCustomerName());
            HSSFCell cell2 = row.createCell(2);
            cell2.setCellValue(report.getParkingName());
            HSSFCell cell3 = row.createCell(3);
            cell3.setCellValue(report.getCheckinDate().toString());
            HSSFCell cell4 = row.createCell(4);
            cell4.setCellValue(report.getCheckoutDate().toString());
            HSSFCell cell5 = row.createCell(5);
            cell0.setCellValue(report.getDuration());
            HSSFCell cell6 = row.createCell(6);
            cell6.setCellValue(report.getWashed());
            HSSFCell cell7 = row.createCell(7);
            cell7.setCellValue(report.getPrice());
            
            HSSFCellStyle cellStyle = workbook.createCellStyle();
            cell0.setCellStyle(cellStyle);
            cell1.setCellStyle(cellStyle);
            cell2.setCellStyle(cellStyle);
            cell3.setCellStyle(cellStyle);
            cell4.setCellStyle(cellStyle);
            cell5.setCellStyle(cellStyle);
            cell6.setCellStyle(cellStyle);
            cell7.setCellStyle(cellStyle);
            row.setRowStyle(cellStyle);
        }
        
        return workbook;
    }
}