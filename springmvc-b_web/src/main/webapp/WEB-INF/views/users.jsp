<%--
  Created by IntelliJ IDEA.
  User: gh102
  Date: 2017-08-05
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table cellpadding=0 cellspacing=0 border="1px solid red;">
    <thead>
    <c:forEach items="${userVO.users}" var="u">
        <tr>
            <th>${u.name}</th>
            <th>${u.isMarry}</th>
            <th>${u.age}</th>
        </tr>
    </c:forEach>
    </thead>
</table>
</body>
</html>
