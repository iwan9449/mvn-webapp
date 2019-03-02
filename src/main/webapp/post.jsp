<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <h2>${ post.title }</h2>
        <h4>${ post.author } ${ post.createdDate }</h4>
        <p>${ post.text }</p>
    </div>


    <form action="/login" method="post">
        <input type="text" name="login">
        <input type="password" name="password">
        <input type="submit" value="Loguj">
        <button type="submit">Przycisk</button>
    </form>





</body>
</html>
