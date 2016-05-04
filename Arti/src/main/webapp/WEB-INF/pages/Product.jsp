
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/mytag.tld" prefix="vi" %>
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

<!-- 
<link rel="stylesheet" type="text/css" href="css/mystyles.css">
<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.9.2.custom.css">
<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.9.2.custom.min.css">
<script type="text/javascript" src="script/jquery-1.8.3.js"></script>
<script type="text/javascript" src="script/jquery-ui-1.9.2.custom.js"></script>
<script type="text/javascript" src="script/jquery-ui-1.9.2.custom.min.js"></script> 
<script type="text/javascript" src="script/myScript.js"></script> 

<script type="text/javascript" src="script/datepicker.js"></script>
 -->

</head>
<body>
<h1 align="center">Product Details</h1>
<div style="width: 600px; float: left; margin-left: 200px;">
<%-- <c:if test="${empSearch == null}"> --%>
<form:form method="post" commandName="prod">
	<table id="myForm">
	
	
		<tr>
			<td style="width: 200px;">Product Name:</td>
			<td style="width: 200px;"><form:input path="product_name"/></td>
			<td style="width: 200px;"><form:errors path="product_name" cssClass="errMsg"></form:errors></td>
		</tr>
		
		<tr>
			<td>Product Specification:</td>
			<td><form:input path="Specification"/></td>
			<td></td>
		</tr>
		
		<tr>
			<td>Product Price:</td>
			<td><form:input path="price"/></td>
		<td><form:errors path="price" cssClass="errMsg"></form:errors></td>
		
		</tr>
		
		<tr>
			<td>Product Posting Date:</td>
			<td><form:input path="date_of_posting"/></td>
				<td><form:errors path="date_of_posting" cssClass="errMsg"></form:errors></td>
		
		</tr>
	
		<tr>
			<td>Product Visited Count:</td>
			<td><form:input path="no_of_times_product_visited" id="dateSelection"/></td>
			<td><form:errors path="no_of_times_product_visited" cssClass="errMsg" style="width: 200px;"></form:errors></td>
		
		</tr>
		 
		<tr>
			<td>Product Category:</td>
			<td>
			
			
			<form:select path="category">
				<c:if test="${!empty category }">
					<c:forEach items="${category}" var="cat">
						<form:option value="${cat.category_id}">${cat.category_name}</form:option>
					</c:forEach>
				</c:if>
				
			
			</form:select>
			
			
			</td> 
		</tr>
	
	
	<tr>
			<td>Product Brand:</td>
			<td>
			
			
			<form:select path="brand">
				<c:if test="${!empty brands }">
					<c:forEach items="${brands}" var="brand1">
						<form:option value="${brand1.brand_id}">${brand1.brand_name}</form:option>
					</c:forEach>
				</c:if>
				
			
			</form:select>
			
			
			</td> 
		</tr>
	
		 <tr>
			<td>Merchant:</td>
			<td>
			
			
			<form:select path="merchant">
				<c:if test="${!empty merchants }">
					<c:forEach items="${merchants}" var="merchant1">
						<form:option value="${merchant1.merchant_id}">${merchant1.merchant_name}</form:option>
					</c:forEach>
				</c:if>
				
			
			</form:select>
			
			
			</td> 
		</tr> 
	
	
	
	<tr>
			<td>Sub_category:</td>
			<td>
			
			
			<form:select path="sub_category">
				<c:if test="${!empty sub_categories }">
					<c:forEach items="${sub_categories}" var="subcategory">
						<form:option value="${subcategory.sub_category_id}">${subcategory.sub_category_name}</form:option>
					</c:forEach>
				</c:if>
				
			
			</form:select>
			
			
			</td> 
		</tr> 
		
		
		<tr>
		<td></td>
		<td>
		
			<input type="submit" value="Save">
			
		</td>
		</tr>
	
	</table>

</form:form>

<%-- </c:if> --%>
<%-- <c:out value="${empSearch.empId}"></c:out> --%>


<%-- <c:if test="${empSearch != null }">

<form:form method="post" action="updateEmployee"  commandName="emp">
	<table>
		 <tr style="visibility: hidden;"> 
			<td style="width: 200px;">Employee Id</td>
			<td><form:input path="empId" value="${emp.empId }"/></td>
			<td style="width: 200px;"><form:errors path=""></form:errors></td>
		</tr>
	
		<tr>
			<td>Employee FirstName:</td>
			<td><form:input path="firstName" value="${emp.firstName}"/></td>
			<td><form:errors path="firstName" cssClass="errMsg"></form:errors></td>
		</tr>
		
		<tr>
			<td>Employee LastName:</td>
			<td><form:input path="lastName" value="${emp.lastName}"/></td>
			<td></td>
		</tr>
		
		<tr>
			<td>Employee Salary:</td>
			<td><form:input path="salary" value="${emp.salary}"/></td>
		<td><form:errors path="salary" cssClass="errMsg" ></form:errors></td>
		
		</tr>
		
		<tr>
			<td>Employee Age:</td>
			<td><form:input path="age" value="${emp.age}"/></td>
				<td><form:errors path="age" cssClass="errMsg" ></form:errors></td>
		
		</tr>
	
		<tr>
			<td>Date of Birth:</td>
			<td><form:input path="empDob" value="${edob}"   id="dateSelection"/></td>
				<td><form:errors path="empDob" cssClass="errMsg" ></form:errors></td>
		
		</tr>
		
		<tr>
			<td>Date of Joining:</td>
			<td><form:input path="empDoj" value="${edoj}" id="dateSelection1"/></td>
				<td><form:errors path="empDoj" cssClass="errMsg" ></form:errors></td>
		
		</tr>
	
		<tr>
			<td>Email Id:</td>
			<td><form:input path="email" value="${emp.email}"/></td>
				<td><form:errors path="email" cssClass="errMsg" ></form:errors></td>
		
		</tr>
	
		<tr>
		<td></td>
		<td>
			<input type="submit" value="Update">
		</td>
		</tr>
	
	</table>

</form:form>

</c:if>


</div>
<div style="float:left; width: 300px; height: 200px;">
	<img alt="Micky" src="images/micky2.jpg">
</div>
<br>
<div style=" width: 900px;">
<c:if test="${!empty emps }">
	<table>
		<tr>
			<th>EmployeeId</th>
			<th>FirstName</th>
			<th>LastNAme</th>
			<th>Salary</th>
			<th>Age</th>
			<th>Date of Birth</th>
			<th>Date of Joining</th>
			<th>Email</th>
			<th>Edit</th>
		</tr>
		<c:forEach items="${emps}" var="employee">
			<tr>
			<td>${ employee.empId}</td>
			<td>${ employee.firstName}</td>
			<td>${ employee.lastName}</td>
			<td>${ employee.salary}</td>
			<td>${ employee.age}</td>
			<td><vi:myDateFormat>${ employee.empDob}</vi:myDateFormat> </td>
			<td><vi:myDateFormat>${ employee.empDoj}</vi:myDateFormat></td>
			<td>${ employee.email}</td>
			
			<td><a href="deleteEmployee/${ employee.empId}">Delete</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="updateEmployee/${ employee.empId}">Update</a>
			</td>
	</tr>
		</c:forEach>
	
	</table>


</c:if>
</div> --%>


</body>
</html>