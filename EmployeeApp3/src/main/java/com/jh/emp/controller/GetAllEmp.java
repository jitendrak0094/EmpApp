package com.jh.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.jh.emp.Bo.EmployeeBo;
import com.jh.emp.ServiceI.EmpServiceInterface;
import com.jh.emp.Serviceimpl.ServiceImpl;

@WebServlet("/getAllEmp")
public class GetAllEmp extends HttpServlet{

	static int res=0;
	private static Logger logger = Logger.getLogger(GetAllEmp.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		EmpServiceInterface esi = new ServiceImpl();
		List<EmployeeBo>list=esi.getAll();
		
		
		ServletContext context = getServletContext();
		req.setAttribute("list", list);
		
		if(list.size()!=0) {
			RequestDispatcher rd = context.getRequestDispatcher("/getAll2.jsp");
			
			rd.forward(req, resp);
			logger.info("getAll executed");
		}
		else if(list.isEmpty()) {
			RequestDispatcher rd = context.getRequestDispatcher("/fail2.jsp");
			rd.forward(req, resp);
			logger.info("failled Empty record");
		}
		else {
			RequestDispatcher rd = context.getRequestDispatcher("/fail.jsp");
			rd.forward(req, resp);
			logger.info("getAll failled");
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
	
}


