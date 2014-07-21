<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

    <form action="${pageContext.request.contextPath}/add" method="post">
        Name: <input name="speaker.name">
        Email: <input name="speaker.email">
        <input type="submit">
    </form>

</body>
</html>
