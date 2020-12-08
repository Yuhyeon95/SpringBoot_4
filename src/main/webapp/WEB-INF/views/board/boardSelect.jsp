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
	<h3>Navbar With Dropdown</h3>
	<p>This example adds a dropdown menu for the "Page 1" button in the navigation bar.</p>
	<form action="./noticeWrite" method="post" enctype="multipart/form-data">
    <div class="form-group">
      <label for="title">Title:</label>
      <input type="text" class="form-control" id="title" name="title" value= "${board.title}" readonly>
    </div>
    <div class="form-group">
      <label for="writer">Writer:</label>
      <input type="text" class="form-control" id="writer" name="writer" value= "${board.writer}" readonly>
    </div>
    <div class="form-group">
      <label for="contents">Contents:</label>
      <input type="text" class="form-control" id="writer" name="writer" value= "${board.contents}" readonly>
    </div>
    <div class="form-group">
      <label for="files">File:</label>
      <c:forEach items="${board.files}" var="file">
     	<p><a href="noticeFileDown?fnum=${file.fnum}">${file.oriName}</a></p>
      </c:forEach>
    </div>
    
    

    <button type="submit" class="btn btn-default">Update</button>
    <button type="submit" class="btn btn-default">Delete</button>
  </form>
</div>

</body>
