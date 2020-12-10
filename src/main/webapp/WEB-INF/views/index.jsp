<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Bootstrap Example</title>
	<c:import url="./template/bootStrap.jsp"></c:import>
	<link href="./css/index.css" rel="stylesheet">
</head>
<body>
	<c:import url="./template/header.jsp"></c:import>
<div class="container">
	<c:if test="${not empty member}">
		<!-- id 환영합니다 출력 -->
		<h1><spring:message code="member.login.message" arguments="${member.id}"></spring:message></h1>
		<h1>
			<spring:message code="member.login.message2" arguments="${member.id},${member.name}" argumentSeparator=",">
			</spring:message>
		</h1>
	</c:if>

	<h3>Navbar With Dropdown</h3>
	<p>This example adds a dropdown menu for the "Page 1" button in the navigation bar.</p>
	<h1>Message : <spring:message code="hello"></spring:message></h1>
	<spring:message code="name" var="n"></spring:message>
	<h1>Name : ${n}</h1>
	<h2>var : ${n}</h3>
	<h1>Age : <spring:message code="user.age"></spring:message></h1>
	<!-- use 라는 키가 없으면 use로 출력되는데 text에 설정해놓으면 text값이 기본값으로 출력 -->
	<h1>Default : <spring:message code="use" text="Default Message"></spring:message></h1>
	<img alt="munzzy" src="./images/main_1.jpg" width="500px">
	
	<a href="./rest/member/iu/1">Click</a>
	<button class="btn btn-danger" id="btn">Click me</button>
	<button class="btn btn-primary" id="list">List</button>
<script type="text/javascript">
	$("#list").click(function(){
		$.get("board/boardList?curPage=1", function(data){
				console.log(data);
			})
		
		/*$.ajax({
			type:"GET",
			url:"board/boardList",
			data:{ curPage:1 },
			success:function(data){
				alert(data);
				} 
			});*/
		});

	$("#btn").click(function() {
		$.ajax({
			type:"GET",
			url:"board/boardSelect",
			data: {
				num:33
			},
			success:function(data){
				alert(data);
				}
			});

		});



/*	$("#btn").click(function() {
		console.log("click");
		$.get("https://api.manana.kr/exchange.json",function(data){
			console.log(data);
			for(i=0;i<data.length;i++){
				console.log(data[i].kr);
				}
			
			})
		});


	var v = '{"name":"iu", "age":28, "job": {"singer":"top", "actor":"second"}, "food": ["steak","bread","milk"] } ';
	v=JSON.parse(v);
	//변수명.JSON의 키
	alert(v.name);
	alert(v.age);
	alert(v.job.singer);
	alert(v.job.actor);
	alert(v.food);
	for(i=0;i<v.food.length;i++){
		console.log(v.food[i]);
		}
*/	
</script>	
</div>
	
</body>
</html>