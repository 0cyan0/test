<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="zh" class="no-js">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--bootstrap-->
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<style>
.input-group{
    margin: 5%;
}
body {
	font-family: '微软雅黑 light';
}
</style>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-xs-4 col-md-offset-4">
				<!-- 
				<s:form action="login2">
					<p>
						<s:textfield name="role.login_id" label="Username"></s:textfield>
					</p>
					<p>
						<s:password name="role.password" label="Password"></s:password>
					</p>
					<p>
						<s:submit value="Login" class="btn btn-primary"></s:submit>
					</p>
				</s:form>
				 -->
				<form action="login2" class="bs-example bs-example-form" role="form" style="padding-top:50%">

					<div class="input-group">
						<span class="input-group-addon">用户名:</span> <input type="text"
							class="form-control" placeholder="id" name="login_id">
					</div>
					<div class="input-group">
						<span class="input-group-addon">密&nbsp;&nbsp;&nbsp;码:</span> <input type="password"
							class="form-control" placeholder="password" name="password">
					</div>
					
					<!--  input name="login_id" label="Username"> <input
						name="password" label="Password">-->
					<button value="Login" class="btn btn-primary" type="submit" 
					style="margin-left: 37%;padding-left: 10%;padding-right: 10%;">登陆</button>
				</form>
			</div>
		</div>
	</div>


</body>
</html>