<%--
  Created by IntelliJ IDEA.
  User: plche
  Date: 7/03/22
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Dojo ${dojo.name}</title>
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
        <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="row justify-content-center mt-4">
            <div class="col-6">
                <h1>${dojo.name} Location Ninjas:</h1>
                <table class="table">
                    <thead class="table-dark">
                        <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Age</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="oneNinja" items="${dojo.ninjas}">
                            <tr>
                                <td><c:out value="${oneNinja.getFirstName()}"/></td>
                                <td><c:out value="${oneNinja.getLastName()}"/></td>
                                <td><c:out value="${oneNinja.getAge()}"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
