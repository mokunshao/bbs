<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${topic.title}</title>
</head>
<body>
<h1>${topic.title}</h1>

<p>
    ${topic.content}
</p>

<form method="post" action="/topic_comment/add">
    <input name="topicId" type="hidden" value="#{topic.id}">
    <input name="content">
    <button type="submit">发表评论</button>
</form>

<#list topic.commentList as c >
    ${c.id} ${c.user.username}: ${c.content}
    <a href="/topic_comment/edit/${c.id}">修改</a>
    <a href="/topic_comment/delete/${c.id}">删除</a>
    <br>
</#list>

</body>
</html>