<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% String fname=(String)application.getAttribute("fname"); 
   out.println("welcome ::"+fname);
   out.println("Registration successful");
   out.println("Login for use");  
%>
<jsp:include page="login.html"/>

</body>
</html>