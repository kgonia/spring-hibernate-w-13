<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form method="post"
               modelAttribute="student" action="/student">
        First Name: <form:input path="firstName" />
        Last Name: <form:input path="lastName" />
        Male: <form:radiobutton path="gender" value="M"/>
        Female: <form:radiobutton path="gender" value="F"/>

        Country
        <form:select path="country">
            <form:option value="-" label="--Please Select--"/>
            <form:options items="${countries}"/>
        </form:select>

        Notes:
        <form:textarea path="notes" rows="3"
                       cols="20"/>

        Mailing list:
        <form:checkbox path="mailingList" value="Mailing list"/>

        Skills:
        <form:select path="programmingSkills" multiple="true">
            <form:option value="-" label="--Please Select--"/>
            <form:options items="${programmingSkills}"/>
        </form:select>

        <form:checkboxes items="${hobbies}" path="hobbies" />

        <input type="submit" value="Save">
    </form:form>
</body>
</html>
