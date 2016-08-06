<%--
  Created by IntelliJ IDEA.
  User: shuyun
  Date: 2016/8/1
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录页面</title>
</head>
<body>
<form action="addStudent" method="post">
    学生学号: <input type="text" name="stuId"/><br/>
    学生姓名: <input type="text" name="stuName"/><br/>
    下次自动登录<input type="checkbox" name="mark" value="mark"/>
    <input type="submit" value="登陆"/>
</form>
</body>
</html>
