package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnection.snapdbconnections;
import services.snapservices;
@WebServlet("/delete")
public class deleteselvlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	snapservices sn = new snapservices(snapdbconnections.getconnection());
	boolean i=sn.deletebyId(id);
	
	if(i) {
		resp.sendRedirect("welcome.jsp");
	}else {
		resp.sendRedirect("welcome.jsp");
	}
}
}
