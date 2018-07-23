<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 02-May-18
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>detail</title>
</head>
<body>
<a href="/"><button>Գլխավոր</button></a>

<h3 style="color: red">${user.name}&nbsp;${user.country}&nbsp;${user.tel}&nbsp; &nbsp; &nbsp;
    <a href="/update?id=${user.id}"><button>թարմացնել</button></a>&nbsp; &nbsp; &nbsp;
    <a href="/deleteUser?id=${user.id}"><button> ջնջել ցուցակից </button></a>${message}</h3>


<spring:form action="/addCredit" modelAttribute="creditor" method="post">
    <spring:hidden path="user" value="${user.id}"></spring:hidden>
    Նոր պարտք  <spring:input type="number" step="50"  path="price" placeholder="partq"></spring:input>
    <spring:button>ավելացնել</spring:button>
</spring:form>
<ol>
    <li><h3 style="color: olive">ամիս/օր &nbsp; գումար</h3></li>
    <c:forEach items="${credit}" var="one">
        <c:if test="${one.type=='NEW'}">
            <li><h3>${one.date.substring(5,10)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${one.price}
                <a href="/changeType?id=${one.id}"><button>+</button></a></li>
        </c:if>
    </c:forEach>
    <%--<span style="color: red"><h3>GUMAR ${sum}</h3></span>--%>
    <span style="color: red"><h3>ընդհանուր= ${userSum}</h3></span>
</ol>
<hr>
<h2>Տված</h2>
<ol>
    <li><h3>ամիս/օր &nbsp;  գումար</h3></li>
    <c:forEach items="${credit}" var="one">
        <c:if test="${one.type=='END'}">
            <li><h3>${one.date.substring(5,10)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${one.price}
                <a href="/deletePrice?id=${one.id}"><button>ջնջել</button></a></li>
        </c:if>
    </c:forEach>
</ol>
</body>
</html>
