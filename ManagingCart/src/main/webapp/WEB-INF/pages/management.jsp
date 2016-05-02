<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Page</title>
<style type="text/css">
.errMsg{
	color: red;
	font-size: 14px;
	font-weight: bold;
}
</style>

</head>
<body>
<form:form action="saveCartItems" method="post" commandName="cartList">
	<h1 align="center">Account Registration Form</h1>
	
	<table>
		<tr>
			<td>Product</td>
			<td><img alt="Micky" src="images/micky2.jpg"> </td>
			<td>			
			</td>
		</tr>
		
		<tr>
			<td>Add To Cart</td>
			<td><input type='submit' class='myBtn' value='Add To Cart'>
			<td>
			
			</td>
		</tr>
		</table>
		</form:form>