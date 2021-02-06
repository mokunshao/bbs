<html>
    <head>
        <!-- meta charset 指定了页面编码, 否则中文会乱码 -->
        <meta charset="utf-8">
        <!-- title 是浏览器显示的页面标题 -->
        <title>login</title>
    </head>
    <body>
        <a href='/login'>LOGIN</a>
        <a href='/'>HOME</a>
        <h1>登录</h1>
        <form action="/user/login" method="post">
            <input type="text" name="username" placeholder="请输入用户名">
            <br>
            <input type="text" name="password" placeholder="请输入密码">
            <br>
            <button type="submit">登录</button>
        </form>
    </body>
</html>