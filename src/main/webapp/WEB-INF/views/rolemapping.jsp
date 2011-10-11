<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<link rel="stylesheet" href="<c:url value="/resources/blueprint/screen.css" />" type="text/css" media="screen, projection" />
<link rel="stylesheet" href="<c:url value="/resources/blueprint/print.css" />" type="text/css" media="print" />
<!--[if lt IE 8]><link rel="stylesheet" href="<c:url value="/resources/blueprint/ie.css" />" type="text/css" media="screen, projection"><![endif]-->
</head>
<body>
  <div class="container">
    <hr class="space">
    <h3>${message}</h3>
    <hr>
    <h3 class="alt"><a href="j_spring_security_logout" >Log Out</a></h3>
  </div>
</body>
</html>
