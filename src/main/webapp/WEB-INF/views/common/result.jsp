<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var msg = '${msg}'; //문자열로 인식하려면 '넣기
	alert(msg);
	location.href='${path}';
</script>
</head>
<body>

</body>
</html>