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
    <h1 class="alt">Spring MVC 3.1 Demo</h1>
    <hr>
    <div>
      <h3 class="alt"><a href="rolemapping">Custom request condition</a><br></h3>
      <h4>org.springframework.samples.mvc31.mapping.mvc31.requestcondition</h4>
    </div>
    <div>
      <h3 class="alt"><a href="endpointdoc">Endpoint documentation</a></h3>
      <h4>org.springframework.samples.mvc31.mapping.mvc31.endpointdoc</h4>
    </div>
    <div>
      <h3 class="alt"><a href="accounts">CRUD Controller</a></h3>
      <h4>org.springframework.samples.mvc31.mapping.mvc31.crud</h4>
    </div>
    <div>
      <h3 class="alt"><a href="exception">Global @ExceptionHandler method</a></h3>
      <h4>org.springframework.samples.mvc31.mapping.mvc31.exceptionhandler</h4>
    </div>
  </div>
</body>
</html>
