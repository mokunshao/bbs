<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>修改 TODO 的页面</title>
</head>
<body>
    <h1>修改 TODO</h1>
    <form action="/todo/update" method="post">
        <input name="id" placeholder="id" value="${todo.id}">
        <input name="content" placeholder="content" value="${todo.content}">
        <br>
        <button type="submit">提交修改</button>
    </form>
</body>
</html>
