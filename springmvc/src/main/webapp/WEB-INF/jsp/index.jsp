<%@ page language="java" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Add Book</h2>
<form method="post" action="<%=request.getContextPath() %>/book.do?method=add">
    bookname:<input type="text" name="name" id="name">
    author:<input type="text" name="author" id="author">
    <input type="submit" value="Add">
    <c:forEach items="${list}" var="map">
        <li>
            <c:out value="${map.msg}"></c:out>
            <c:out value="${map.status}"></c:out>
            <a href="<c:url value="main/delete/${webpage.id}.htm"/>"><B>delete</B></a>
        </li>
    </c:forEach>
    ${list}
    <%= request %>
    <%= request.getParameter("model") %>
</form>
</body>
</html>
