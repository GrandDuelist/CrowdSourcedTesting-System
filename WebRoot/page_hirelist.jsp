<%@ page language="java" import="java.util.*,cn.com.crowdsourcedtesting.modelhelper.*,cn.com.crowdsourcedtesting.bean.*,java.util.List,cn.com.other.page.*;" contentType="text/html; charset=UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE html>
<html:html lang="true">
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
    <link rel="stylesheet" href="assets/plugins/portfolioSorting/css/sorting.css" />    
    <!-- CSS Theme -->    
    <link rel="stylesheet" href="assets/css/themes/default.css" id="style_color" />
    <link rel="stylesheet" href="assets/css/themes/headers/default.css" id="style_color-header-1" />    
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head> 

<% 
String flag = (String)request.getAttribute("isLegal");
 if(flag == null || flag != "legal")
 {
 	response.sendRedirect("recruitment.do?method=selectAllRecruitment");
 	return;
 }
 else
 	request.removeAttribute("isLegal");
 	UserType  userType = (UserType)session.getAttribute("UserType");
	Tester tester  = (Tester)session.getAttribute("Tester");
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
                <%
                	if(userType == null)
                	{
                %>
                 <li><a href="login.do?method=testerLogin"><i class="icon-user"></i> 登录</a></li>	
                <%
                	}
                	else if(userType.equals(UserType.Tester))
                	{
                %>
                 <li><a href="security.do?method=testerLogout"><i class="icon-user"></i>注销</a></li>
                 <li><a href="personal_center.do?method=testerFindAllQuestionnaire"><%=tester.getTesterName()%></a></li>	
                <%
                	}
                %>
            </ul>
        </div>        				
    </div><!--/container-->		
</div><!--/top-->
<!--=== End Top ===--> 
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
                           <a href="index.jsp">主页
                            
                            </a>
                           
                      </li>
                        <li>
                            <a href="gifts.do?method=selectAllGifts">礼品中心
                                                        
                            </a>
                                       
                        </li>
                        <li>
                            <a href="testTaskViewList.do">任务广场                            
                            </a>
                        </li>
                        <li class="active">
                            <a  href="recruitment.do?method=selectAllRecruitment">招募帖                          
                            </a>
                        </li>
                        <li>
                            <a href="page_clients.html">合作伙伴</a>
      
                        </li>
                       <li >
                            <a href="questionnaire.do?method=pageQuestionnaire">问卷调查
                            </a>
                            
                                                    
                        </li>
                        <li><a class="search search-nav"><i class="icon-search search-btn"></i></a></li>                                
                    </ul>
                    <div class="search-open">
                        <div class="input-append">
                            <form>
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
<div class="breadcrumbs margin-bottom-40">
	<div class="container">
        <h1 class="pull-left">招募信息列表</h1>
        <ul class="pull-right breadcrumb">
            <li><a href="index.html">主页</a> <span class="divider">/</span></li>
            <li class="active">招募信息</li>
        </ul>
    </div><!--/container-->
</div><!--/breadcrumbs-->
<!--=== End Breadcrumbs ===-->

<%
 List <Recruitment> recruitments  =(List<Recruitment>) request.getAttribute("hirelist");
 Page hirepage = (Page)request.getAttribute("page");
 Iterator<Recruitment> it= recruitments.iterator();
 Recruitment recruitment = null;
 %>

<!--=== Content Part ===-->
<div class="container">		
	<div class="row-fluid">
    	<!-- Our Services -->
	<div class="row-fluid">
        <div class="row-fluid margin-bottom-20"> 
        
        		<%
                	if(!it.hasNext())
                		return;
                	else
                	{
						recruitment=it.next();
						String type = "线下";
						if(recruitment.getOnline())
							type = "线上";
						String startdate = (recruitment.getTimeStart().getYear()+1900)+"-"+(recruitment.getTimeStart().getMonth()+1)+"-"+recruitment.getTimeStart().getDate();
 						String enddate = (recruitment.getTimeEnd().getYear()+1900)+"-"+(recruitment.getTimeEnd().getMonth()+1)+"-"+recruitment.getTimeEnd().getDate();
             	%>
        
		<!-- Carousel -->
        <div class="span7">
            <div id="myCarousel" class="carousel slide">
                <div class="carousel-inner">
        
                    <div class="item active">
                        <img src="assets/img/carousel/5.jpg" alt="" />
                        <div class="carousel-caption">
                            <h4><%=recruitment.getBrief()%></h4>
                        </div>
                    </div>                  
                </div>
                <!--  
                <div class="carousel-arrow">
                    <a data-slide="prev" href="#myCarousel" class="left carousel-control"><i class="icon-angle-left"></i></a>
                    <a data-slide="next" href="#myCarousel" class="right carousel-control"><i class="icon-angle-right"></i></a>
                </div>
                 -->
            </div>
        </div><!--/span7-->
        
        <!-- //End Tabs and Carousel -->
        
        <div class="span5">
        	<h3><%=recruitment.getActivityName()%></h3>
        	<p><%=recruitment.getContent()%></p>
            <ul class="unstyled">
            	<li><i class="icon-user color-green"></i>公司: <%=recruitment.getCompany()%></li>
            	<li><i class="icon-calendar color-green"></i>时间: <%=startdate%>至<%=enddate%></li>
            	<li><i class="icon-tags color-green"></i>地点: <%=type%>--<%=recruitment.getPlace()%></li>
            </ul>
            <p><a class="btn-u btn-u-large" href="recruitment.do?method=selectRecruitment&id=<%=recruitment.getActivityId()%>">VISIT THE PROJECT</a></p>
        </div>
        
        		<%
        			}
        		%>
        
        
    </div><!--/row-fluid-->

		<%
			for(int k=1; k<=4; k++)
			{
		%>
		
			<div class="row-fluid servive-block">
		
		<%
			for(int i=1; i<=3; i++)
			{
				if(!it.hasNext())
					break;
					
				recruitment=it.next();
				String type = "线下";
				if(recruitment.getOnline())
					type = "线上";
				String startdate = (recruitment.getTimeStart().getYear()+1900)+"-"+(recruitment.getTimeStart().getMonth()+1)+"-"+recruitment.getTimeStart().getDate();
 				String enddate = (recruitment.getTimeEnd().getYear()+1900)+"-"+(recruitment.getTimeEnd().getMonth()+1)+"-"+recruitment.getTimeEnd().getDate();
 		%>
			
                <div class="span4">
                    <h4><a href="recruitment.do?method=selectRecruitment&id=<%=recruitment.getActivityId()%>"><%=recruitment.getActivityName()%></a></h4>
                    <p>时间: <%=startdate%>至<%=enddate%></p>
                    <p>简介: <%=recruitment.getBrief()%></p>
                </div>
                
        <%
            }
        %>
                                       
            </div><!--/row-fluid-->
            
        <%
            }
        %>
        
            
            
            
        </div><!--/row-fluid-->        
    	<!--//End Our Services -->
        
    </div><!--/row-fluid-->
	<div class="pagination pagination-centered">
            <ul>
            
              <!-- 导航 start --> 
        <% 
            for(int i=0;i<hirepage.getTotalPage();i++)
  			{ 
  		%>  
  				<a href="recruitment.do?method=selectPage&pagenow=<%=(1+i)%>"><%=(1+i)%></a>
  		<%
  			}
  		%>
  		<!-- 导航end -->  
  		
            </ul>
        </div>     
	
    
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
			<div class="span8">						
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
<script type="text/javascript" src="assets/plugins/flexslider/jquery.flexslider-min.js"></script>
<script type="text/javascript" src="assets/plugins/horizontal-parallax/js/sequence.jquery-min.js"></script>
<script type="text/javascript" src="assets/plugins/horizontal-parallax/js/horizontal-parallax.js"></script>
<script type="text/javascript" src="assets/plugins/bxslider/jquery.bxslider.js"></script>
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
</html:html>
