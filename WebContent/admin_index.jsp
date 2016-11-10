<!doctype html>
<html>
<head>
<title>管理员主页</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Play-Offs Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.apache.struts2.ServletActionContext"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.bean.Role"%>
<%@ page import="java.util.*"%>
<%
	List<Role> rList;
	rList = (List<Role>) ServletActionContext.getRequest().getSession().getAttribute("allRole");

	List<Role> mList = new ArrayList();
	List<Role> sList = new ArrayList();
	if (rList != null) {
		for (Role r : rList) {
			if (r.getType() == 1) {
				mList.add(r);
			} else if (r.getType() == 2) {
				sList.add(r);
			}
		}
	}
%>
<!--bootstrap-->
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<!--coustom css-->
<!--script-->
<script src="js/jquery-2.1.4.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<!--fonts-->

<style>
.input-group {
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
			<div class="col-xs-8 col-md-offset-2" style="margin-top: 5%;">
				<table class="table table-striped">
					<caption>用户列表</caption>
					<thead>
						<tr>
							<th>用户ID</th>
							<th>用户名</th>
							<th>密码</th>
							<th>姓名</th>
							<th>用户类型</th>
						</tr>
					</thead>
					<tbody>
						<%
							int i = 0;
							while (i < rList.size()) {
								if (rList.get(i).getType() != 0) {
						%>
						<tr>
							<td><%=rList.get(i).getId()%></td>
							<td><%=rList.get(i).getLogin_id()%></td>
							<td><%=rList.get(i).getPassword()%></td>
							<td><%=rList.get(i).getRolename()%></td>
							<td>
								<%
									if (rList.get(i).getType() == 1) {
								%>经理<%
									} else {
								%>员工<%
									}
								%>
							</td>
						</tr>
						<%
							}
								i++;
							}
						%>
					</tbody>
				</table>
			</div>
		</div>

		<div class="row">
			<div class="col-xs-5 col-md-offset-2">
				<a class="btn btn-primary" type="button" href="/RiskManager/loginoff.action">注销</a>
			</div>
			<div class="col-xs-3">
				<button class="btn btn-primary" type="button" data-toggle="modal"
					data-target="#addModel">添加用户</button>
				<button class="btn btn-primary" type="button" data-toggle="modal"
					data-target="#updateModel">更新用户</button>
				<button class="btn btn-primary" type="button" data-toggle="modal"
					data-target="#deleteModel">删除用户</button>
			</div>
		</div>
	</div>


	<!-- 添加模态框   -->
	<div class="modal fade" id="addModel" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">添加用户</h4>
				</div>
				<div class="modal-body">

					<form action="addRole" class="bs-example bs-example-form"
						role="form" style="">

						<div class="input-group">
							<span class="input-group-addon">姓名:</span> <input type="text"
								class="form-control" placeholder="姓名" name="rolename">
						</div>
						<div class="input-group">
							<span class="input-group-addon">用户名:</span> <input type="text"
								class="form-control" placeholder="用户名" name="login_id">
						</div>
						<div class="input-group">
							<span class="input-group-addon">密&nbsp;&nbsp;&nbsp;码:</span> <input
								type="text" class="form-control" placeholder="密码"
								name="password">
						</div>
						<div class="input-group" style="margin-bottom: 5%">
							<span class="input-group-addon">类&nbsp;&nbsp;&nbsp;型:</span> <input
								type="text" class="form-control" placeholder="类型" name="type">
						</div>
						<button type="submit" class="btn btn-primary"
							style="margin-left: 38%; padding-left: 10%; padding-right: 10%">确定</button>
					</form>
				</div>
				<div class="modal-footer"></div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>

	<!-- 更新模态框   -->
	<div class="modal fade" id="updateModel" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">更新用户</h4>
				</div>
				<div class="modal-body">
					<form action="updateRole" class="bs-example bs-example-form"
						role="form" style="">
						<div class="input-group">
							<span class="input-group-addon">ID:</span> <input type="text"
								class="form-control" placeholder="ID" name="id">
						</div>
						<div class="input-group">
							<span class="input-group-addon">姓名:</span> <input type="text"
								class="form-control" placeholder="姓名" name="rolename">
						</div>
						<div class="input-group">
							<span class="input-group-addon">用户名:</span> <input type="text"
								class="form-control" placeholder="用户名" name="login_id">
						</div>
						<div class="input-group">
							<span class="input-group-addon">密&nbsp;&nbsp;&nbsp;码:</span> <input
								type="text" class="form-control" placeholder="密码"
								name="password">
						</div>
						<div class="input-group" style="margin-bottom: 5%">
							<span class="input-group-addon">类&nbsp;&nbsp;&nbsp;型:</span> <input
								type="text" class="form-control" placeholder="类型" name="type">
						</div>
						<button type="submit" class="btn btn-primary"
							style="margin-left: 38%; padding-left: 10%; padding-right: 10%">确定</button>
					</form>
				</div>
				<div class="modal-footer"></div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>

	<!-- 删除模态框   -->
	<div class="modal fade" id="deleteModel" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">删除用户</h4>
				</div>
				<div class="modal-body">

					<form action="deleteRole" class="bs-example bs-example-form"
						role="form" style="">
						<div class="input-group">
							<span class="input-group-addon">ID:</span> <input type="text"
								class="form-control" placeholder="ID" name="id">
						</div>
						<button type="submit" class="btn btn-primary"
							style="margin-left: 38%; padding-left: 10%; padding-right: 10%">确定</button>
					</form>
				</div>
				<div class="modal-footer">
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	
	<!-- 
	<div id='addDiv'>
		<s:form action="addRole">
			<s:textfield name="rolename" label="用户名"></s:textfield>
			<s:textfield name="login_id" label="密码"></s:textfield>
			<s:textfield name="password" label="性别"></s:textfield>
			<s:textfield name="type" label="姓名"></s:textfield>
			<s:submit value="添加" />
		</s:form>
	</div> 


	<div id='updateDiv'>
		<s:form action="updateRole">
			<s:textfield name="id" label="用户名"></s:textfield>
			<s:textfield name="rolename" label="用户名"></s:textfield>
			<s:textfield name="login_id" label="密码"></s:textfield>
			<s:textfield name="password" label="性别"></s:textfield>
			<s:textfield name="type" label="姓名"></s:textfield>
			<s:submit value="更新" />
		</s:form>
	</div>

	<div id='deleteDiv'>
		<s:form action="deleteRole">
			<s:textfield name="id" label="用户名"></s:textfield>
			<s:submit value="删除" />
		</s:form>
	</div>-->


</body>
</html>