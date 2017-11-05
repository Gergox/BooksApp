<%--
  Created by IntelliJ IDEA.
  User: KYBL
  Date: 02.11.2017
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration Confirmation Page</title>
</head>
    <body>
        ${success}
        <br/>
        <br/>
        Go back to <a href="<c:url value='/list' />">List of All Books</a>
    </body>
</html>
