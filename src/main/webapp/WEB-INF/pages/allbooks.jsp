<%--
  Created by IntelliJ IDEA.
  User: KYBL
  Date: 02.11.2017
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book manager</title>
    <link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">
</head>
<body>
<h1>List of books</h1>
<a class="add" href="<c:url value='/new' />">Add New Book</a>
<div>
    <c:forEach items="${books}" var="book">
        <h2>${book.title}</h2>
        <p class="author">${book.author}</p>
        <p class="desc">${book.description}</p>
        <a href="<c:url value='/delete-${book.id}-book' />">delete</a>
        <a href="<c:url value='/edit-${book.id}-book' />">edit</a>
    </c:forEach>
</div>

</body>
</html>