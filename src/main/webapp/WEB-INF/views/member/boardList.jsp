<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>

<script type="text/javascript">
// $(document).ready(function(){  HTML 문서가 로딩이 끝났을 때
//$(function(){					//document.ready의 축약형
</script>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container">
<h3>${board} List</h3>
<img alt="" src="../images/main_1.jpg" width="100px">

<form action="./noticeList">
	<input type="hidden" name="curPage" id="curPage" value="1">
	
	<div class="form-group">
	<select name="kind" id="kind">
	  <option>title</option>
	  <option>writer</option>
	  <option>contents</option>
	</select>
	</div>
	
	 <div class="input-group">
      <input type="text" class="form-control" placeholder="Search" name="search" id="search">
      <div class="input-group-btn">
        <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
      </div>
    </div>
    </form>
	 <div class="table-responsive">    
	 
  <table class="table">
    <thead>
      <tr>
        <th>Num</th>
        <th>Title</th>
        <th>Writer</th>
        <th>Contents</th>
        <th>Date</th>
        <th>Hit</th>
      </tr>
    </thead>
    <tbody>
     <c:forEach items="${mlist}" var="vo">     
      <tr>
        <td>${vo.num}</td>
        <td><a href="./noticeSelect?num=${vo.num}">${vo.title}</a></td>
        <td>${vo.writer}</td>
        <td>${vo.contents}</td>
        <td>${vo.regDate}</td>
        <td>${vo.hit}</td>
      </tr>
       </c:forEach>
    </tbody>
   
  </table>
  </div>
	<div>
		<ul class="pagination">
		<c:if test="${pager.before}">
			<li><a href="#" class="list" title="${pager.startNum-1}">Previous</a></li>
		</c:if>
		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			<li><a href="${pageContext.request.contextPath}?curPage=${i}" class="list" title="${i}">${i}</a></li>
		</c:forEach>
		<c:if test="${pager.after}">
			<li><a href="#" class="list" title="${pager.lastNum+1}">Next</a></li>
		</c:if>
		</ul>
	</div>
	<!-- Write 버튼 생성 클릭 -->
	<button type="button" class="btn" id="btn">Write</button>
	<!-- 
	<input type="submit" value="Write" />
	<input type="button" value="Write" />
	 -->
</div>
<script type="text/javascript">

	$("#search").val('${param.search}');
	var kind = '${param.kind}';
	if(kind != '') {
		$("#kind").val(kind);
	}

	$(".list").click(function(){
		var curPage = $(this).attr("title");
		$("#curPage").val(curPage);
		
		
		$("#frm").submit();
		});

	
	$("#btn").click(function(){
		location.href="./noticeWrite"; //get방식
	});

</script>
</body>
</html>