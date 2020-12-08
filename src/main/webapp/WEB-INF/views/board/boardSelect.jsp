<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container">
		
	<h3>${board} Select</h3>
	
    <div class="form-group">
      <label for="title">Title:</label>
      <input type="text" class="form-control" id="title" name="title" value= "${vo.title}" readonly>
    </div>
    <div class="form-group">
      <label for="writer">Writer:</label>
      <input type="text" class="form-control" id="writer" name="writer" value= "${vo.writer}" readonly>
    </div>
    <div class="form-group">
      <label for="contents">Contents:</label>
      <input type="text" class="form-control" id="writer" name="writer" value= "${vo.contents}" readonly>
    </div>
    
    <c:choose>
    	<c:when test="${board eq notice}">
	    <div class="form-group">
	      <label for="files">File:</label>
	      <c:forEach items="${vo.files}" var="file">
	     	<p><a href="noticeFileDown?fnum=${file.fnum}">${file.oriName}</a></p>
	      </c:forEach>
	    </div>
	    </c:when>
	    <c:otherwise>
	    
	    </c:otherwise>
    </c:choose>
    
   <form id="frm">
		<input type="hidden" value="${vo.num}" name="num"> 
   		<button class="btn btn-primary go" title="Update">Update</button>
   		<button class="btn btn-danger go" title="Delete">Delete</button>
   </form>

</div>
<script type="text/javascript">
	$(".go").click(function() {
		var board= '${board}';
		var t = $(this).attr("title");
		
		$("#frm").attr("action", board+t);

		/*if(t=='Update'){
			$("#frm").attr("method","post");
			alert(t);
		}*/
		$("#frm").submit;
		
		});
	/*
	$("#board-delete").click(function(){
		location.href="./${board}Delete?num=${vo.num}"; //get방식
		});*/
</script>
</body>
</html>
