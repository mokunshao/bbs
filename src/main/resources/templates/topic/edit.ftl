<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>修改 Topic 的页面</title>
</head>
<body>
    <h1>修改 Topic</h1>
    <form action="/topic/update" method="post">
        <input name="id" placeholder="id" value="${topic.id}">
        <input name="title" placeholder="content" value="${topic.title}">
        <input name="content" placeholder="content" value="${topic.content}">
        <br>
        <button type="submit">提交修改</button>
    </form>
</body>
</html>
