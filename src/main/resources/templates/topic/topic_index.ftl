<!DOCTYPE HTML>
<html>
<head>
    <title>Topic</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<form action="/topic/add" method="POST">
    <input type="text" name="token" value="${token}" hidden>

    <input type="text" name="title" placeholder="请输入题目">
    <br>
    <input type="text" name="content" placeholder="请输入正文">
    <br>
    <button type="submit">添加</button>
</form>

<div>
    <#list topics as t>
        <h3>
<#--            /topic/detail/1-->
            <a href="/topic/detail/${t.id}">${t.title}</a>
        </h3>
        <a href="/topic/edit?id=${t.id}">编辑</a>
        <a href="/topic/delete?id=${t.id}">删除</a>
    </#list>
</div>
</body>
</html>