<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width" initial-scale=1, shrink-to-fit=no">
<title>Insert title here</title>
<style>
fieldset
{
  
  max-width:300px;
  padding:16px;	
  -moz-border-radius:8px;
    -webkit-border-radius:8px;	
    border-radius:8px;	
}

 input {
  width: auto;
  padding: 12px 20px;
  margin: 8px 0;
  border: 2px solid black;
  border-radius: 4px;
}

</style>


</head>
<body>
	<%
		session.invalidate();
	%>
	<%@include file="/css/navibar.html"%>
<%@include file="/navibar/indexNavi.jsp"%>
	<br><br><br><br>
	<center><h1>Jasin eIntern</h1>
	<fieldset>
	<center>You have logged out successfully!</center>
	<center>
		<a href="loginpage.jsp"><input type="button" name="Login"
					value="Login"></a>
	</center></fieldset></center>
</body>
</html>