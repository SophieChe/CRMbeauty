<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<body>

<h2>All Clients</h2>
<br>
<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Preferences</th>
        <th>Created_at</th>
        <th>Updated_at</th>
        <th>Operations</th>

    </tr>

    <c:forEach var="tempClient" items="${allClient_s}">

        <c:url var="updateButton" value="/updateClient">
            <c:param name="clientId" value="${tempClient.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/deleteClient">
            <c:param name="clientId" value="${tempClient.id}"/>
        </c:url>

        <tr>
            <td>${tempClient.name}</td>
            <td>${tempClient.surname}</td>
            <td>${tempClient.phone}</td>
            <td>${tempClient.email}</td>
            <td>${tempClient.preferences}</td>
            <td>${tempClient.created_at}</td>
            <td>${tempClient.updated_at}</td>
            <td>
                <input type="button" value="Update"
                       onclick="window.location.href = '${updateButton}'"/>
            </td>
            <td>
                <input type="button" value="Delete"
                       onclick="window.location.href = '${deleteButton}'"/>
            </td>
        </tr>

    </c:forEach>

</table>

</body>

</html>