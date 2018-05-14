<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Login Page</title>
</head>
<body class="container">
	<div style="width: 360px; margin: 7% auto;">
		<div style="padding: 20px;">
			<form action="login" method="post">
				<div class="form-group">
					<label>Staff Name</label>
					<input name="un" type="text" class="form-control" placeholder="Enter email">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Password</label>
					<input name="pw" type="password" class="form-control" placeholder="Password">
				</div>

				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</div>
		</div>
</body>
</html>