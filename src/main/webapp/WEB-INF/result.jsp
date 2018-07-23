<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 03-May-18
  Time: 00:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>result</title>
</head>
<body>
<a href="/"><button>Գլխավոր</button></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="/admin"><button>Նոր</button></a>
<br>
<br>
<form action="/search">
    <input name="search" placeholder="փնտրել">
    <input type="submit" value="փնտրել">
</form>

<br>

<ol style="padding: 100px">
    <%--<li style="width: 400px"><h3 style="color: olive">անուն&nbsp;&nbsp;&nbsp;&nbsp;Հասցե</h3></li>--%>
   <h2 style="color: red">${mess}</h2>
        <h2 style="color: red">${mes}</h2>
    <c:forEach items="${allUsers}" var="one">

        <li style="width: 300px;float: left;border-style: ridge;background-color: pink"><h3>${one.name}&nbsp;${one.country}
            <a href="/credit?id=${one.id}"><button style="border-color: red;border-radius: 200px">OK</button></a> </li>

    </c:forEach>
<%--</ol>--%>
<%--<ol style="padding: 100px">--%>
    <%--<li style="width: 400px"><h3 style="color: olive">անուն&nbsp;&nbsp;&nbsp;&nbsp;Հասցե</h3></li>--%>

    <c:forEach items="${allByDate}" var="one">

        <li style="width: 300px;float: left;border-style: ridge;background-color: pink"><h3>${one.user.name}&nbsp;${one.user.country}
            <a href="/credit?id=${one.user.id}"><button style="border-color: red;border-radius: 200px">OK</button></a><br>${one.date.substring(5,10)}&nbsp;&nbsp;${one.price} </li>

    </c:forEach>
</ol>


</body>
</html>
