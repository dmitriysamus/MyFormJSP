<%@page import="java.util.*" contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Список</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
    <h1>Список пользователей</h1>
    <p>Ввведите данные пользователя.</p>
    <form action="post">
        <input type="hidden" name="action" value="add">
        <label class="pad_top">First name:</label>
        <input type="text" name="firstName"/><br>
        <label class="pad_top">Last name:</label>
        <input type="text" name="lastName"/><br>
        <label>&nbsp;</label>
        <input type="submit" value="Добавить" class="margin_left">
    </form>

    <p>
    <%
    Enumeration<String> attributeNames = session.getAttributeNames();
    while (attributeNames.hasMoreElements()) {
        String element = (String) attributeNames.nextElement();
        out.println("First name: " + element + ", Last name: " + session.getValue(element) + "<br>");
    }
    %>
    </p>
</body>
</html>