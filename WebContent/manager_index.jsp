<!doctype html>
<html>
<head>
<title>经理主页</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Play-Offs Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.apache.struts2.ServletActionContext"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.bean.Risk"%>
<%@ page import="java.util.*"%>
<%
	List<Risk> rList;
	rList = (List<Risk>) ServletActionContext.getRequest().getSession().getAttribute("allRisk");
	System.out.println(rList.size());
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
					<caption>风险列表</caption>
					<thead>
						<tr>
							<th></th>
							<th>风险ID</th>
							<th>风险内容</th>
							<th>可能性</th>
							<th>影响程度</th>
							<th>触发器/阈值</th>
							<th>提交者ID</th>
							<th>跟踪者ID</th>
							<th>状态</th>
						</tr>
					</thead>
					<tbody>
						<%
							int i = 0;
							while (i < rList.size()) {
						%>
						<tr>
							<td><strong>风险数据</strong></td>
							<td><%=rList.get(i).getId()%></td>
							<td><%=rList.get(i).getName()%></td>
							<td>
						<%if(rList.get(i).getPossibility()==0){%>低
						<%}else if(rList.get(i).getPossibility()==1){%>中
						<%}else{%>高
						<%}%></td>
							<td>
							<%if(rList.get(i).getInfluenceDegree()==0){%>低
						<%}else if(rList.get(i).getInfluenceDegree()==1){%>中
						<%}else{%>高
						<%}%></td>
							<td>
							<%=rList.get(i).getTriggerOrThreshold()%></td>
							<td>
							<%=rList.get(i).getCommitter_id()%></td>
							<td>
							<%=rList.get(i).getTracker_id()%></td>
							<td>
							<%if(rList.get(i).getState()==0){%>未分配
						<%}else if(rList.get(i).getState()==1){%>已分配
						<%}else{%>已解决
						<%}%></td>
							</tr>
							<tr>
							<td>
							<strong>追踪描述</strong></td>
							<td colspan="8">
							<%=rList.get(i).getDescription()%></td>
							</tr>
						<%
							i++;
							}
						%>
					</tbody>
				</table>
			</div>
		</div>

		<div class="row">
			<div class="col-xs-4 col-md-offset-2">
				<a class="btn btn-primary" type="button"
					href="/RiskManager/loginoff.action">注销</a>
			</div>
			<div class="col-xs-5">
				<button class="btn btn-primary" type="button" data-toggle="modal"
					data-target="#addModel">添加风险</button>
				<button class="btn btn-primary" type="button" data-toggle="modal"
					data-target="#updateModel">更新风险</button>
				<button class="btn btn-primary" type="button" data-toggle="modal"
					data-target="#deleteModel">删除风险</button>
				<button class="btn btn-primary" type="button" data-toggle="modal"
					data-target="#distributeModel">分配风险</button>
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
					<h4 class="modal-title" id="myModalLabel">添加风险</h4>
				</div>
				<div class="modal-body">

					<form action="addRisk" class="bs-example bs-example-form"
						role="form" style="">

						<div class="input-group">
							<span class="input-group-addon">风险内容:</span> <input type="text"
								class="form-control" placeholder="风险内容" name="name">
						</div>
						<div class="input-group">
							<span class="input-group-addon">可能性:</span> <input type="text"
								class="form-control" placeholder="可能性" name="possibility">
						</div>
						<div class="input-group">
							<span class="input-group-addon">影响程度:</span> <input
								type="text" class="form-control" placeholder="影响程度"
								name="influenceDegree">
						</div>
						<div class="input-group" style="margin-bottom: 5%">
							<span class="input-group-addon">触发器/阈值:</span> <input
								type="text" class="form-control" placeholder="触发器/阈值" name="triggerOrThreshold">
						</div>
						<div class="input-group" style="margin-bottom: 5%">
							<span class="input-group-addon">提交者ID:</span> <input
								type="text" class="form-control" placeholder="提交者ID" name="committer_id">
						</div>
						<div class="input-group" style="margin-bottom: 5%">
							<span class="input-group-addon">跟踪者ID:</span> <input
								type="text" class="form-control" placeholder="跟踪者ID" name="tracker_id">
						</div>
						<div class="input-group" style="margin-bottom: 5%">
							<span class="input-group-addon">状&nbsp;&nbsp;&nbsp;态:</span> <input
								type="text" class="form-control" placeholder="类型" name="state">
						</div>
						<div class="input-group" style="margin-bottom: 5%">
							<span class="input-group-addon">描&nbsp;&nbsp;&nbsp;述:</span> <input
								type="text" class="form-control" placeholder="类型" name="description">
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
					<h4 class="modal-title" id="myModalLabel">更新风险</h4>
				</div>
				<div class="modal-body">

					<form action="updateRisk" class="bs-example bs-example-form"
						role="form" style="">

						<div class="input-group">
							<span class="input-group-addon">风险ID:</span> <input type="text"
								class="form-control" placeholder="风险ID" name="id">
						</div>
						<div class="input-group">
							<span class="input-group-addon">风险内容:</span> <input type="text"
								class="form-control" placeholder="风险内容" name="name">
						</div>
						<div class="input-group">
							<span class="input-group-addon">可能性:</span> <input type="text"
								class="form-control" placeholder="可能性" name="possibility">
						</div>
						<div class="input-group">
							<span class="input-group-addon">影响程度:</span> <input
								type="text" class="form-control" placeholder="影响程度"
								name="influenceDegree">
						</div>
						<div class="input-group" style="margin-bottom: 5%">
							<span class="input-group-addon">触发器/阈值:</span> <input
								type="text" class="form-control" placeholder="触发器/阈值" name="triggerOrThreshold">
						</div>
						<div class="input-group" style="margin-bottom: 5%">
							<span class="input-group-addon">提交者ID:</span> <input
								type="text" class="form-control" placeholder="提交者ID" name="committer_id">
						</div>
						<div class="input-group" style="margin-bottom: 5%">
							<span class="input-group-addon">跟踪者ID:</span> <input
								type="text" class="form-control" placeholder="跟踪者ID" name="tracker_id">
						</div>
						<div class="input-group" style="margin-bottom: 5%">
							<span class="input-group-addon">状&nbsp;&nbsp;&nbsp;态:</span> <input
								type="text" class="form-control" placeholder="类型" name="state">
						</div>
						<div class="input-group" style="margin-bottom: 5%">
							<span class="input-group-addon">描&nbsp;&nbsp;&nbsp;述:</span> <input
								type="text" class="form-control" placeholder="类型" name="description">
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
					<h4 class="modal-title" id="myModalLabel">删除风险</h4>
				</div>
				<div class="modal-body">

					<form action="deleteRisk" class="bs-example bs-example-form"
						role="form" style="">

						<div class="input-group">
							<span class="input-group-addon">风险ID:</span> <input type="text"
								class="form-control" placeholder="风险ID" name="id">
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
	
	<!-- 分配模态框   -->
	<div class="modal fade" id="distributeModel" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">分配风险</h4>
				</div>
				<div class="modal-body">

					<form action="distributeRisk" class="bs-example bs-example-form"
						role="form" style="">

						<div class="input-group">
							<span class="input-group-addon">风险ID:</span> <input type="text"
								class="form-control" placeholder="风险ID" name="id">
						</div>
						<div class="input-group" style="margin-bottom: 5%">
							<span class="input-group-addon">跟踪者ID:</span> <input
								type="text" class="form-control" placeholder="跟踪者ID" name="tracker_id">
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


	<!--  <a>增加</a>

	<div id='addDiv'>
		<s:form action="addRisk">
			<s:textfield name="name" label="用户名"></s:textfield>
			<s:textfield name="possibility" label="密码"></s:textfield>
			<s:textfield name="influenceDegree" label="性别"></s:textfield>
			<s:textfield name="triggerOrThreshold" label="姓名"></s:textfield>
			<s:textfield name="committer_id" label="用户名"></s:textfield>
			<s:textfield name="tracker_id" label="密码"></s:textfield>
			<s:textfield name="state" label="性别"></s:textfield>
			<s:textfield name="description" label="姓名"></s:textfield>
			<s:submit value="添加" />
		</s:form>
	</div>


	<div id='updateDiv'>
		<s:form action="updateRisk">
			<s:textfield name="id" label="用户名"></s:textfield>
			<s:textfield name="name" label="用户名"></s:textfield>
			<s:textfield name="possibility" label="密码"></s:textfield>
			<s:textfield name="influenceDegree" label="性别"></s:textfield>
			<s:textfield name="triggerOrThreshold" label="姓名"></s:textfield>
			<s:textfield name="committer_id" label="用户名"></s:textfield>
			<s:textfield name="tracker_id" label="密码"></s:textfield>
			<s:textfield name="state" label="性别"></s:textfield>
			<s:textfield name="description" label="姓名"></s:textfield>
			<s:submit value="更新" />
		</s:form>
	</div>

	<div id='deleteDiv'>
		<s:form action="deleteRisk">
			<s:textfield name="id" label="用户名"></s:textfield>
			<s:submit value="删除" />
		</s:form>
	</div>


	<div id='otherDiv'>
		<s:form action="distributeRisk">
			<s:textfield name="id" label="用户名"></s:textfield>
			<s:textfield name="committer_id" label="用户名"></s:textfield>
			<s:submit value="分配" />
		</s:form>
	</div>
	
	-->

</body>
</html>