<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>智仁学堂</title>
<script type="text/javascript">
	function  selectIncludeByType() {
		window.location.href='selectIncludeByType.html';
	}
</script>
<link href="Style/css.css" rel="stylesheet" type="text/css" />
</head>
<body onload="selectIncludeByType()">
</body>
</html>