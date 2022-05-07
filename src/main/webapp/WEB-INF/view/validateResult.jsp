<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${errors}" var="error">
    ${error.path} : ${error.message}
    </br>
</c:forEach>

</br>

<c:forEach items="${violations}" var="violation">
    ${violation.propertyPath} : ${violation.message}
    </br>
</c:forEach>
</body>
</html>
