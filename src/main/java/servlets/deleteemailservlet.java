package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnection.snapdbconnections;
import services.snapservices;
@WebServlet("/deletebyEmail")
public class deleteemailservlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email = req.getParameter("email");
	snapservices ss=new snapservices(snapdbconnections.getconnection());
	boolean i=ss.deletebyEmail(email);
	if(i) {
		resp.sendRedirect("welcome.jsp");
	}else {
		resp.sendRedirect("welcome.jsp");
	}
}
}
