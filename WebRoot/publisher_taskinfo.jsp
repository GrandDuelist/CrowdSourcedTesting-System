<%@ page language="java"
	import="java.util.*,cn.com.crowdsourcedtesting.bean.*,cn.com.other.page.*;"
	contentType="text/html; charset=UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<%
	List<BugReport> bugReportList = (List<BugReport>) request.getAttribute("BugReportList");
	BugReport bugReportDetail = (BugReport) request.getAttribute("BugReportDetail");
	if (bugReportDetail == null) {
		bugReportDetail = bugReportList.get(0);
	}
%>
<!DOCTYPE html>
<html>
<head>
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8" />
<title>TCTEST</title>
<meta name="keywords" content="TCTEST" />
<meta name="description" content="TCTEST" />
<meta name="author" content="Rain Cheng" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!-- Font CSS  -->
<link rel="stylesheet" type="text/css" href="css/opensans.css" />

<!-- Core CSS  -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css"
	href="fonts/glyphicons_pro/glyphicons.min.css" />

<!-- Theme CSS -->
<link rel="stylesheet" type="text/css" href="css/theme.css" />
<link rel="stylesheet" type="text/css" href="css/pages.css" />
<link rel="stylesheet" type="text/css" href="css/plugins.css" />
<link rel="stylesheet" type="text/css" href="css/responsive.css" />
<link href="css/animate.css" type="text/css">
<!--Plugins-->
<link rel="stylesheet" type="text/css"
	href="vendor/editors/xeditable/css/bootstrap-editable.css" />
<link rel="stylesheet" type="text/css"
	href="vendor/editors/xeditable/inputs/address/address.css" />
<link rel="stylesheet" type="text/css"
	href="vendor/editors/xeditable/inputs/typeaheadjs/lib/typeahead.js-bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="vendor/plugins/daterange/daterangepicker-bs3.css" />
<!-- Demonstration CSS -->
<link rel="stylesheet" type="text/css" href="css/demo.css" />

<!-- Your Custom CSS -->
<link rel="stylesheet" type="text/css" href="css/custom.css" />

<!-- Favicon -->
<link rel="shortcut icon" href="img/favicon.ico" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<![endif]-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body class="messages-page">
	<!-- Start: Theme Preview Pane -->
	<div id="skin-toolbox">
		<div class="skin-toolbox-toggle">
			<i class="fa fa-flask"></i>
		</div>
		<div class="skin-toolbox-panel">
			<h4 class="padding-left-sm">主题选择</h4>
			<form id="skin-toolbox-form" />

			<div class="form-group">
				<label class="checkbox-inline"> <input id="header-option"
					class="checkbox" type="checkbox" checked="" /> 定制 <b>标题</b> </label>
			</div>
			<div class="form-group">
				<label class="checkbox-inline"> <input id="sidebar-option"
					class="checkbox" type="checkbox" /> 定制 <b>侧边栏</b> </label>
			</div>
			<div class="form-group">
				<label class="checkbox-inline option-disabled"> <input
					id="breadcrumb-option" class="checkbox" type="checkbox" disabled="" />
					定制 <b>Breadcrumbs</b> </label>
			</div>
			<hr class="short" style="margin: 7px 10px;" />
			<div class="form-group">
				<label class="checkbox-inline"> <input
					id="breadcrumb-hidden" class="checkbox" type="checkbox" /> 隐藏 <b>Breadcrumbs</b>
				</label>
			</div>
			<div class="form-group margin-bottom-lg">
				<label class="checkbox-inline"> <input id="searchbar-hidden"
					class="checkbox" type="checkbox" /> 隐藏 <b>搜索框</b> </label>
			</div>
			<h4 class="padding-left-sm">布局选择</h4>
			<div class="form-group">
				<label class="radio-inline"> <input class="radio"
					type="radio" name="optionsRadios" id="fullwidth-option" checked="" />
					全屏 </label>
			</div>
			<div class="form-group">
				<label class="radio-inline"> <input class="radio"
					type="radio" name="optionsRadios" id="boxed-option" /> 局部</label>
			</div>
			<hr class="short" />
			<div class="form-group">
				<a href="customizer.html" id="customizer-link"
					class="btn btn-warning btn-gradient btn-block padding-bottom padding-top">定制</a>
			</div>
			</form>
		</div>
	</div>
	<!-- End: Theme Preview Pane -->

	<!-- Start: Header -->
	<header class="navbar navbar-fixed-top">
		<div class="pull-left">
			<a class="navbar-brand" href="#">
				<div class="navbar-logo">
					<img src="img/logos/logo-red.png" class="img-responsive" alt="logo" />
				</div> </a>
		</div>
		<div class="pull-right header-btns">
			<div class="messages-menu">
				<button type="button"
					class="btn btn-default btn-gradient btn-sm dropdown-toggle"
					data-toggle="dropdown">
					<span class="glyphicon glyphicon-comment"></span> <b>4</b>
				</button>
				<ul class="dropdown-menu checkbox-persist" role="menu">
					<li class="menu-arrow">
						<div class="menu-arrow-up"></div>
					</li>
					<li class="dropdown-header">最近消息 <span
						class="pull-right glyphicons glyphicons-comment"></span></li>
					<li>
						<ul class="dropdown-items">
							<li>
								<div class="item-avatar">
									<img src="img/avatars/header/2.jpg" class="img-responsive"
										alt="avatar" />
								</div>
								<div class="item-message">
									<b>Maggie</b> - <small class="text-muted">12 minutes
										ago</small><br /> Great work Yesterday!
								</div>
							</li>
							<li>
								<div class="item-avatar">
									<img src="img/avatars/header/3.jpg" class="img-responsive"
										alt="avatar" />
								</div>
								<div class="item-message">
									<b>Robert</b> - <small class="text-muted">3 hours ago</small><br />
									Is the Titan Project still on?
								</div>
							</li>
							<li>
								<div class="item-avatar">
									<img src="img/avatars/header/1.jpg" class="img-responsive"
										alt="avatar" />
								</div>
								<div class="item-message">
									<b>Cynthia</b> - <small class="text-muted">14 hours ago</small><br />
									Don't forget about the staff meeting tomorrow
								</div>
							</li>
							<li>
								<div class="item-avatar">
									<img src="img/avatars/header/4.jpg" class="img-responsive"
										alt="avatar" />
								</div>
								<div class="item-message">
									<b>Matt</b> - <small class="text-muted">2 days ago</small><br />
									Thor Project cancelled, Sorry.
								</div>
							</li>
						</ul>
					</li>
					<li class="dropdown-footer"><a href="#">查看所有消息 <i
							class="fa fa-caret-right"></i> </a></li>
				</ul>
			</div>
			<div class="alerts-menu">
				<button type="button"
					class="btn btn-default btn-gradient btn-sm dropdown-toggle"
					data-toggle="dropdown">
					<span class="glyphicons glyphicons-bell"></span> <b>3</b>
				</button>
				<ul class="dropdown-menu checkbox-persist" role="menu">
					<li class="menu-arrow">
						<div class="menu-arrow-up"></div>
					</li>
					<li class="dropdown-header">最近通知 <span
						class="pull-right glyphicons glyphicons-bell"></span></li>
					<li>
						<ul class="dropdown-items">
							<li>
								<div class="item-icon">
									<i style="color: #0066ad;" class="fa fa-facebook"></i>
								</div>
								<div class="item-message">
									<a href="#">Facebook likes reached <b>8,200</b> </a>
								</div>
							</li>
							<li>
								<div class="item-icon">
									<i style="color: #5cb85c;" class="fa fa-check"></i>
								</div>
								<div class="item-message">
									<a href="#">Robert <b>completed task</b> - Client SEO
										Revamp</a>
								</div>
							</li>
							<li>
								<div class="item-icon">
									<i style="color: #f0ad4e" class="fa fa-user"></i>
								</div>
								<div class="item-message">
									<a href="#"><b>Marko</b> logged 12 hours</a>
								</div>
							</li>
						</ul>
					</li>
					<li class="dropdown-footer"><a href="#">查看所有通知 <i
							class="fa fa-caret-right"></i> </a></li>
				</ul>
			</div>
			<div class="tasks-menu">
				<button type="button"
					class="btn btn-default btn-gradient btn-sm dropdown-toggle"
					data-toggle="dropdown">
					<span class="glyphicons glyphicons-tag"></span> <b>7</b>
				</button>
				<ul class="dropdown-menu dropdown-checklist checkbox-persist"
					role="menu">
					<li class="menu-arrow">
						<div class="menu-arrow-up"></div>
					</li>
					<li class="dropdown-header">最近任务 <span
						class="pull-right glyphicons glyphicons-tag"></span></li>
					<li>
						<ul class="dropdown-items">
							<li>
								<div class="item-icon">
									<i class="fa fa-pencil"></i>
								</div>
								<div class="item-message text-slash">
									<a>Try Clicking me!</a>
								</div>
								<div class="item-label">
									<span class="label label-danger">Urgent</span>
								</div>
								<div class="item-checkbox">
									<input class="checkbox row-checkbox" type="checkbox" />
								</div>
							</li>
							<li>
								<div class="item-icon">
									<i class="fa fa-phone"></i>
								</div>
								<div class="item-message text-slash">
									<a>Contact Client and request Approval</a>
								</div>
								<div class="item-label">
									<span class="label label-info">Normal</span>
								</div>
								<div class="item-checkbox">
									<input class="checkbox row-checkbox" type="checkbox" />
								</div>
							</li>
							<li>
								<div class="item-icon">
									<i class="fa fa-flask"></i>
								</div>
								<div class="item-message text-slash">
									<a>Find new Python Developer </a>
								</div>
								<div class="item-label">
									<span class="label label-success">Completed</span>
								</div>
								<div class="item-checkbox">
									<input class="checkbox row-checkbox" type="checkbox" />
								</div>
							</li>
							<li>
								<div class="item-icon">
									<i class="fa fa-facebook"></i>
								</div>
								<div class="item-message text-slash">
									<a>Update Facebook Page with Halloween Pictures</a>
								</div>
								<div class="item-label">
									<span class="label label-primary">In Progress</span>
								</div>
								<div class="item-checkbox">
									<input class="checkbox row-checkbox" type="checkbox" />
								</div>
							</li>
							<li>
								<div class="item-icon">
									<i class="fa fa-group"></i>
								</div>
								<div class="item-message text-slash">
									<a>Organize next Staff Meeting</a>
								</div>
								<div class="item-label">
									<span class="label label-success">Completed</span>
								</div>
								<div class="item-checkbox">
									<input class="checkbox row-checkbox" type="checkbox" />
								</div>
							</li>
							<li>
								<div class="item-icon">
									<i class="fa fa-plane"></i>
								</div>
								<div class="item-message text-slash">
									<a>Interview new applicant</a>
								</div>
								<div class="item-label">
									<span class="label label-warning">Moderate</span>
								</div>
								<div class="item-checkbox">
									<input class="checkbox row-checkbox" type="checkbox" />
								</div>
							</li>
						</ul>
					</li>
					<li class="dropdown-footer"><a href="#">查看所有任务 <i
							class="fa fa-caret-right"></i> </a></li>
				</ul>
			</div>
			<div class="btn-group user-menu">
				<button type="button"
					class="btn btn-default btn-gradient btn-sm dropdown-toggle"
					data-toggle="dropdown">
					<span class="glyphicons glyphicons-user"></span> <b>程冉</b>
				</button>
				<button type="button"
					class="btn btn-default btn-gradient btn-sm dropdown-toggle padding-none"
					data-toggle="dropdown">
					<img src="img/avatars/header/header-login.png" alt="user avatar"
						width="28" height="28" />
				</button>
				<ul class="dropdown-menu checkbox-persist" role="menu">
					<li class="menu-arrow">
						<div class="menu-arrow-up"></div>
					</li>
					<li class="dropdown-header">你的账户 <span
						class="pull-right glyphicons glyphicons-user"></span></li>
					<li>
						<ul class="dropdown-items">
							<li>
								<div class="item-icon">
									<i class="fa fa-envelope-o"></i>
								</div> <a class="item-message" href="messages.html">消息</a>
							</li>
							<li>
								<div class="item-icon">
									<i class="fa fa-calendar"></i>
								</div> <a class="item-message" href="calendar.html">日历</a>
							</li>
							<li class="border-bottom-none">
								<div class="item-icon">
									<i class="fa fa-cog"></i>
								</div> <a class="item-message" href="customizer.html">设置</a>
							</li>
							<li class="padding-none">
								<div class="dropdown-lockout">
									<i class="fa fa-lock"></i> <a href="screen-lock.html">锁定</a>
								</div>
								<div class="dropdown-signout">
									<i class="fa fa-sign-out"></i> <a href="login.html">登出</a>
								</div>
							</li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</header>
	<!-- End: Header -->
	<!-- Start: Main -->
	<div id="main">
		<!-- Start: Sidebar -->
		<aside id="sidebar">
			<div id="sidebar-search">
				<form role="search" />

				<input type="text" class="search-bar form-control" placeholder="搜索" />
				<i class="fa fa-search field-icon-right"></i>
				<button type="submit" class="btn btn-default hidden"></button>
				</form>
				<div class="sidebar-toggle">
					<i class="fa fa-bars"></i>
				</div>
			</div>
			<div id="sidebar-menu">
				<ul class="nav sidebar-nav">
					<li class="active"><a href="publisher_taskman.html"><span
							class="glyphicons glyphicons-notes_2"></span><span
							class="sidebar-title">任务管理</span> </a>
					</li>
					<li><a href="PublisherQuestionnaireMainView.jsp"><span
							class="glyphicons glyphicons-more_items"></span><span
							class="sidebar-title">问卷管理</span> </a>
					</li>
					<li><a href="publisher_hireman.jsp"><span
							class="glyphicons glyphicons-bullhorn"></span><span
							class="sidebar-title">招募信息</span> </a>
					</li>

				</ul>
				</li>
				</ul>
			</div>
		</aside>
		<!-- End: Sidebar -->
		<!-- Start: Content -->
		<section id="content">
			<div id="topbar">
				<ol class="breadcrumb">
					<li><a href="publisher_home.html"><i class="fa fa-home"></i>
					</a></li>
					<li><a href="publisher_home.html">主页</a></li>
					<li><a href="publisher_taskman.html">任务管理</a></li>
					<li><a href="taskList.do">查看任务</a></li>
					<li class="active">任务信息</li>
				</ol>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-md-5 col-lg-4">
						<div class="row">
							<div class="col-md-12">
								<div class="panel">
									<div class="panel-heading panel-visible">
										<div
											class="pull-left margin-right-sm messenger-header-actions ">
											<i class="fa fa-comments"></i> 评论列表
										</div>
										<div class="pull-right">
											<div class="btn-group">
												<button type="button"
													class="btn btn-default btn-gradient dropdown-toggle"
													data-toggle="dropdown">
													<span class="glyphicons glyphicons-cogwheel"></span> 操作
												</button>
												<ul
													class="dropdown-menu checkbox-persist pull-right text-left"
													role="menu">
													<li><a> 全选 </a></li>

												</ul>
											</div>
										</div>
									</div>
									<div class="panel-menu">

										<button type="button" class="btn btn-danger btn-gradient">
											<span class="glyphicons glyphicons-delete padding-right-sm"></span>
											无效
										</button>
										<button type="button" class="btn btn-primary btn-gradient">
											<span class="glyphicons glyphicons-upload padding-right-sm"></span>
											设为有用
										</button>
										<div class="btn-group">
											<button type="button"
												class="btn btn-warning btn-gradient dropdown-toggle"
												data-toggle="dropdown">
												<span class="glyphicons glyphicons-star padding-right-sm"></span>
												奖励
											</button>
											<ul
												class="dropdown-menu checkbox-persist pull-right text-left"
												role="menu">
												<li><a> 50分 </a></li>
												<li><a> 100分 </a></li>
												<li><a> 150分 </a></li>
											</ul>
										</div>
									</div>
									<div class="panel-body">
										<div class="email-menu">
											<table class="table table-hover">
												<tbody>
													<%
														int i=0;
														for (BugReport bugReport: bugReportList) {
														i++;
													%>
													<tr onclick="document.bugReport<%=i %>.submit()">
													<form action="bugReportManagement.do" name="bugReport<%=i%>">
													<input type="hidden" name="method" value="bugReportList" />
													<input type="hidden" name="taskId" value="<%=bugReport.getTestTask().getTaskId() %>" />
													<input type="hidden" name="bugReportId" value="<%= bugReport.getReportId() %>" />
													</form>
														<td class="email-menu-avatar"><img
															src="img/avatars/2.png" class="img-responsive"
															alt="avatar" /></td>
														<td class="email-menu-message"><b><%=bugReport.getTester().getTesterName()%></b><br />
															<%=bugReport.getReportTitle()%></td>
														<td class="email-menu-date"><%=bugReport.getSubmitTime()%></td>
													</tr>
													<%
														}
													%>
												</tbody>
											</table>
										</div>
									</div>
									<!--end of panel body-->
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-7 col-lg-8">
						<div class="row">
							<div class="col-md-12">
								<div class="panel">
									<div class="panel-heading">

										<div class="panel-title visible-lg">
											<i class="fa fa-info-circle"></i> 任务状态 <i
												class="fa fa-circle text-green"></i>
										</div>
										<div class="panel-tray pull-right">
											<button type="button" class="btn btn-success btn-gradient">
												<span class="glyphicon glyphicon-edit padding-right-sm"></span>
												修改
											</button>
										</div>

									</div>
									<div class="panel-body">
										<div class="email-content">
											<div class="email-avatar pull-right">
												<img src="img/avatars/2.png" class="img-responsive" />
											</div>
											<h1 class="email-subject"><%=bugReportDetail.getReportTitle()%></h1>
											<div class="email-from padding-bottom">
												<span class="label label-success">发布者：<%=bugReportDetail.getTester().getTesterName()%></span><span
													class="email-date padding-left"><%=bugReportDetail.getSubmitTime()%></span>
											</div>
											<div class="email-message">
												<h3 class="text-primary">Bug操作：</h3>

												<h3>
													<p>
														<%=bugReportDetail.getOperation()%>
													</p>
												</h3>
												<h3 class="text-primary">Bug结果：</h3>
												<p>
													<%=bugReportDetail.getOperationResult()%>
												</p>
												<%
													if (bugReportDetail.getPicture() != null && !"".equals(bugReportDetail.getPicture())) {
												%>
												<h3 class="text-primary">上传截图：</h3>
												<img src="<%=bugReportDetail.getPicture()%>" />
												<%
													}
												%>
												<hr></hr>
												<% if (bugReportDetail.getIsSelected().equals(false)) { %>
												<div class="text-right">
													<form action="bugReportManagement.do" method="post">
													<input type="hidden" name="method" value="selectBugReport" />
													<input type="hidden" name="bugReportId" value="<%= bugReportDetail.getReportId() %>" />
													<input type="hidden" name="ensure" value="true" />
													<button class="btn btn-success btn-gradient btn-lg"
														type="submit">确认Bug</button>
													</form>
												</div>
												<% } else { %>
												<div class="text-right">
													<form action="bugReportManagement.do" method="post" >
													<input type="hidden" name="method" value="selectBugReport" />
													<input type="hidden" name="bugReportId" value="<%= bugReportDetail.getReportId() %>" />
													<input type="hidden" name="ensure" value="false" />
													<button class="btn btn-danger btn-gradient btn-lg"
														type="submit">否决Bug</button>
													</form>
												</div>
												<% } %>
											</div>

										</div>

									</div>
									<hr></hr>
								</div>
							</div>
						</div>
					</div>


				</div>
			</div>
		</section>
		<!-- End: Content -->
	</div>
	<!-- End: Main -->

	<!-- Core Javascript - via CDN -->
	<script src="js/jquery.min.js"></script>
	<script src="js/jquery-ui.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<!-- Plugins -->
	<script type="text/javascript"
		src="vendor/editors/xeditable/js/bootstrap-editable.js"></script>
	<script type="text/javascript"
		src="vendor/editors/xeditable/inputs/address/address.js"></script>
	<script type="text/javascript"
		src="vendor/editors/xeditable/inputs/typeaheadjs/lib/typeahead.js"></script>
	<script type="text/javascript"
		src="vendor/editors/xeditable/inputs/typeaheadjs/typeaheadjs.js"></script>
	<script type="text/javascript"
		src="vendor/plugins/daterange/moment.min.js"></script>
	<script type="text/javascript"
		src="vendor/plugins/daterange/daterangepicker.js"></script>
	<script type="text/javascript"
		src="vendor/plugins/datepicker/bootstrap-datepicker.js"></script>
	<!-- Theme Javascript -->
	<script type="text/javascript" src="js/uniform.min.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
	<script type="text/javascript" src="js/custom.js"></script>
	<script type="text/javascript">
		jQuery(document).ready(
				function() {

					// Init Theme Core 	  
					Core.init();
					//enable / disable xedit
					$('#enable').click(function() {
						$('#user .editable').editable('toggleDisabled');
					});

					//editables 
					$('#username').editable({
						type : 'text',
						pk : 1,
						name : 'username',
						title : 'Enter username'
					});

					$('#firstname').editable({
						validate : function(value) {
							if ($.trim(value) == '')
								return 'This field is required';
						}
					});

					$('#sex').editable(
							{
								prepend : "not selected",
								source : [ {
									value : 1,
									text : 'Male'
								}, {
									value : 2,
									text : 'Female'
								} ],
								display : function(value, sourceData) {
									var colors = {
										"" : "gray",
										1 : "green",
										2 : "blue"
									}, elem = $.grep(sourceData, function(o) {
										return o.value == value;
									});

									if (elem.length) {
										$(this).text(elem[0].text).css("color",
												colors[value]);
									} else {
										$(this).empty();
									}
								}
							});

					$('#status').editable();

					$('#group').editable({
						showbuttons : false
					});

					$('#vacation').editable({
						datepicker : {
							todayBtn : 'linked'
						}
					});

					$('#dob').editable();

					$('#event').editable({
						placement : 'right',
						combodate : {
							firstItem : 'name'
						}
					});

					$('#meeting_start').editable({
						format : 'yyyy-mm-dd hh:ii',
						viewformat : 'dd/mm/yyyy hh:ii',
						validate : function(v) {
							if (v && v.getDate() == 10)
								return 'Day cant be 10!';
						},
						datetimepicker : {
							todayBtn : 'linked',
							weekStart : 1
						}
					});

					$('#comments').editable({
						showbuttons : 'bottom'
					});

					$('#note').editable();
					$('#pencil').click(function(e) {
						e.stopPropagation();
						e.preventDefault();
						$('#note').editable('toggle');
					});

					$('#state')
							.editable(
									{
										source : [ "Alabama", "Alaska",
												"Arizona", "Arkansas",
												"California", "Colorado",
												"Connecticut", "Delaware",
												"Florida", "Georgia", "Hawaii",
												"Idaho", "Illinois", "Indiana",
												"Iowa", "Kansas", "Kentucky",
												"Louisiana", "Maine",
												"Maryland", "Massachusetts",
												"Michigan", "Minnesota",
												"Mississippi", "Missouri",
												"Montana", "Nebraska",
												"Nevada", "New Hampshire",
												"New Jersey", "New Mexico",
												"New York", "North Dakota",
												"North Carolina", "Ohio",
												"Oklahoma", "Oregon",
												"Pennsylvania", "Rhode Island",
												"South Carolina",
												"South Dakota", "Tennessee",
												"Texas", "Utah", "Vermont",
												"Virginia", "Washington",
												"West Virginia", "Wisconsin",
												"Wyoming" ]
									});

					$('#state2').editable(
							{
								value : 'California',
								typeahead : {
									name : 'state',
									local : [ "Alabama", "Alaska", "Arizona",
											"Arkansas", "California",
											"Colorado", "Connecticut",
											"Delaware", "Florida", "Georgia",
											"Hawaii", "Idaho", "Illinois",
											"Indiana", "Iowa", "Kansas",
											"Kentucky", "Louisiana", "Maine",
											"Maryland", "Massachusetts",
											"Michigan", "Minnesota",
											"Mississippi", "Missouri",
											"Montana", "Nebraska", "Nevada",
											"New Hampshire", "New Jersey",
											"New Mexico", "New York",
											"North Dakota", "North Carolina",
											"Ohio", "Oklahoma", "Oregon",
											"Pennsylvania", "Rhode Island",
											"South Carolina", "South Dakota",
											"Tennessee", "Texas", "Utah",
											"Vermont", "Virginia",
											"Washington", "West Virginia",
											"Wisconsin", "Wyoming" ]
								}
							});

					$('#fruits').editable({
						pk : 1,
						limit : 3,
						source : [ {
							value : 1,
							text : 'banana'
						}, {
							value : 2,
							text : 'peach'
						}, {
							value : 3,
							text : 'apple'
						}, {
							value : 4,
							text : 'watermelon'
						}, {
							value : 5,
							text : 'orange'
						} ]
					});

					$('#address').editable(
							{
								url : '/post',
								value : {
									city : "Moscow",
									street : "Lenina",
									building : "12"
								},
								validate : function(value) {
									if (value.city == '')
										return 'city is required!';
								},
								display : function(value) {
									if (!value) {
										$(this).empty();
										return;
									}
									var html = '_$t'
											+ $('_$tag').text(value.city)
													.html()
											+ '_$ta, '
											+ $('_$tag').text(value.street)
													.html()
											+ ' st., bld. '
											+ $('_$tag').text(value.building)
													.html();
									$(this).html(html);
								}
							});

					$('#user .editable')
							.on(
									'hidden',
									function(e, reason) {
										if (reason === 'save'
												|| reason === 'nochange') {
											var $next = $(this).closest('tr')
													.next().find('.editable');
											if ($('#autoopen').is(':checked')) {
												setTimeout(function() {
													$next.editable('show');
												}, 300);
											} else {
												$next.focus();
											}
										}
									});
				});
	</script>
</body>
</html>
