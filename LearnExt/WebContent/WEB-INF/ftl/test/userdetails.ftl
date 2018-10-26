<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8"/>
	<title>user details from db</title>
</head>

<body>
	<#list userlist as user>
	<ul>
		<li>user id: ${user.uid}</li>
		<li>user name: ${user.uname}</li>
		<li>user description: ${user.udescription}</li>
	</ul>
	</#list>
</body>
</html>
	