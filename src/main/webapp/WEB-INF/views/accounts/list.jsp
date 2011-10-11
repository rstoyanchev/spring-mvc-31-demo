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
    <h1 class="alt">Account Listing</h1>
    <h4>
      <c:url var="homeUrl" value="/" />
      <a href="${homeUrl}">Home</a>
    </h4>
    <hr>
    <div class="span-10 last">
      <table>
        <thead>
          <tr>
            <th>Number</th>
            <th>Name</th>
            <th></th>
          </tr>
        </thead>
        <c:forEach var="account" items="${accounts}">
          <tr>
            <td>
              <spring:url var="editUrl" value="/accounts/{number}/edit">
                <spring:param name="number" value="${account.number}" />
              </spring:url>
              <a href="${editUrl}">${account.number}</a>
            </td>
            <td>${account.name}</td>
            <td>
              <spring:url var="deleteUrl" value="/accounts/{number}">
                <spring:param name="number" value="${account.number}" />
              </spring:url>
              <form:form modelAttribute="account" action="${deleteUrl}" method="DELETE">
                <button type="submit">Delete</button>
              </form:form>
            </td>
          </tr>
        </c:forEach>
      </table>
    </div>
    <hr>
    <div>
      <p>
        <c:url var="addUrl" value="/accounts/new" />
        <h4><a href="${addUrl}">Add</a></h4>
      </p>
    </div>
  </div>
</body>
</html>
