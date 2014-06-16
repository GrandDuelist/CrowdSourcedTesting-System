<%@ page language="java" import="java.util.*,cn.com.crowdsourcedtesting.bean.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
/* try{ */
    String isLegal=(String)request.getAttribute("isLegal");
    String modify = (String) request.getAttribute("modify");
     String type=(String)request.getAttribute("publisherType");
    if(isLegal==null||!isLegal.equals("true")||type==null){
     response.sendRedirect("information.do?method=managePublisherList");
     return; 
 }else{
    request.removeAttribute("isLegal");
    request.removeAttribute("publisherType");
    request.removeAttribute("modify");
 }
 Publisher publisher = (Publisher)request.getAttribute("publisher");

 
 if(publisher==null)
 {
    if(type.equals("Company"))response.sendRedirect("information.do?method=managePublisherList");
    else response.sendRedirect("information.do?method=managePersonList");
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
<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Open+Sans:400,600,700" />

<!-- Core CSS  -->
<link rel="stylesheet" type="text/css" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css" href="fonts/glyphicons_pro/glyphicons.min.css" />

<!-- Plugin CSS -->
<link rel="stylesheet" type="text/css" href="vendor/editors/xeditable/css/bootstrap-editable.css" />
<link rel="stylesheet" type="text/css" href="vendor/editors/xeditable/inputs/address/address.css" />
<link rel="stylesheet" type="text/css" href="vendor/editors/xeditable/inputs/typeaheadjs/lib/typeahead.js-bootstrap.css" />
<link rel="stylesheet" type="text/css" href="vendor/plugins/daterange/daterangepicker-bs3.css" />

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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/detail_control/admin_publisher.js" > </script>

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
        <li> <a class="accordion-toggle collapsed" href="#examine"><span class="glyphicons glyphicons-check"></span><span class="sidebar-title">审核</span><span class="caret"></span></a>
          <ul id="examine" class="nav sub-nav">
            <li><a href="admin_tasklist.html"><span class="glyphicons glyphicons glyphicons-flag"></span> 审核任务</a></li>
            <li><a href="admin_queslist.html"><span class="glyphicons glyphicons-list"></span> 审核问卷</a></li>
            <li><a href="admin_registerlist.html"><span class="glyphicons glyphicons-user"></span> 审核发布者帐号</a></li>
          </ul>
        </li>
        <li class="active"> <a class="accordion-toggle collapsed" href="#user_admin"><span class="glyphicons glyphicons-adress_book"></span><span class="sidebar-title">用户管理</span><span class="caret"></span></a>
          <ul id="user_admin" class="nav sub-nav">
            <li><a href="admin_testerlist.html"><span class="glyphicons glyphicons-cleaning"></span> 维护测试者信息</a></li>
            <li class="active"><a href="admin_publisherlist.html"><span class="glyphicons glyphicons-lightbulb"></span> 维护发布者信息</a></li>
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
          <li><a href="admin_home.html"><i class="fa fa-home"></i></a></li>
      <li><a href="admin_home.html">主页</a></li>
      <li><a href="admin_publisherlist.html">发布者列表</a></li>
      <li class="active">详细信息</li>
      </ol>
    </div>
    <div class="container">
      <div class="row">
        <div class="col-md-8 col-md-offset-2">
          <div class="panel">
            <div class="panel-heading">
              <div class="panel-title"> <i class="fa fa-pencil"></i> 编辑信息 </div>
              <div class="panel-btns pull-right">
                <label style="display: inline-block; margin-right: 15px; font-size: 12px; color: #888888;">
               	 <form id="informationForm" method="post">
                 <input name="status" type="checkbox" class="checkbox" id="autoopen" style="vertical-align: baseline" />
                  &nbsp;<%=publisher.getPublisherAuthority()?"冻结":"解冻" %>
                 <input type="hidden" name="username" />
                 <input type="hidden" name="license"/>
                 <input type="hidden" name="credit"/>
                 <input type="hidden" name="company"/>
                 <input type="hidden" name="publisherType"/>
                 <input type="hidden" name="id" value="<%=publisher.getPublisherId()%>"/>
                </form>
                 </label>
                <button id="enable" class="btn btn-default btn-gradient">启用 / 关闭</button>
              </div>
            </div>
            <div class="panel-body">
            <%if(modify==null){ %>
              <div class="alert alert-success">编辑字段不能为空，请检查您的输入： <b>昵称</b> 是否符合条件</div>
              <%}else if("success".equals(modify)){ %>
              <div class="alert alert-success">修改成功!!</div>
              <%}else { %>
              <div class="alert alert-success">操作失败!!请重新尝试!</div>
              <% }%>
              <table id="user" class="table table-bordered table-striped" style="clear: both">
                <tbody>
                <tr>
                    <td style="width: 35%;"><b>头像</b></td>
                    <td class="text-center"><img src="<%=publisher.getPublisherPhoto()%>" width="50" height="50" /></td>
                  </tr>
                  <tr>
                    <td style="width: 35%;"><strong>昵称</strong></td>
                    <td style="width: 65%;"><a href="#" id="username" data-type="text" data-pk="1" data-title="输入昵称" class="editable editable-click"><%=publisher.getPublisherName() %></a></td>
                  </tr>
                  <tr>
                    <td style="width: 35%;"><strong>公司名称</strong></td>
                    <td style="width: 65%;"><a href="#" id="company" data-type="text" data-pk="1" data-title="输入名称" class="editable editable-click"><%=publisher.getPublisherCompany()==null?"无":publisher.getPublisherCompany()%></a></td>
                  </tr>
                  <tr>
                    <td><b>邮箱</b></td>
                    <td><a id="email" data-type="text" data-pk="1" data-placement="right" data-placeholder="Required" ><%=publisher.getPublisherLogEmail() %></a></td>
                  </tr>
                  <%if("Company".equals(type)){ %>
                  <tr>
                    <td><b>发布问卷数</b></td>
                    <td><a id="questionnaire" data-type="text" data-pk="1" data-placement="right" data-placeholder="Required" ><%=publisher.getQuestionnaires().size() %></a></td>
                  </tr>
                  <tr>
                    <td><b>招募信息数</b></td>
                    <td><a id="questionnaire" data-type="text" data-pk="1" data-placement="right" data-placeholder="Required" ><%=publisher.getRecruitments().size() %></a></td>
                  </tr>
                  <%} %>
                   <tr>
                    <td><b>当前状态</b></td>
                    <td><a id="stat" data-type="text" data-pk="1" data-placement="right" data-placeholder="Required"><%=publisher.getPublisherAuthority()?"可用":"冻结"%></a></td>
                  </tr>
                   <tr>
                    <td><b>测试产品数</b></td>
                    <td><a id="product"  data-type="text" data-pk="1" data-placement="right" data-placeholder="Required"><%=publisher.getQuestionnaires().size() %></a></td>
                  </tr>
                  
                  <%if(publisher.getPublisherType()) {%>
                  <tr>
                    <td><b>营业执照</b></td>
                    <td><a href="#" id="license"  data-type="text" data-pk="1" data-title="输入营业执照" class="editable editable-click"><%=publisher.getBusinessLicense()==null?"无":publisher.getBusinessLicense()%></a></td>
                  </tr>
                  <%} %>
                  <tr>
                    <td><strong>当前积分</strong></td>
                    <td><a href="#" id="credit"  data-type="text" data-title="修改积分" data-pk="1" class="editable editable-click"><%=publisher.getPublisherCredit() %></a></td>
                  </tr>
                </tbody>
              </table>
            </div>
            <div class="text-center"><button  class="btn btn-primary btn-gradient" data-toggle="modal" data-target="#submitAlert"> 提交 </button></div>
          <hr></div>
          </div>
          
        </div>
      </div>
    </div>
  </section>
  <!-- End: Content --> 
</div>
<!-- End: Main --> 
<!--Popup-->
<div class="modal fade" id="submitAlert" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog modal-dialog-sm">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title text-center">确认修改?</h4>
      </div>
      <div class="modal-body">
        <p class="margin-bottom-lg"> 确认提交后将会在数据库修改您的数据，是否确认？ </p>
        <div class="form-group text-center">
          <button type="button" class="btn btn-success btn-gradient margin-right-sm" data-dismiss="modal" id="<%="Company".equals(type)?"sureButton":"sureButton2" %>"><i class="fa fa-check"></i> 确认</button>
          <button type="button" class="btn btn-danger btn-gradient" data-dismiss="modal" ><i class="fa fa-warning"></i> 取消</button>
        </div>
      </div>
    </div>
  </div>
</div>
<!--End:Popup-->
<!-- Core Javascript - via CDN --> 
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script> 
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script> 



<!-- Plugins --> 
<script type="text/javascript" src="vendor/editors/xeditable/js/bootstrap-editable.js"></script> 
<script type="text/javascript" src="vendor/editors/xeditable/inputs/address/address.js"></script> 
<script type="text/javascript" src="vendor/editors/xeditable/inputs/typeaheadjs/lib/typeahead.js"></script> 
<script type="text/javascript" src="vendor/editors/xeditable/inputs/typeaheadjs/typeaheadjs.js"></script> 
<script type="text/javascript" src="vendor/plugins/daterange/moment.min.js"></script> 
<script type="text/javascript" src="vendor/plugins/daterange/daterangepicker.js"></script> 
<script type="text/javascript" src="vendor/plugins/datepicker/bootstrap-datepicker.js"></script> 

<!-- Theme Javascript --> 
<script type="text/javascript" src="js/uniform.min.js"></script> 
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/custom.js"></script> 
<script type="text/javascript">
 jQuery(document).ready(function() {

	  // Init Theme Core	
	  Core.init();

	  //enable / disable xedit
	  $('#enable').click(function() {
		 $('#user .editable').editable('toggleDisabled');
	  });    
	  
	  //editables 
	  $('#username').editable({
			 type: 'text',
			 pk: 1,
			 name: 'username',
			 title: 'Enter username'
	  });
	  
	  $('#firstname').editable({
		  validate: function(value) {
			 if($.trim(value) == '') return 'This field is required';
		  }
	  });
	  
	  $('#sex').editable({
		  prepend: "not selected",
		  source: [
			  {value: 1, text: 'Male'},
			  {value: 2, text: 'Female'}
		  ],
		  display: function(value, sourceData) {
			   var colors = {"": "gray", 1: "green", 2: "blue"},
				   elem = $.grep(sourceData, function(o){return o.value == value;});
				   
			   if(elem.length) {    
				   $(this).text(elem[0].text).css("color", colors[value]); 
			   } else {
				   $(this).empty(); 
			   }
		  }   
	  });    
	  
	  $('#status').editable();   
	  
	  $('#group').editable({
		 showbuttons: false 
	  });   
  
	  $('#vacation').editable({
		  datepicker: { todayBtn: 'linked' } 
	  });  
		  
	  $('#dob').editable();
			
	  $('#event').editable({
		  placement: 'right',
		  combodate: {
			  firstItem: 'name'
		  }
	  });      
	  
	  $('#meeting_start').editable({
		  format: 'yyyy-mm-dd hh:ii',    
		  viewformat: 'dd/mm/yyyy hh:ii',
		  validate: function(v) {
			 if(v && v.getDate() == 10) return 'Day cant be 10!';
		  },
		  datetimepicker: {
			 todayBtn: 'linked',
			 weekStart: 1
		  }        
	  });            
	  
	  $('#comments').editable({
		  showbuttons: 'bottom'
	  }); 
	  
	  $('#note').editable(); 
	  $('#pencil').click(function(e) {
		  e.stopPropagation();
		  e.preventDefault();
		  $('#note').editable('toggle');
	 });   
	 
	  $('#state').editable({
		  source: ["Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Dakota","North Carolina","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"]
	  }); 
	  
	  $('#state2').editable({
		  value: 'California',
		  typeahead: {
			  name: 'state',
			  local: ["Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Dakota","North Carolina","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"]
		  }
	  });   
	 
	 $('#fruits').editable({
		 pk: 1,
		 limit: 3,
		 source: [
		  {value: 1, text: 'banana'},
		  {value: 2, text: 'peach'},
		  {value: 3, text: 'apple'},
		  {value: 4, text: 'watermelon'},
		  {value: 5, text: 'orange'}
		 ]
	  }); 
	  
	  $('#address').editable({
		  url: '/post',
		  value: {
			  city: "Moscow", 
			  street: "Lenina", 
			  building: "12"
		  },
		  validate: function(value) {
			  if(value.city == '') return 'city is required!'; 
		  },
		  display: function(value) {
			  if(!value) {
				  $(this).empty();
				  return; 
			  }
			  var html = '<b>' + $('<div>').text(value.city).html() + '</b>, ' + $('<div>').text(value.street).html() + ' st., bld. ' + $('<div>').text(value.building).html();
			  $(this).html(html); 
		  }         
	  });              
		   
	 $('#user .editable').on('hidden', function(e, reason){
		  if(reason === 'save' || reason === 'nochange') {
			  var $next = $(this).closest('tr').next().find('.editable');
			  if($('#autoopen').is(':checked')) {
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
<%/* }catch(NullPointerException e){
 
  return;
}catch(Exception e)
{
  return;
} */
%>
