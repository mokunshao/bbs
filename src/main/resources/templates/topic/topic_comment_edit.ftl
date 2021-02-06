<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>编辑评论内容</title>
</head>
<body>
<form action="/topic_comment/update" method="post">
    <input type="hidden" name="id" value="${comment.id}">
    <input name="content" value="${comment.content}">
    <button type="submit">提交变更</button>
</form>
</body>
</html>