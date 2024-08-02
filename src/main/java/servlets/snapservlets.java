package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnection.snapdbconnections;
import models.snap;
import services.snapservices;

@WebServlet("/register")
public class snapservlets extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String conformpassword=req.getParameter("conformpassword");
//		long phone=Long.parseLong(req.getParameter(phone));
		snap s = new snap(0, name, email, password, conformpassword);
		snapservices ss =new snapservices(snapdbconnections.getconnection());
		boolean f = ss.addingsnap(s);
		if(f) {
			resp.sendRedirect("welcome.jsp");
		}else {
			resp.sendRedirect("register.jsp");
		}
		
		}

}
