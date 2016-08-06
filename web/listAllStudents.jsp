<%--
  Created by IntelliJ IDEA.
  User: shuyun
  Date: 2016/8/3
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>显示所有学生</title>
</head>
<body>
<h1>显示出了全部的学生</h1>
<table>
    <tr><th>学生学号</th><th>学生姓名</th></tr>
    <c:forEach var="b" items="${studentList}">
        <tr>
            <td>${b.stuId}</td><td>${b.stuName}</td><td><a href="deleteStudent?stuId=${b.stuId}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
