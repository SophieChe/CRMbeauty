<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<body>

<h2>Please, enter new client's details: </h2>
<br><br>

<form:form action="saveClientDetails" modelAttribute="client">

    <form:hidden path="id"/>

    Client's name: <form:input path="name"/>
    <form:errors path="name"/>
    <br> <br>
    Client's surname: <form:input path="surname"/>
    <form:errors path="surname"/>
    <br> <br>
    Client's phone: <form:input path="phone"/>
    <form:errors path="phone"/>
    <br> <br>
    Client's email: <form:input path="email"/>
    <br><br>
    Client's preferences: <form:input path="preferences"/>
    <br> <br>
    Created_at: <form:input path="created_at"/>
    <br> <br>
    Updated_at: <form:input path="updated_at"/>
    <br> <br> <br>


    <input type="submit" value="OK">
</form:form>

</body>

</html>