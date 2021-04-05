<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Register For Maja-Talkies</h1>
${msg}
<form action="register" method="post">
<pre>
Name  <input type="text" name="name"/>
Hobbies <input type="text" name="hobbies"/>
Location  <input type="text" name="location"/>
Email  <input type="text" name="email"/>
<input type="submit" value="Register">
</pre>
</form>

</body>
</html>