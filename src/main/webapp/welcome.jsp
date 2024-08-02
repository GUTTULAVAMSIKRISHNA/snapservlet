<%@page import="dbconnection.snapdbconnections"%>
<%@page import="models.snap"%>
<%@page import="java.util.List"%>
<%@page import="services.snapservices"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Snap</title>
<%@include file="bootstrap.jsp" %>
</head>

<body>
<h1>welcome</h1>
<table>
<thead>
<tr>
<th scope="col">id</th>
<th  scope="col">name</th>
<th  scope="col">email</th>
<th  scope="col">password</th>
<th scope="col">conformpassword</th>
<th scope="col">actions</th>
</tr>
</thead>
<tbody>
<%
snapservices services= new snapservices(snapdbconnections.getconnection());
List<snap> ll = services.getall();
for(snap s:ll){
	

%>

<tr>
<td><%=s.getId() %></td>
<td><%=s.getName() %></td>
<td><%=s.getEmail() %></td>
<td><%=s.getPassword() %></td>
<td><%=s.getConformpassword() %></td>
<td>
<button class="btn btn-outline-warning">update</button>
<a href="delete?id=<%=s.getId() %>">
<button class="btn btn-outline-danger">delete</button>
</a>
<a href="deletebyEmail?email=<%=s.getEmail() %>">
<button class="btn btn-outline-danger">deletebyEmail</button>
</a>
</td>
<%}
%>
</tr>
</tbody>
</table>
</body>
</html>