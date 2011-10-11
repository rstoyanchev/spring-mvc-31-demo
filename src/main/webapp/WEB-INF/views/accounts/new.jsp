<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
    <h1 class="alt">Edit Account <span class="loud">${account.number}</span></h1>
    <div class="span-10 last">
      <c:url value="/accounts" var="newAccountUrl" />
      <form:form modelAttribute="account" action="${newAccountUrl}" method="POST">
      <fieldset>
        <p>
          <label for="name">Name: </label><br>
          <form:input path="name" />
          <form:errors cssClass="error" path="name" />
        </p>
        <button type="submit">Add</button>
      </fieldset>
      </form:form>
    </div>
  </div>
</body>
</html>
