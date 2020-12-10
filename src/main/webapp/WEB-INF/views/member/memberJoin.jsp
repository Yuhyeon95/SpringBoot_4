<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container">
<form:form modelAttribute="memberVO" enctype="multipart/form-data">
	 <div class="form-group">
		 	<label for="id">ID:</label>
		 	<!-- path : parameter Name -->
		 	<form:input path="id" class="form-control"/>
		 	<form:errors path="id" cssClass="error"></form:errors>
	</div>	 
	<div class="form-group">	
		 	<label for="pw">Password:</label>
		 	<!-- path : parameter Name -->
		 	<form:password path="pw" class="form-control"/>
		 	<form:errors path="pw" cssClass="error"></form:errors>
	</div>	 	
	<div class="form-group">	
		 	<label for="pw">Password:</label>
		 	<!-- path : parameter Name -->
		 	<form:password path="pw2" class="form-control"/>
		 	<form:errors path="pw2" cssClass="error"></form:errors>
	</div>
	<div class="form-group">	 	
		 	<label for="name">Name:</label>
		 	<!-- path : parameter Name -->
		 	<form:input path="name" class="form-control"/>
		 	<form:errors path="name" cssClass="error"></form:errors>
	</div>	 	
	<div class="form-group">	 	
		 	<label for="age">Age:</label>
		 	<!-- path : parameter Name -->
		 	<form:input path="age" class="form-control"/>
		 	<form:errors path="age" cssClass="error"></form:errors>
	</div>
	<div class="form-group">	 	
		 	<label for="email">Email:</label>
		 	<!-- path : parameter Name -->
		 	<form:input path="email" class="form-control"/>
		 	<form:errors path="email" cssClass="error"></form:errors>
	</div>
	
	<button type="submit" class="btn btn-default">Submit</button>
</form:form>
</div>
</body>
</html>