﻿<%@ page language="java" import="java.util.*,cn.com.crowdsourcedtesting.bean.*,cn.com.other.page.*;" contentType="text/html; charset=UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
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
<link rel="stylesheet" type="text/css" href="fonts/glyphicons_pro/glyphicons.min.css" />

<!-- Plugin CSS -->
<link rel="stylesheet" type="text/css" href="vendor/plugins/calendar/fullcalendar.css" media="screen" />
<link rel="stylesheet" type="text/css" href="vendor/plugins/datatables/css/datatables.min.css" />
<link rel="stylesheet" type="text/css" href="vendor/editors/xeditable/css/bootstrap-editable.css" />
<link rel="stylesheet" type="text/css" href="vendor/plugins/chosen/chosen.min.css" />

<!-- Theme CSS -->
<link rel="stylesheet" type="text/css" href="css/theme.css" />
<link rel="stylesheet" type="text/css" href="css/pages.css" />
<link rel="stylesheet" type="text/css" href="css/plugins.css" />
<link rel="stylesheet" type="text/css" href="css/responsive.css" />

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

<body>
<!-- Start: Theme Preview Pane -->
<div id="skin-toolbox">
  <div class="skin-toolbox-toggle"> <i class="fa fa-flask"></i> </div>
  <div class="skin-toolbox-panel">
    <h4 class="padding-left-sm">主题选择</h4>
    <form id="skin-toolbox-form" />
    
    <div class="form-group">
      <label class="checkbox-inline">
        <input id="header-option" class="checkbox" type="checkbox" checked="" />
        定制 <b>标题</b> </label>
    </div>
    <div class="form-group">
      <label class="checkbox-inline">
        <input id="sidebar-option" class="checkbox" type="checkbox" />
        定制 <b>侧边栏</b> </label>
    </div>
    <div class="form-group">
      <label class="checkbox-inline option-disabled">
        <input id="breadcrumb-option" class="checkbox" type="checkbox" disabled="" />
        定制 <b>Breadcrumbs</b> </label>
    </div>
    <hr class="short" style="margin: 7px 10px;" />
    <div class="form-group">
      <label class="checkbox-inline">
        <input id="breadcrumb-hidden" class="checkbox" type="checkbox" />
        隐藏 <b>Breadcrumbs</b> </label>
    </div>
    <div class="form-group margin-bottom-lg">
      <label class="checkbox-inline">
        <input id="searchbar-hidden" class="checkbox" type="checkbox" />
        隐藏 <b>搜索框</b> </label>
    </div>
    <h4 class="padding-left-sm">布局选择</h4>
    <div class="form-group">
      <label class="radio-inline">
        <input class="radio" type="radio" name="optionsRadios" id="fullwidth-option" checked="" />
        全屏 </label>
    </div>
    <div class="form-group">
      <label class="radio-inline">
        <input class="radio" type="radio" name="optionsRadios" id="boxed-option" />
        局部</label>
    </div>
    <hr class="short" />
    <div class="form-group"> <a href="customizer.html" id="customizer-link" class="btn btn-warning btn-gradient btn-block padding-bottom padding-top">定制</a> </div>
    </form>
  </div>
</div>
<!-- End: Theme Preview Pane --> 

<!-- Start: Header -->
<header class="navbar navbar-fixed-top">
  <div class="pull-left"> <a class="navbar-brand" href="#">
    <div class="navbar-logo"><img src="img/logos/logo-red.png" class="img-responsive" alt="logo" /></div>
    </a> </div>
  <div class="pull-right header-btns">
    <div class="messages-menu">
      <button type="button" class="btn btn-default btn-gradient btn-sm dropdown-toggle" data-toggle="dropdown"> <span class="glyphicon glyphicon-comment"></span> <b>4</b> </button>
      <ul class="dropdown-menu checkbox-persist" role="menu">
        <li class="menu-arrow">
          <div class="menu-arrow-up"></div>
        </li>
        <li class="dropdown-header">最近消息 <span class="pull-right glyphicons glyphicons-comment"></span></li>
        <li>
          <ul class="dropdown-items">
            <li>
              <div class="item-avatar"><img src="img/avatars/header/2.jpg" class="img-responsive" alt="avatar" /></div>
              <div class="item-message"><b>Maggie</b> - <small class="text-muted">12 minutes ago</small><br />
                Great work Yesterday!</div>
            </li>
            <li>
              <div class="item-avatar"><img src="img/avatars/header/3.jpg" class="img-responsive" alt="avatar" /></div>
              <div class="item-message"><b>Robert</b> - <small class="text-muted">3 hours ago</small><br />
                Is the Titan Project still on?</div>
            </li>
            <li>
              <div class="item-avatar"><img src="img/avatars/header/1.jpg" class="img-responsive" alt="avatar" /></div>
              <div class="item-message"><b>Cynthia</b> - <small class="text-muted">14 hours ago</small><br />
                Don't forget about the staff meeting tomorrow</div>
            </li>
            <li>
              <div class="item-avatar"><img src="img/avatars/header/4.jpg" class="img-responsive" alt="avatar" /></div>
              <div class="item-message"><b>Matt</b> - <small class="text-muted">2 days ago</small><br />
                Thor Project cancelled, Sorry.</div>
            </li>
          </ul>
        </li>
        <li class="dropdown-footer"><a href="#">查看所有消息 <i class="fa fa-caret-right"></i> </a></li>
      </ul>
    </div>
    <div class="alerts-menu">
      <button type="button" class="btn btn-default btn-gradient btn-sm dropdown-toggle" data-toggle="dropdown"> <span class="glyphicons glyphicons-bell"></span> <b>3</b> </button>
      <ul class="dropdown-menu checkbox-persist" role="menu">
        <li class="menu-arrow">
          <div class="menu-arrow-up"></div>
        </li>
        <li class="dropdown-header">最近通知 <span class="pull-right glyphicons glyphicons-bell"></span></li>
        <li>
          <ul class="dropdown-items">
            <li>
              <div class="item-icon"><i style="color: #0066ad;" class="fa fa-facebook"></i> </div>
              <div class="item-message"><a href="#">Facebook likes reached <b>8,200</b></a></div>
            </li>
            <li>
              <div class="item-icon"><i style="color: #5cb85c;" class="fa fa-check"></i> </div>
              <div class="item-message"><a href="#">Robert <b>completed task</b> - Client SEO Revamp</a></div>
            </li>
            <li>
              <div class="item-icon"><i style="color: #f0ad4e" class="fa fa-user"></i> </div>
              <div class="item-message"><a href="#"><b>Marko</b> logged 12 hours</a></div>
            </li>
          </ul>
        </li>
        <li class="dropdown-footer"><a href="#">查看所有通知 <i class="fa fa-caret-right"></i> </a></li>
      </ul>
    </div>
    <div class="tasks-menu">
      <button type="button" class="btn btn-default btn-gradient btn-sm dropdown-toggle" data-toggle="dropdown"> <span class="glyphicons glyphicons-tag"></span> <b>7</b> </button>
      <ul class="dropdown-menu dropdown-checklist checkbox-persist" role="menu">
        <li class="menu-arrow">
          <div class="menu-arrow-up"></div>
        </li>
        <li class="dropdown-header">最近任务 <span class="pull-right glyphicons glyphicons-tag"></span></li>
        <li>
          <ul class="dropdown-items">
            <li>
              <div class="item-icon"><i class="fa fa-pencil"></i> </div>
              <div class="item-message text-slash"><a>Try Clicking me!</a></div>
              <div class="item-label"><span class="label label-danger">Urgent</span></div>
              <div class="item-checkbox">
                <input class="checkbox row-checkbox" type="checkbox" />
              </div>
            </li>
            <li>
              <div class="item-icon"><i class="fa fa-phone"></i> </div>
              <div class="item-message text-slash"><a>Contact Client and request Approval</a></div>
              <div class="item-label"><span class="label label-info">Normal</span></div>
              <div class="item-checkbox">
                <input class="checkbox row-checkbox" type="checkbox" />
              </div>
            </li>
            <li>
              <div class="item-icon"><i class="fa fa-flask"></i> </div>
              <div class="item-message text-slash"><a>Find new Python Developer </a></div>
              <div class="item-label"><span class="label label-success">Completed</span></div>
              <div class="item-checkbox">
                <input class="checkbox row-checkbox" type="checkbox" />
              </div>
            </li>
            <li>
              <div class="item-icon"><i class="fa fa-facebook"></i> </div>
              <div class="item-message text-slash"><a>Update Facebook Page with Halloween Pictures</a></div>
              <div class="item-label"><span class="label label-primary">In Progress</span></div>
              <div class="item-checkbox">
                <input class="checkbox row-checkbox" type="checkbox" />
              </div>
            </li>
            <li>
              <div class="item-icon"><i class="fa fa-group"></i> </div>
              <div class="item-message text-slash"><a>Organize next Staff Meeting</a></div>
              <div class="item-label"><span class="label label-success">Completed</span></div>
              <div class="item-checkbox">
                <input class="checkbox row-checkbox" type="checkbox" />
              </div>
            </li>
            <li>
              <div class="item-icon"><i class="fa fa-plane"></i> </div>
              <div class="item-message text-slash"><a>Interview new applicant</a></div>
              <div class="item-label"><span class="label label-warning">Moderate</span></div>
              <div class="item-checkbox">
                <input class="checkbox row-checkbox" type="checkbox" />
              </div>
            </li>
          </ul>
        </li>
        <li class="dropdown-footer"><a href="#">查看所有任务 <i class="fa fa-caret-right"></i> </a></li>
      </ul>
    </div>
    <div class="btn-group user-menu">
      <button type="button" class="btn btn-default btn-gradient btn-sm dropdown-toggle" data-toggle="dropdown"> <span class="glyphicons glyphicons-user"></span> <b>程冉</b> </button>
      <button type="button" class="btn btn-default btn-gradient btn-sm dropdown-toggle padding-none" data-toggle="dropdown"> <img src="img/avatars/header/header-login.png" alt="user avatar" width="28" height="28" /> </button>
      <ul class="dropdown-menu checkbox-persist" role="menu">
        <li class="menu-arrow">
          <div class="menu-arrow-up"></div>
        </li>
        <li class="dropdown-header">你的账户 <span class="pull-right glyphicons glyphicons-user"></span></li>
        <li>
          <ul class="dropdown-items">
            <li>
              <div class="item-icon"><i class="fa fa-envelope-o"></i> </div>
              <a class="item-message" href="messages.html">消息</a> </li>
            <li>
              <div class="item-icon"><i class="fa fa-calendar"></i> </div>
              <a class="item-message" href="calendar.html">日历</a> </li>
            <li class="border-bottom-none">
              <div class="item-icon"><i class="fa fa-cog"></i> </div>
              <a class="item-message" href="customizer.html">设置</a> </li>
            <li class="padding-none">
              <div class="dropdown-lockout"><i class="fa fa-lock"></i> <a href="screen-lock.html">锁定</a></div>
              <div class="dropdown-signout"><i class="fa fa-sign-out"></i> <a href="login.html">登出</a></div>
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
      <div class="sidebar-toggle"> <i class="fa fa-bars"></i> </div>
    </div>
    <div id="sidebar-menu">
      <ul class="nav sidebar-nav">
        <li class="active"> <a href="publisher_taskman.html"><span class="glyphicons glyphicons-notes_2"></span><span class="sidebar-title">任务管理</span></a> </li>
        <li> <a href="publisher_tasklist_feedback.html"><span class="glyphicons glyphicons-log_book"></span><span class="sidebar-title">反馈管理</span></a> </li>
        <li> <a href="publisher_questionnaire_man.html"><span class="glyphicons glyphicons-more_items"></span><span class="sidebar-title">问卷管理</span></a> </li>		
        <li> <a href="publisher_hireman.html"><span class="glyphicons glyphicons-bullhorn"></span><span class="sidebar-title">招募信息</span></a> </li>
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
      <li><a href="publisher_home.html"><i class="fa fa-home"></i></a></li>
      <li><a href="publisher_home.html">主页</a></li>
      <li><a href="publisher_taskman.html">任务管理</a></li>
      <li class="active">查看任务</li>
    </ol>
  </div>
  <div class="container">
    <div class="row">
      <div class="col-md-12"> </div>
    </div>
    <div class="row">
      <div class="col-md-12">
        <div class="row">
          <div class="col-md-12">
            <div class="panel">
              <div class="panel-heading">
                <div class="panel-title"> <i class="fa fa-tasks"></i> 任务列表 </div>
                <ul class="nav panel-tabs">
                  <li <% if ("0".equals(request.getAttribute("type"))) {%> class="active" <% } %> ><a href="taskLisk.do?type=0&page=1" data-toggle="tab"><i class="fa fa-globe"></i> Web任务</a></li>
                  <li <% if ("1".equals(request.getAttribute("type"))) {%> class="active" <% } %> ><a href="taskLisk.do?type=1&page=1" data-toggle="tab"><i class="fa fa-android"></i> Android任务</a></li>
                  <li <% if ("2".equals(request.getAttribute("type"))) {%> class="active" <% } %> ><a href="taskLisk.do?type=2&page=1" data-toggle="tab"><i class="fa fa-laptop"></i> 桌面任务</a></li>
                </ul>
              </div>
              <div class="panel-body">
                <div class="tab-content padding-none border-none">
                  <div id="tab1" class="tab-pane active">
                    <table class="table table-striped" id="datatable">
                      <thead>
                        <tr>
                          <th></th>
                          <th>项目名称</th>
                          <th class="hidden-xs">评分</th>
                          <th>测试人数</th>
                          <th>当前状态</th>
                          <th style="width: 70px;" class="text-right">操作</th>
                        </tr>
                      </thead>
                      <tbody>
                      <% List<TestTask> list = (List<TestTask>)session.getAttribute("PublisherWebTestTaskByPage"); 
                      request.getSession().removeAttribute("PublisherWebTestTaskByPage");
                      int i=0;
                      for (TestTask testTask : list) { 
                      i++;%>
                      <tr>
                        <input type="hidden" name="taskID" value="<%= testTask.getTaskId() %>">
                          <td class="text-center"><img src="<%= testTask.getProduct().getIcon() %>" width="50" height="50" alt="avatar" /></td>
                          <td class="info"><b><%= testTask.getProduct().getProductName() %></b><br />
                            <span class="text-muted"><i class="fa fa-home"></i> 百度公司</span></td>
                          <td><i class="fa fa-star text-blue"></i> <i class="fa fa-star text-blue"></i> <i class="fa fa-star text-blue"></i> <i class="fa fa-star text-blue"></i> <i class="fa fa-star-o text-blue"></i> 4 </td>
                          <td><i class="fa fa-group fa-lg text-blue padding-right-sm"></i> 500</td>
                          <td><div class="progress">
                              <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 90%"><span class="sr-only">80% Complete</span> </div>
                            </div></td>
                          <td class="text-right text-center"><div class="btn-group">
                              <button type="button" class="btn btn-primary btn-gradient dropdown-toggle" data-toggle="dropdown"> <span class="glyphicons glyphicons-cogwheel"></span> 详细</button>
                              <ul class="dropdown-menu checkbox-persist pull-right text-left" role="menu">
                                <li>
                                <form action="editTask.do" name="close<%=i%>" method="post">
                                <input type="hidden" name="taskID" value="<%= testTask.getTaskId()%>"/>
                                <input type="hidden" name="method" value="submitCloseForm" />
                                </form>
                                  <a href="javascript:void(document.close<%=i%>.submit())">
                                    <i class="fa fa-ban"></i> 关闭 </a>
                                </li>
                                <li>
                                  <a href="publisher_task_edit.html"><i class="fa fa-edit"></i> 修改 </a>
                                </li>
                                <li>
                                  <a><i class="fa fa-level-up"></i> 重启 </a>
                                </li>
                                <li>
                                <form action="bugReportManagement.do" name="bugReport<%=i%>">
                                <input type="hidden" name="method" value="bugReportList" />
                                <input type="hidden" name="taskId" value="<%= testTask.getTaskId() %>" />
                                </form>
                                <a href="javascript:void(document.bugReport<%=i%>.submit())"><i class="fa fa-edit"></i> 反馈管理 </a>
                                </li>
                              </ul>
                            </div></td>
                        </tr>
                      <% } %>
                      </tbody>
                    </table>
                    <div class="text-right">
                    	
                      <ul class="pagination pagination-alt margin-bottom">
                        <li><a href="#"><i class="fa fa-caret-left"></i> </a></li>
                        <li <% if ("1".equals(request.getAttribute("page"))) {%> class="active" <% } %> ><a href="taskList.do?type=<%=request.getAttribute("type") %>&page=1">1</a></li>
                        <li <% if ("2".equals(request.getAttribute("page"))) {%> class="active" <% } %> ><a href="taskList.do?type=<%=request.getAttribute("type") %>&page=2">2</a></li>
                        <li <% if ("3".equals(request.getAttribute("page"))) {%> class="active" <% } %> ><a href="taskList.do?type=<%=request.getAttribute("type") %>&page=3">3</a></li>
                        <li <% if ("4".equals(request.getAttribute("page"))) {%> class="active" <% } %> ><a href="taskList.do?type=<%=request.getAttribute("type") %>&page=4">4</a></li>
                        <li <% if ("5".equals(request.getAttribute("page"))) {%> class="active" <% } %> ><a href="taskList.do?type=<%=request.getAttribute("type") %>&page=5">5</a></li>
                        <li><a href="#"><i class="fa fa-caret-right"></i> </a></li>
                      </ul>
                    
                    </div>
                    
                  </div>
                  <div id="tab2" class="tab-pane chat-panel">
                    <table class="table table-striped" id="datatable">
                      <thead>
                        <tr>
                          <th></th>
                          <th>项目名称</th>
                          <th class="hidden-xs">评分</th>
                          <th>测试人数</th>
                          <th>当前状态</th>
                          <th style="width: 70px;" class="text-right">操作</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td class="text-center"><img src="img/avatars/2.png" width="50" height="50" alt="avatar" /></td>
                          <td class="info"><b> Android百度管家测试</b><br />
                            <span class="text-muted"><i class="fa fa-home"></i> 百度公司</span></td>
                          <td><i class="fa fa-star text-blue"></i> <i class="fa fa-star text-blue"></i> <i class="fa fa-star text-blue"></i> <i class="fa fa-star-half-empty text-blue"></i> <i class="fa fa-star-o text-blue"></i></td>
                          <td><i class="fa fa-group fa-lg text-blue padding-right-sm"></i> 500</td>
                          <td><div class="progress">
                              <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 90%"><span class="sr-only">80% Complete</span> </div>
                            </div></td>
                          <td class="text-right text-center"><div class="btn-group">
                              <button type="button" class="btn btn-primary btn-gradient dropdown-toggle" data-toggle="dropdown"> <span class="glyphicons glyphicons-cogwheel"></span> 详细</button>
                              <ul class="dropdown-menu checkbox-persist pull-right text-left" role="menu">
                                <li><a href="publisher_task_close.html"><i class="fa fa-ban"></i> 关闭 </a></li>
                                <li><a href="publisher_task_edit.html"><i class="fa fa-edit"></i> 修改 </a></li>
                                <li><a><i class="fa fa-level-up"></i> 重启 </a></li>
                              </ul>
                            </div></td>
                        </tr>
                      </tbody>
                    </table>
                    <div class="text-right">
                    	
                      <ul class="pagination pagination-alt margin-bottom">
                        <li><a href="#"><i class="fa fa-caret-left"></i> </a></li>
                        <li><a href="#">1</a></li>
                        <li class="active"><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li><a href="#"><i class="fa fa-caret-right"></i> </a></li>
                      </ul>
                    
                    </div>
                  </div>
                  <div id="tab3" class="tab-pane">
                    <table class="table table-striped" id="datatable">
                      <thead>
                        <tr>
                          <th></th>
                          <th>项目名称</th>
                          <th class="hidden-xs">评分</th>
                          <th>测试人数</th>
                          <th>当前状态</th>
                          <th style="width: 70px;" class="text-right">操作</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td class="text-center"><img src="img/avatars/2.png" width="50" height="50" alt="avatar" /></td>
                          <td class="info"><b> 桌面测试</b><br />
                            <span class="text-muted"><i class="fa fa-home"></i> 百度公司</span></td>
                          <td><i class="fa fa-star text-blue"></i> <i class="fa fa-star text-blue"></i> <i class="fa fa-star text-blue"></i> <i class="fa fa-star-half-empty text-blue"></i> <i class="fa fa-star-o text-blue"></i></td>
                          <td><i class="fa fa-group fa-lg text-blue padding-right-sm"></i> 500</td>
                          <td><div class="progress">
                              <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 90%"><span class="sr-only">80% Complete</span> </div>
                            </div></td>
                          <td class="text-right text-center"><div class="btn-group">
                              <button type="button" class="btn btn-primary btn-gradient dropdown-toggle" data-toggle="dropdown"> <span class="glyphicons glyphicons-cogwheel"></span> 详细</button>
                              <ul class="dropdown-menu checkbox-persist pull-right text-left" role="menu">
                                <li><a href="publisher_task_close.html"><i class="fa fa-ban"></i> 关闭 </a></li>
                                <li><a href="publisher_task_edit.html"><i class="fa fa-edit"></i> 修改 </a></li>
                                <li><a><i class="fa fa-level-up"></i> 重启 </a></li>
                              </ul>
                            </div></td>
                        </tr>
                      </tbody>
                    </table>
                    <div class="text-right">
                    	
                      <ul class="pagination pagination-alt margin-bottom">
                        <li><a href="#"><i class="fa fa-caret-left"></i> </a></li>
                        <li><a href="#">1</a></li>
                        <li class="active"><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li><a href="#"><i class="fa fa-caret-right"></i> </a></li>
                      </ul>
                    
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!--End: col-md-12--> 
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

<!-- Plugins - Via CDN --> 
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="vendor/plugins/datatables/js/datatables.js"></script> 
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/flot/0.8.1/jquery.flot.min.js"></script> 
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery-sparklines/2.1.2/jquery.sparkline.min.js"></script> 
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/fullcalendar/1.6.4/fullcalendar.min.js"></script> 

<!-- Plugins - Via Local Storage
<script type="text/javascript" src="vendor/plugins/jqueryflot/jquery.flot.min"></script>
<script type="text/javascript" src="vendor/plugins/sparkline/jquery.sparkline.min.js"></script>
<script type="text/javascript" src="vendor/plugins/datatables/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="vendor/plugins/calendar/fullcalendar.min.js"></script>
--> 

<!-- Plugins --> 
<script type="text/javascript" src="vendor/plugins/calendar/gcal.js"></script><!-- Calendar Addon --> 
<script type="text/javascript" src="vendor/plugins/jqueryflot/jquery.flot.resize.min.js"></script><!-- Flot Charts Addon --> 
<script type="text/javascript" src="vendor/plugins/datatables/js/datatables.js"></script><!-- Datatable Bootstrap Addon --> 
<script type="text/javascript" src="vendor/plugins/chosen/chosen.jquery.min.js"></script>

<!-- Theme Javascript --> 
<script type="text/javascript" src="js/uniform.min.js"></script> 
<script type="text/javascript" src="js/main.js"></script> 
<script type="text/javascript" src="js/custom.js"></script> 
<script type="text/javascript">
jQuery(document).ready(function () {

	// Init Theme Core   
	Core.init();
	

	
	// Init Calendar Plugin
	var runFullCalendar = function () {

		var date = new Date();
		var d = date.getDate();
		var m = date.getMonth();
		var y = date.getFullYear();

		$('#calendar').fullCalendar({
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek,agendaDay'
			},
			editable: true,
			events: [{
				title: 'Business Event',
				start: new Date(y, m, 3),
				end: new Date(y, m, 6),
				color: '#428bca'
			}, {
				title: 'Thanksgiving Party',
				start: new Date(y, m, 14),
				end: new Date(y, m, 16),
				color: '#6DB54B'
			}, {
				title: 'Birthday Weekend',
				start: new Date(y, m, 25),
				end: new Date(y, m, 29)
			}]
		});

	}
	

	// Init Flot Charts Plugin
	var runFlotCharts = function () {

		//define chart clolors ( add more colors if you want or flot will do it automatically )
		var chartColours = ['#62aeef', '#d8605f', '#72c380', '#6f7a8a', '#f7cb38', '#5a8022', '#2c7282'];

		//generate random number for charts
		randNum = function () {
			return (Math.floor(Math.random() * (1 + 40 - 20))) + 20;
		}

		//check if element exist and draw auto updating chart
		if ($(".chart-updating").length) {
			$(function () {
				// we use an inline data source in the example, usually data would
				// be fetched from a server
				var data = [],
					totalPoints = 50;

				function getRandomData() {
					if (data.length > 0)
						data = data.slice(1);

					// do a random walk
					while (data.length < totalPoints) {
						var prev = data.length > 0 ? data[data.length - 1] : 50;
						var y = prev + Math.random() * 10 - 5;
						if (y < 0)
							y = 0;
						if (y > 100)
							y = 100;
						data.push(y);
					}

					// zip the generated y values with the x values
					var res = [];
					for (var i = 0; i < data.length; ++i)
						res.push([i, data[i]])
					return res;
				}

				// Update interval
				var updateInterval = 250;

				// setup plot
				var options = {
					series: {
						shadowSize: 0, // drawing is faster without shadows
						lines: {
							show: true,
							fill: true,
							lineWidth: 2,
							steps: false
						},
						points: {
							show: true,
							radius: 2.8,
							symbol: "circle",
							lineWidth: 2.5
						}
					},
					grid: {
						show: true,
						aboveData: false,
						color: "#3f3f3f",
						labelMargin: 5,
						axisMargin: 0,
						borderWidth: 0,
						borderColor: null,
						minBorderMargin: 5,
						clickable: true,
						hoverable: true,
						autoHighlight: false,
						mouseActiveRadius: 20
					},
					colors: chartColours,
					tooltip: true, //activate tooltip
					tooltipOpts: {
						content: "Value is : %y.0",
						shifts: {
							x: -30,
							y: -50
						}
					},
					yaxis: {
						min: 0,
						max: 100
					},
					xaxis: {
						show: true
					}
				};
				var plot = $.plot($(".chart-updating"), [getRandomData()], options);

				function update() {
					plot.setData([getRandomData()]);
					// since the axes don't change, we don't need to call plot.setupGrid()
					plot.draw();

					setTimeout(update, updateInterval);
				}

				update();
			});
		}
	}

	runFullCalendar();
	runFlotCharts();
	
	// Init Datatables
	$('#datatable, #datatable_2, #datatable_3').dataTable( {
	  "bSort": true,
	  "bPaginate": false,
	  "bLengthChange": false,
	  "bFilter": false,
	  "bInfo": false,
	  "bAutoWidth": false,
	  "aoColumnDefs": [{ 'bSortable': false, 'aTargets': [ -1 ] }]
	});

});
</script>
</body>
</html>
