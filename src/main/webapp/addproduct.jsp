<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="saveproduct"   modelAttribute="product">
<pre>
product Name		:<form:input path="pname"/>
product Brand		:<form:input path="brand"/>
product Price		:<form:input path="price"/>

submit<input type="submit">
</pre>
</form:form>


</body>
</html>