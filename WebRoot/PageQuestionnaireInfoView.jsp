<%@ page language="java" import="java.util.*,cn.com.crowdsourcedtesting.bean.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
    <title>TCTEST</title>

    <!-- Meta -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="description" content="" />
    <meta name="author" content="" />

    <!-- CSS Global Compulsory-->
    <link rel="stylesheet" href="assets/plugins/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="assets/css/style.css" />
    <link rel="stylesheet" href="assets/css/headers/header1.css" />
    <link rel="stylesheet" href="assets/plugins/bootstrap/css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="assets/css/style_responsive.css" />
    <link rel="shortcut icon" href="favicon.ico" />        
    <!-- CSS Implementing Plugins -->    
    <link rel="stylesheet" href="assets/plugins/font-awesome/css/font-awesome.css" />
    <!-- CSS Theme -->    
    <link rel="stylesheet" href="assets/css/themes/default.css" id="style_color" />
    <link rel="stylesheet" href="assets/css/themes/headers/default.css" id="style_color-header-1" />  
    <script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/detail_control/page_questionnaire_detail.js"></script>  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head> 

<body>
<% Questionnaire questionnaire   =  (Questionnaire)session.getAttribute("questionnaire");
   String hasjoined = (String) session.getAttribute("hasJoined");
%>
<!--=== Style Switcher ===-->

 <form id="idForm"  method="post">
 <input type="hidden" name="subType"/>
 <input type="hidden"   name="id" value="<%=questionnaire.getQuestionnaireId()%>">
</form>    
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
                <li><a href="page_login.html"><i class="icon-user"></i> 登录</a></li>	
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
                        <li>
                           <a href="index.html">主页
                            
                            </a>
                           
                      </li>
                        <li>
                            <a href="gifts.html">礼品中心
                                                        
                            </a>
                                       
                        </li>
                        <li>
                            <a href="page_list.html">任务广场                            
                            </a>
                        </li>
                        <li>
                            <a href="page_hirelist.html">招募帖                          
                            </a>
                        </li>
                        <li>
                            <a href="page_clients.html">合作伙伴</a>
      
                        </li>
                       <li class="active">
                            <a href="page_questionaire.html">问卷调查
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
<div class="breadcrumbs margin-bottom-20">
	<div class="container">
        <h1 class="color-green pull-left">问卷内容</h1>
        <ul class="pull-right breadcrumb">
            <li><a href="index.html">主页</a> <span class="divider">/</span></li>
            <li><a href="page_questionaire.html">问卷列表</a> <span class="divider">/</span></li>
            <li class="active">问卷内容</li>
        </ul>
    </div><!--/container-->
</div><!--/breadcrumbs-->
<!--=== End Breadcrumbs ===-->

<!--=== Content Part ===-->
<div class="container">		
	<div class="row-fluid">
     
    	<div class="span9">
        <div class="alert alert-success alert-block">
            <button data-dismiss="alert" class="close" type="button">×</button>
            
          <%if(hasjoined==null||hasjoined.equals("false")){ %>
          
           <h4>填写问卷</h4>
                 您的宝贵意见能够帮助我们更好的改进产品。<strong>谢谢您的配合</strong>
        </div> 
        	<div class="headline"><%=questionnaire.getTitle() %></h3></div>
            <div class="clients-page margin-bottom-20">
                       
                <p>请大家对问卷进行认真填写，我们对于问卷有积分奖励，积分奖励可以用来换取相应的礼品。谢谢大家的合作，也可以访问我们的主页<a href="www。tctest。com">www.tctest.com。</a></p>
            </div>
          <%}else{ %>
            <h4>问卷提交成功</h4>
               问卷已经提交成功，我们会在近期进行审核和处理，审核成功后您将会获得我们提供给您的积分。<strong>谢谢您的配合</strong>
        </div> 
        	<div class="headline"><%=questionnaire.getTitle() %></h3></div>
            <div class="clients-page margin-bottom-20">
                       
                <p>请大家对问卷进行认真填写，我们对于问卷有积分奖励，积分奖励可以用来换取相应的礼品。谢谢大家的合作，也可以访问我们的主页<a href="www。tctest。com">www.tctest.com。</a></p>
            </div>
            <%} %>
            <%
            
             Iterator it =  questionnaire.getQuestions().iterator();
             int i=1;
             while(it.hasNext()) {
             Question  question =  (Question)it.next();
             %>
            <div class="clients-page margin-bottom-20">                        
                <p class="text-info"><strong>问题<%=i %>：<%=question.getQuestionContent() %></strong></p>
                
                <%Iterator i2 = question.getChoices().iterator();
                
                while(i2.hasNext())      {       
                Choice choice =  (Choice)i2.next();
                %>
                <label class="radio inline">
                	<input id="question1" type="radio"  value="<%=choice.getChoiceId()%>" name="<%=question.getQuestionId()%>"></input>
                	<%=choice.getChoiceContent() %>
                </label>
                <%} %>
           </div>
            
            <%} %>
            
          
            <div class="text-center">
            
                   <%
                   Tester tester = (Tester) session.getAttribute("Tester");
                   if(tester==null){
                   %>
                   <a href="security.do?method=testerLogin">	<button  class="btn btn-large btn-primary"  type="button">请先登录</button></a>
                   <%}else if(hasjoined==null||hasjoined.equals("false")){ %>
                	<button id="submitQuestionnaire" class="btn btn-large btn-primary" type="button">提交问卷</button>
                	<% }else {%>
                	
                	  <a href="questionnaire.do?method=pageQuestionnaire">	<button  class="btn btn-large btn-primary"  type="button">已参加</button></a>
                	<%} %>
                </div>
        </div><!--/span9-->

    	<div class="span3">
        
        
        	<!-- questionlist -->
        	<div class="headline"><h3>热门问卷</h3></div>
            <p class="margin-bottom-30">
            	<ol>
                	<li><a class="text-error">关于LOL英雄形象的调查</a></li>
                    <li><a class="text-warning">百度云用户满意度调查</a></li>
                    <li><a class="text-info">360使用情况调查</a></li>
                    <li><a class="text-success">众测网站改版意见调查</a></li>
                </ol>
            </p>

        	<!-- top types -->
            <div class="who margin-bottom-30">
                <div class="headline"><h3>主要类型</h3></div>
                <p>这里显示最新的四类热门问卷类型</p>
                <ul class="unstyled">
                    <li><a href="#"><i class="icon-desktop"></i>UI设计</a></li>
                    <li><a href="#"><i class="icon-bullhorn"></i>用户满意度</a></li>
                    <li><a href="#"><i class="icon-globe"></i>需求调查</a></li>
                    <li><a href="#"><i class="icon-group"></i>项目评价</a></li>
                </ul>
            </div>        	
        </div><!--/span3-->
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
<script type="text/javascript" src="assets/plugins/bootstrap/js/bootstrap.min.js"></script> 
<!-- JS Implementing Plugins -->           
<script type="text/javascript" src="assets/plugins/back-to-top.js"></script>
<!-- JS Page Level -->           
<script type="text/javascript" src="assets/js/app.js"></script>
<script type="text/javascript">
    jQuery(document).ready(function() {
        App.init();
    });
</script>
<!--[if lt IE 9]>
    <script src="assets/js/respond.js"></script>
<![endif]-->
</body>
</html>
