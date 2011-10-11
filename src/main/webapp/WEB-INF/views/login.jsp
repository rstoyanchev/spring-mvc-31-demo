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
    <h1>Login</h1>
    <h3><span class="alt">user/user</span> or <span class="alt">admin/admin</span></h3>
    <div class="span-10 last">
      <form name="f" action="/spring-mvc-31-demo/j_spring_security_check" method="POST"> 
        <fieldset>
          <p>
            <label for="user">User:</label>
            <br>
            <input id="user" type="text" name="j_username" value="">
          </p>
          <p>
            <label for="password">Password:</label>
            <br>
            <input id="password" type="password" name="j_password" value="">
          </p>
          <hr class="space"/>
          <p>
            <input name="submit" type="submit"/> 
            <input name="reset" type="reset"/> 
          </p>
        </fieldset>
      </form>
    </div>
  </div>
</body>
</html>
