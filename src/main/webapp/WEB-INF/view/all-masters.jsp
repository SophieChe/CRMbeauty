<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<body>

<h2>All Masters</h2>
<br>
<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
<%--        <th>Specialization</th>--%>
        <th>MasterLevel</th>
        <th>Phone</th>
    </tr>

    <c:forEach var="tempMaster" items="${allMaster_s}">

        <c:url var="updateButton" value="/updateMaster">
            <c:param name="masterId" value="${tempMaster.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/deleteMaster">
            <c:param name="masterId" value="${tempMaster.id}"/>
        </c:url>

        <tr>
            <td>${tempMaster.name}</td>
            <td>${tempMaster.surname}</td>
<%--            <td>${tempMaster.specialization}</td>--%>
            <td>${tempMaster.masterLevel}</td>
            <td>${tempMaster.phone}</td>

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