<%--
  Created by IntelliJ IDEA.
  User: KYBL
  Date: 02.11.2017
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Adding new book</title>

    <style>
        .error {
            color: #ff0000;
        }
    </style>
</head>
    <body>
        <form:form method="POST" modelAttribute="book">
            <form:input type="hidden" path="id" id="id"/>
            <table>
                <tr>
                    <td><label for="title">Title: </label> </td>
                    <td><form:input path="title" id="title"/></td>
                    <td><form:errors path="title" cssClass="error"/></td>
                </tr>

                <tr>
                    <td><label for="author">Author: </label> </td>
                    <td><form:input path="author" id="author"/></td>
                    <td><form:errors path="author" cssClass="error"/></td>
                </tr>

                <tr>
                    <td><label for="description">Description: </label> </td>
                    <td><form:input path="description" id="description"/></td>
                    <td><form:errors path="description" cssClass="error"/></td>
                </tr>

                <tr>
                    <td><label for="numberInRating">Number In Rating: </label> </td>
                    <td><form:input path="numberInRating" id="numberInRating"/></td>
                    <td><form:errors path="numberInRating" cssClass="error"/></td>
                </tr>

                <tr>
                    <td colspan="3">
                        <c:choose>
                            <c:when test="${edit}">
                                <input type="submit" value="Update"/>
                            </c:when>
                            <c:otherwise>
                                <input type="submit" value="Register"/>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </table>
        </form:form>
        <br/>
        <br/>
        Go back to <a href="<c:url value='/list' />">List of All Books</a>
    </body>
</html>
