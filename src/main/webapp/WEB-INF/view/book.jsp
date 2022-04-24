<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form action="/form/book" method="post" modelAttribute="book">
        Title: <form:input path="title" />
        Description: <form:textarea path="description" rows="3"
                       cols="20"/>
        Rating: <form:input path="rating"/>

        Publisher:
        <form:select itemValue="id" itemLabel="name"
                     path="publisher" items="${publishers}"/>

        <input type="submit" value="Wyślij">
    </form:form>

</body>
</html>
