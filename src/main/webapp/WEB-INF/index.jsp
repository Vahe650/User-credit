<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 02-May-18
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
</head>
<body style="background-color: darkkhaki">
<div>
<form action="/search">
    <input name="search" placeholder="փնտրել">
    <input STYLE="color: red;border-radius: 500px;border-color: red" type="submit" value="փնտրել">
</form>
    <form action="/searchByDate">
        <input type="date" name="date" placeholder="amsativ">
        <input STYLE="color: red;border-radius: 500px;border-color: red" type="submit" value="փնտրել">
    </form>
</div>
<a href="/admin"><button style="border-radius: 200px;border-color: red">Նոր</button></a>
<ol style="padding: 100px">
    <li><h3 style="color: olive"><strong style="color: red;">ընդհանուր=${s}</strong></h3></li>
    <c:forEach items="${all}" var="one">
        <li style="width: 300px;float: left;border-style: ridge;background-color: yellow"><h3>${one.name}&nbsp;${one.country}
            <a href="/credit?id=${one.id}"><button style="border-radius: 200px;border-color: red">OK</button></a> </li>
    </c:forEach>
</ol>
</body>
</html>
