<html>
<body>
<h2>Hello World!</h2>
<a href="HomeController/testRequestMapping">testRequestMapping</a>
<form action="HomeController/testPOJO" method="post">
    username:<input type="text" name="username" value=""/><br/>
    password:<input type="text" name="password" value=""/><br/>
    email:<input type="text" name="email" value=""/><br/>
    age:<input type="text" name="age" value=""/><br/>
    city:<input type="text" name="address.city"/><br/>
    province:<input type="text" name="address.province"/><br/>
    <input type="submit" name="提交" value="提交"/>
</form>
</body>
</html>