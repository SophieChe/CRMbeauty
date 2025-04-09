<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>

<body>

<h2>New master is created!</h2>
<br><br>

Master's name: ${master.name}
<br><br>
Master's surname: ${master.surname}
<br><br>

<%--Master's specialization(s):--%>
<%--<ul>--%>
<%--    <c:forEach var="special" items="${master.specializations}">--%>
<%--        <li> ${special} </li>--%>
<%--    </c:forEach>--%>
<%--</ul>--%>
Master's level: ${master.masterLevel}
<br><br>
Master's phone: ${master.phone}
<br>


</body>

</html>