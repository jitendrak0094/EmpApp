package com.jh.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jh.emp.Bo.EmployeeBo;
import com.jh.emp.ServiceI.EmpServiceInterface;
import com.jh.emp.Serviceimpl.ServiceImpl;

@WebServlet("/emp")
public class EmpController extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String name =req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		EmployeeBo employeeBo = new EmployeeBo();
		employeeBo.setName(name);
		employeeBo.setEmail(email);
		employeeBo.setPassword(password);
		ServiceImpl esi = new ServiceImpl();
		List<EmployeeBo> list=esi.insertRecord(employeeBo);

		
		ServletContext context = getServletContext();
		req.setAttribute("list", list);

		if(list.size()!=0) {
			RequestDispatcher rd = context.getRequestDispatcher("/getAll.jsp");
			rd.forward(req, resp);
		}
		else {
			RequestDispatcher rd = context.getRequestDispatcher("/fail.jsp");
			rd.forward(req, resp);
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		doGet(req, resp);
	}
	
}
