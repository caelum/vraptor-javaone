<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

    <ul>
        <c:forEach items="${speakers}" var="speaker">
            <li>${speaker.name}</li>
        </c:forEach>
    </ul>

</body>
</html>
