<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<body>

<h2>Please, enter new master's details: </h2>
<br><br>

<form:form action="saveMasterDetails" modelAttribute="master">

    <form:hidden path="id"/>

    Master's name: <form:input path="name"/>
    <form:errors path="name"/>
    <br> <br>
    Master's surname: <form:input path="surname"/>
    <form:errors path="surname"/>
    <br> <br>
    Master's specialization:
    <form:checkboxes path="specializations" items="${master.specializations}"/>
    <br> <br>
    Master's level:
    <form:radiobuttons path="masterLevel" items="${master.masterLevels}"/>
    <br> <br>
    Master's phone: <form:input path="phone"/>
    <form:errors path="phone"/>
    <br> <br> <br>

    <input type="submit" value="OK">
</form:form>

</body>

</html>