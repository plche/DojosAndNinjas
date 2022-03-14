<%--
  Created by IntelliJ IDEA.
  User: plche
  Date: 7/03/22
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
    <head>
        <title>New Ninja</title>
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
        <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="row justify-content-center mt-4">
            <div class="col-3">
                <div class="row">
                    <div class="col-8">
                        <h1 class="text-primary mb-3">New Ninja</h1>
                    </div>
                </div>
                <form:form class="rounded border border-5 border-primary" action="/ninjas/new" method="post" modelAttribute="ninja">
                    <div class="row justify-content-center">
                        <div class="col-9">
                            <form:label for="dojo" path="dojo" class="form-label mt-3">Dojo:</form:label>
                            <form:select class="form-select" path="dojo">
                                <c:forEach var="oneDojo" items="${dojos}">
                                    <!--- Cada opción VALUE es el id de la persona --->
                                    <form:option value="${oneDojo.id}" path="dojo">
                                        <!--- Esto es lo que se muestra al usuario como opción --->
                                        <c:out value="${oneDojo.name}" />
                                    </form:option>
                                </c:forEach>
                            </form:select>
                            <form:label for="firstName" path="firstName" class="form-label mt-3">First Name:</form:label>
                            <form:errors path="firstName" cssClass="text-danger" />
                            <form:input type="text" class="form-control mb-3" id="firstName" path="firstName" aria-label="Ninja's first name" />
                            <form:label for="lastName" path="lastName" class="form-label">Last Name:</form:label>
                            <form:errors path="lastName" cssClass="text-danger" />
                            <form:input type="text" class="form-control mb-3" id="lastName" path="lastName" aria-label="Ninja's last name"/>
                            <form:label for="age" path="age" class="form-label">Age:</form:label>
                            <form:errors path="age" cssClass="text-danger" />
                            <form:input type="text" class="form-control mb-3" id="age" path="age" value="1" aria-label="Ninja's age"/>
                            <div class="d-flex justify-content-end">
                                <button type="submit" class="btn btn-primary mb-3">Create</button>
                            </div>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </body>
</html>
