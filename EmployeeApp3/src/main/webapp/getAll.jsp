<%@page import="com.jh.emp.Bo.EmployeeBo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<center>
<h1><font color="Red">WelCome to my Page</font></h1>
<form action="emp" method="Post">
Name<input type="text" name="name" placeholder="Enter your name"><br>
Email<input type="text" name="email" placeholder="Email"><br>
Password<input type="password" name="password" placeholder="Password"><br>
<input type="submit" value="Register"><br><br><br>
</form> 

<h1>
	<font color="Red">Employee Records</font>
</h1>
	<%
		out.println("<body>");
		out.println("<center>");
		out.println("<table width=50% border=1>");
		out.println("<caption style=color:Blue>" + "EMP TABLE" + "</caption>");
		out.println("</center>");
		out.println("<tr>");
		out.println("<th style=color:Blue>" + "ID" + "</th>");
		out.println("<th style=color:Blue>" + "NAME" + "</th>");
		out.println("<th style=color:Blue>" + "EMAIL" + "</th>");
		out.println("<th style=color:Blue>" + "PASSWORD" + "</th>");
		

		List<EmployeeBo> list = (List<EmployeeBo>) request.getAttribute("list");
		for (EmployeeBo emp : list) {
			out.println("<tr>");
			out.println("<td style=color:red>" + emp.getId() + "</td>");
			out.println("<td style=color:red>" + emp.getName() + "</td>");
			out.println("<td style=color:red>" + emp.getEmail() + "</td>");
			out.println("<td style=color:red>" + emp.getPassword() + "</td>");
		}
		out.println("<tr>");
		out.println("</table>");
		out.println("</body>");
	%>
</center>
</body>
</html>