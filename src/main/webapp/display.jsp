<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored = "false"   %>
    
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
style
{

</head>
<body>
<table border="2 px solid black">
<tr>

<th> Product Id</th>
<th> Product Name</th>
<th> Product Price</th>
<th> Brand</th>
<th>Delete</th>
<th>Edit</th>
</tr>
<c:forEach var="em"    items="${products}" >
<tr>
<td> ${em.pid} </td>
<td> ${em.pname} </td>
<td> ${em.price} </td>
<td> ${em.brand} </td>
<td><a href="delete?id=${em.pid}">Delete</a> </td>
<td><a href="edit?id=${em.pid}">Edit</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>