<%@ page language="java" import="java.util.*,cn.com.crowdsourcedtesting.modelhelper.*,cn.com.crowdsourcedtesting.bean.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE html>
<!--[if IE 7]> <html lang="en" class="ie7"> <![endif]-->  
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->  
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->  
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->  
<html:html lang="true">
  <head>
    <html:base />
    
    <title>TCTEST</title>

    <!-- Meta -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="description" content="" />
    <meta name="author" content="rain" />


	<!-- date picker-->'
    <link rel="stylesheet" href="assets/js/lib/themes/default.css" id="theme_base">
    <link rel="stylesheet" href="assets/js/lib/themes/default.date.css" id="theme_date">
    <link rel="stylesheet" href="assets/js/lib/themes/default.time.css" id="theme_time">
    <!-- CSS Global Compulsory-->
    <link rel="stylesheet" href="assets/plugins/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="assets/css/style.css" />
    <link rel="stylesheet" href="assets/css/headers/header1.css" />
    <link rel="stylesheet" href="assets/plugins/bootstrap/css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="assets/css/style_responsive.css" />
    <link rel="shortcut icon" href="favicon.ico" />        
    <!-- CSS Implementing Plugins -->    
    <link rel="stylesheet" href="assets/plugins/font-awesome/css/font-awesome.css" />
    <link rel="stylesheet" href="assets/plugins/flexslider/flexslider.css" type="text/css" media="screen" />          
    <!-- CSS Theme -->    
    <link rel="stylesheet" href="assets/css/themes/default.css" id="style_color" />
    <link rel="stylesheet" href="assets/css/themes/headers/default.css" id="style_color-header-1" />    
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
 <%
 	UserType userType = (UserType)session.getAttribute("UserType");
	Tester tester  = (Tester)session.getAttribute("Tester");
	if(tester == null)
	{
		response.sendRedirect("security.do?method=goToLogin");
		return;
	}
 %>
<body>
<!--=== Style Switcher ===-->    
<i class="style-switcher-btn style-switcher-btn-option icon-cogs"></i>
<div class="style-switcher style-switcher-inner">
    <div class="theme-close"><i class="icon-remove"></i></div>
    <div class="theme-heading">主题颜色</div>
    <ul class="unstyled">
        <li class="theme-default theme-active" data-style="default" data-header="dark"></li>
        <li class="theme-blue" data-style="blue" data-header="dark"></li>
        <li class="theme-orange" data-style="orange" data-header="dark"></li>
        <li class="theme-red" data-style="red" data-header="dark"></li>
        <li class="theme-light" data-style="light" data-header="dark"></li>
    </ul>
</div><!--/style-switcher-->
<!--=== End Style Switcher ===-->    

<!--=== Top ===-->    
<div class="top">
    <div class="container">			        
        <div class="row-fluid">
            <ul class="loginbar inline">
                <li><a href="mailto:info@anybiz.com"><i class="icon-envelope-alt"></i> chengran327@gmail.com</a></li>	
                <li><a><i class="icon-phone-sign"></i> 021 4202 2656</a></li>	
                <li><a href="security.do?method=testerLogout"><i class="icon-user"></i>注销</a></li>
                <li><%=tester.getTesterName()%></li>	
            </ul>
        </div>        				
    </div><!--/container-->		
</div><!--/top-->
<!--=== End Top ===-->    

<!--=== Header ===-->
<div class="header">               
    <div class="container"> 
        <!-- Logo -->       
        <div class="logo">                                             
            <a href="index.html"><img id="logo-header" src="assets/img/logo2-default.png" alt="Logo" /></a>
        </div><!-- /logo -->        
                                    
        <!-- Menu -->       
        <div class="navbar">                                
            <div class="navbar-inner">                                  
                <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a><!-- /nav-collapse -->                                  
                <div class="nav-collapse collapse">                                     
                    <ul class="nav">
                        <li class="active">
                           <a href="index.jsp">主页
                            
                            </a>
                           
                      </li>
                        <li>
                            <a href="gifts.do?method=selectAllGifts">礼品中心
                                                        
                            </a>
                                       
                        </li>
                        <li>
                            <a href="page_list.html">任务广场                            
                            </a>
                        </li>
                        <li>
                            <a href="recruitment.do?method=selectAllRecruitment">招募帖                          
                            </a>
                        </li>
                        <li>
                            <a href="page_clients.html">合作伙伴</a>
      
                        </li>
                       <li>
                            <a href="questionnaire.do?method=pageQuestionnaire">问卷调查
                            </a>
                            
                                                    
                        </li>
                        <li><a class="search search-nav"><i class="icon-search search-btn"></i></a></li>                                
                    </ul>
                    <div class="search-open search-open-inner">
                        <div class="input-append">
                            <form />
                                <input type="text" class="span3" placeholder="搜索" />
                                <button type="submit" class="btn-u">搜索</button>
                            </form>
                        </div>
                    </div>
                </div><!-- /nav-collapse -->                                
            </div><!-- /navbar-inner -->
        </div><!-- /navbar -->                          
    </div><!-- /container -->               
</div><!--/header -->      
<!--=== End Header ===-->

<!--=== Breadcrumbs ===-->
<div class="row-fluid breadcrumbs margin-bottom-40">
	<div class="container">
        <h1 class="pull-left">个人中心</h1>
        <ul class="pull-right breadcrumb">
            <li><a href="index.html">主页</a> <span class="divider">/</span></li>
            <li class="active">个人中心</li>
        </ul>
    </div><!--/container-->
</div><!--/breadcrumbs-->
<!--=== End Breadcrumbs ===-->

<!--=== Content Part ===-->
<div class="container">		
	<div class="row-fluid margin-bottom-30">
    	<div class="span3 thumbnails team">
        <div class="headline"><h3>个人信息</h3></div>
           <div class="thumbnail-style">
                <img src="assets/img/others/6.jpg" alt="" />
                <h3><a><%=tester.getTesterName() %></a> <small>资深会员</small></h3>
                做任务领奖励，前往<a class="text-success">这里</a>开始您的任务之旅
                <ul class="unstyled inline team">
                	<li><a href="#"><i class="icon-star"></i> 50 </a></li>
                	<li><a href="#"><i class="icon-trophy"></i> 10 </a></li>
                	<li><a href="#"><i class="icon-money"></i> 2 </a></li>
                </ul>
                
            </div>
        </div>
    	<div class="span9">
        <div class="headline"><h3>资料修改</h3>
        </div>
        	<p class="hero">认真填写以下资料是你加入众测的第一步，方便体验更多乐趣。</p>
        	<form action="security.do?method=testerChangeInformation" method="post">
            <table class="table table-bordered">
            <thead>
            <tr>
            	<th width="30%" style="border-top: 2px solid #E5E5E5;"></th>
                <th style="border-top: 2px solid #E5E5E5;">信息</th>
            </tr>
            </thead>
            <tbody>
            <tr class="success">
            	<td><strong>登录邮箱</strong></td>
                <td><%=tester.getTesterEmail() %></td>
            </tr>
            <tr >
            	<td><strong>生日</strong></td>
                <td><input id="" class="fieldset__input js__datepicker" type=text placeholder="选择日期"></td>
            </tr>
            <tr>
            	<td><strong>昵称</strong></td>
                <td><input class="input-xlarge" type="text" name="name" value="<%=tester.getTesterName() %>" /></td>
            </tr>
            <tr>
            	<td><strong>原密码</strong></td>
                <td><input class="input-xlarge" readonly="readonly" type="text" value="<%=tester.getTesterPassword() %>"/></td>
            </tr>
            <tr>
            	<td><strong>新密码</strong></td>
                <td><input id="newPassword" type="password" name="password" value="" required onblur="checkPass();"/>
                	<span class="text-error" id="nonempty1" style="display:none;">字段不能为空</span>
                </td>
            </tr>
            <tr>
            	<td><strong>确认密码</strong></td>
                <td><input id="newPassword_check" name="password_comfirm" type="password" value="" required onblur="checkVcode();"/>
                <span class="text-error" id="nonempty2" style="display:none;">字段不能为空</span>
                <span class="text-error" id="errorpwd" style="display:none;">两次输入密码不一致</span>
                
                </td>
            </tr>
            </tbody>
            </table>
			<div class="text-center">
            	<button class="btn-u" id="comfirm" type="submit" >确认</button>
            </div><!--end of div submit-->
            <input type="text" name="email" value=<%=tester.getTesterEmail() %> style="display:none;"/>
            </form>
        </div><!--end of div-9-->
    </div><!--/row-fluid-->


</div><!--/container-->		
<!--=== End Content Part ===-->

<!--=== Footer ===-->
<div class="footer">
	<div class="container">
		<div class="row-fluid">
			<div class="span4">
                <!-- About -->
		        <div class="headline"><h3>关于</h3></div>	
				<p class="margin-bottom-25">TCTest全名为吐槽测试网的英文，该网站致力于为公司打造一个第三方测试团队，为大众创建一个吐槽平台，为你喜欢的软件提出重要的改进意见。</p>	

				
			</div><!--/span4-->	
			
			<div class="span4">
            <!-- Monthly Newsletter -->
		        <div class="headline"><h3>联系我们</h3></div>	
                <address>
					4800号，曹安公路，同济大学软件学院 <br />
					上海市, 中国 <br />
					电话: 131 6293 7287 <br />
					传真: 800 123 3456 <br />
					Email: <a href="mailto:info@anybiz.com" class="">chengran327@gmail.com</a>
                </address>
			</div><!--/span4-->

			<div class="span4">
	

                <!-- Stay Connected -->
		        <div class="headline">
		          <h3>关注我们</h3></div>	
                <ul class="social-icons">
                    <li><a href="#" data-original-title="Feed" class="social_rss"></a></li>
                    <li><a href="#" data-original-title="Facebook" class="social_picasa"></a></li>
                    <li><a href="#" data-original-title="Twitter" class="social_twitter"></a></li>
                    <li><a href="#" data-original-title="Goole Plus" class="social_tumblr"></a></li>
                    <li><a href="#" data-original-title="Pinterest" class="social_pintrest"></a></li>
                    <li><a href="#" data-original-title="Linkedin" class="social_linkedin"></a></li>
                    <li><a href="#" data-original-title="Vimeo" class="social_vimeo"></a></li>
                </ul>
			</div><!--/span4-->
		</div><!--/row-fluid-->	
	</div><!--/container-->	
</div><!--/footer-->	
<!--=== End Footer ===-->

<!--=== Copyright ===-->
<div class="copyright">
	<div class="container">
		<div class="row-fluid">
			<div class="span7">						
	            <p>Copyright &copy; 2014.TCtest All rights reserved.</p>
			</div>
			<div class="span4">	
                <a href="index.html"><img id="logo-footer" src="assets/img/logo2-default.png" class="pull-right" alt="" /></a>
			</div>
		</div><!--/row-fluid-->
	</div><!--/container-->	
</div><!--/copyright-->	
<!--=== End Copyright ===-->

<!-- JS Global Compulsory -->           
<script type="text/javascript" src="assets/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="assets/js/modernizr.custom.js"></script>       
<script type="text/javascript" src="assets/js/Date.js"></script>  
<script type="text/javascript" src="assets/plugins/bootstrap/js/bootstrap.min.js"></script> 
<!-- JS Implementing Plugins -->           
<script type="text/javascript" src="assets/plugins/flexslider/jquery.flexslider-min.js"></script>
<script type="text/javascript" src="assets/plugins/back-to-top.js"></script>
<!-- JS Page Level --> 
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script>window.jQuery||document.write('<script src="tests/jquery.2.0.0.js"><\/script>')</script>
<script src="assets/js/lib/picker.js"></script>
<script src="assets/js/lib/picker.date.js"></script>
<script src="assets/js/lib/picker.time.js"></script>
<script src="assets/js/lib/legacy.js"></script>
<script src="assets/js/demo/scripts/demo.js"></script>
<script src="assets/js/demo/scripts/rainbow.js"></script>         
<script type="text/javascript" src="assets/js/app.js"></script>
<script type="text/javascript">
    jQuery(document).ready(function() {
        App.init();
        App.initSliders();
		$(document).ready(function() { 
			$('.datepicker').pickadate({
				monthsFull: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
				weekdaysShort: ['周一', '周二', '周三', '周四', '周五', '周六', '周日'],
				today: '确认',
				clear: '清除',
				formatSubmit: 'yyyy/mm/dd'
			})
});          
    });
    function checkVcode(){
    	var pwd1=document.getElementById("newPassword").value;
    	var pwd2=document.getElementById("newPassword_check").value;
    	if(pwd1 == "")
    	 {
    		document.getElementById("nonempty1").style.display = "block";
    		return false;
    	 }
    	 else
    	 {
    	 	document.getElementById("nonempty1").style.display = "none";
    	 }
    	if(pwd2 == "")
    	 {
    		 document.getElementById("nonempty2").style.display = "block";
    		 return false;
    	 }
    	 else
    	 {
    	 	document.getElementById("nonempty2").style.display = "none";
    	 }
    	if(pwd1!=pwd2){
    	    document.getElementById("nonempty1").style.display = "none";
    	    document.getElementById("nonempty2").style.display = "none";
    	    document.getElementById("errorpwd").style.display = "block";

    	}


    	 else{
    	   	document.getElementById("errorpwd").style.display = "none";
    	    document.getElementById("nonempty1").style.display = "none";
    	    document.getElementById("nonempty2").style.display = "none";



    	 }
    if(pwd2 == "")
     {
    	 document.getElementById("nonempty2").style.display = "block";
    	 return false;
    }
    else{
    	document.getElementById("nonempty2").style.display = "none";
    	if(checkAllEmpty()){
    		document.getElementById("confirm").disabled="";
    	}
        return true;
    	}
    }
    function checkAllEmpty(){
      var pwd1=document.getElementById("newPassword").value;
      var pwd2=document.getElementById("newPassword_check").value;
     
      if((pwd1&&pwd2)!=""){
    	  return true;
      }
      else{
      	return false;
      }
    }

    function checkPass(){
      var pwd1=document.getElementById("newPassword").value;
      var pwd2=document.getElementById("newPassword_check").value;
      
     if(pwd1 == "")
     {
    	document.getElementById("nonempty1").style.display = "block";
    	return false;
     }
     else
     {
     	document.getElementById("nonempty1").style.display = "none";
     }
    if(pwd2 == "")
     {
    	 document.getElementById("nonempty2").style.display = "block";
    	 return false;
     }
     else
     {
     	document.getElementById("nonempty2").style.display = "none";
     }
    if(pwd1!=pwd2){
    	document.getElementById("nonempty1").style.display = "none";
    	document.getElementById("nonempty2").style.display = "none";
        document.getElementById("errorpwd").style.display = "block";
        return false;
     }


     else{
    	document.getElementById("errorpwd").style.display = "none";
    	document.getElementById("nonempty1").style.display = "none";
    	document.getElementById("nonempty2").style.display = "none";


        return true;
    	}
    }    
</script>
<!--[if lt IE 9]>
    <script src="assets/js/respond.js"></script>
<![endif]-->
</body>
</html:html>
