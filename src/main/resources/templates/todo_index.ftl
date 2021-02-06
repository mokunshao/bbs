<!DOCTYPE HTML>
<html>
<head>
    <title>ssm todo</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<form action="/todo/add" method="POST">
    <input type="text" name="content" placeholder="请输入todo">
    <br>
    <button type="submit">添加</button>
</form>
<h3>

</h3>
<div>
    <#list todos as t>
        <h3>${t.id} : ${t.content ? html}</h3>
        <a href="/todo/edit?id=${t.id}">编辑</a>
        <a href="/todo/delete?id=${t.id}">删除</a>
    </#list>
</div>
</body>
</html>