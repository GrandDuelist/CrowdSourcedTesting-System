<%@ page language="java" import="cn.com.crowdsourcedtesting.bean.*;" contentType="text/html; charset=UTF-8"%>

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
 	response.sendRedirect("gifts.do?method=selectAllGifts");
 	return;
 }
 else
 	request.removeAttribute("isLegal");
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
                <li><a href="page_login.html"><i class="icon-user"></i> 登录</a></li>	
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
                    <ul class="nav top-2">
                        <li>
                           <a href="index.jsp">主页
                            
                            </a>
                           
                      </li>
                        <li class="active">
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
<div class="breadcrumbs">
	<div class="container">
        <h1 class="color-green pull-left">礼品中心</h1>
        <ul class="pull-right breadcrumb">
            <li><a href="index.html">主页</a> <span class="divider">/</span></li>
            <li><a href="gifts.html">礼品中心</a> <span class="divider">/</span></li>
            <li class="active">收货地址</li>
        </ul>
    </div><!--/container-->
</div><!--/breadcrumbs-->
<!--=== End Breadcrumbs ===-->


<!--=== Content Part ===-->
<div class="container"> 	
	<div class="row-fluid"> 
        <div id="w">    
            <div class="sort" id="sort">
            
				<ul class="unstyled inline">
                	<li><a href="#" class="all selected">所有</a></li>
                	<li><a href="#" class="web">常规礼品</a></li>
                	<li><a href="#" class="ios">项目礼品</a></li>
                	<li><a href="#" class="print">可兑换礼品</a></li>
                </ul>
            </div>
            
            	
            
            <ul class="portfolio recent-work clearfix"> 
                <li data-id="id-1" class="ios">
                    <a href="portfolio_item.html">
                    	<em class="overflow-hidden"><img src="assets/plugins/portfolioSorting/img/2.jpg" alt="" /></em>
                        <span>
                            <strong>Happy New Year</strong>
                            <i>Anim pariatur cliche reprehenderit</i>
                        </span>
                    </a>
                </li>
                <li data-id="id-2" class="print">
                    <a href="portfolio_item.html">
                    	<em class="overflow-hidden"><img src="assets/plugins/portfolioSorting/img/3.jpg" alt="" /></em>
                        <span>
                            <strong>Happy New Year</strong>
                            <i>Anim pariatur cliche reprehenderit</i>
                        </span>
                    </a>
                </li>
                <li data-id="id-3" class="ios">
                    <a href="portfolio_item.html">
                    	<em class="overflow-hidden"><img src="assets/plugins/portfolioSorting/img/4.jpg" alt="" /></em>
                        <span>
                            <strong>Happy New Year</strong>
                            <i>Anim pariatur cliche reprehenderit</i>
                        </span>
                    </a>
                </li>
                <li data-id="id-4" class="print">
                    <a href="portfolio_item.html">
                    	<em class="overflow-hidden"><img src="assets/plugins/portfolioSorting/img/5.jpg" alt="" /></em>
                        <span>
                            <strong>Happy New Year</strong>
                            <i>Anim pariatur cliche reprehenderit</i>
                        </span>
                    </a>
                </li>
                <li data-id="id-5" class="web">
                    <a href="portfolio_item.html">
                    	<em class="overflow-hidden"><img src="assets/plugins/portfolioSorting/img/6.jpg" alt="" /></em>
                        <span>
                            <strong>Happy New Year</strong>
                            <i>Anim pariatur cliche reprehenderit</i>
                        </span>
                    </a>
                </li>
                <li data-id="id-6" class="web">
                    <a href="portfolio_item.html">
                    	<em class="overflow-hidden"><img src="assets/plugins/portfolioSorting/img/7.jpg" alt="" /></em>
                        <span>
                            <strong>Happy New Year</strong>
                            <i>Anim pariatur cliche reprehenderit</i>
                        </span>
                    </a>
                </li>
                <li data-id="id-7" class="print">
                    <a href="portfolio_item.html">
                    	<em class="overflow-hidden"><img src="assets/plugins/portfolioSorting/img/8.jpg" alt="" /></em>
                        <span>
                            <strong>Happy New Year</strong>
                            <i>Anim pariatur cliche reprehenderit</i>
                        </span>
                    </a>
                </li>
                <li data-id="id-8" class="web">
                    <a href="portfolio_item.html">
                    	<em class="overflow-hidden"><img src="assets/plugins/portfolioSorting/img/2.jpg" alt="" /></em>
                        <span>
                            <strong>Happy New Year</strong>
                            <i>Anim pariatur cliche reprehenderit</i>
                        </span>
                    </a>
                </li>
                <li data-id="id-9" class="ios">
                    <a href="portfolio_item.html">
                    	<em class="overflow-hidden"><img src="assets/plugins/portfolioSorting/img/9.jpg" alt="" /></em>
                        <span>
                            <strong>Happy New Year</strong>
                            <i>Anim pariatur cliche reprehenderit</i>
                        </span>
                    </a>
                </li>
                <li data-id="id-10" class="ios">
                    <a href="portfolio_item.html">
                    	<em class="overflow-hidden"><img src="assets/plugins/portfolioSorting/img/10.jpg" alt="" /></em>
                        <span>
                            <strong>Happy New Year</strong>
                            <i>Anim pariatur cliche reprehenderit</i>
                        </span>
                    </a>
                </li>
                <li data-id="id-11" class="web">
                    <a href="portfolio_item.html">
                    	<em class="overflow-hidden"><img src="assets/plugins/portfolioSorting/img/5.jpg" alt="" /></em>
                        <span>
                            <strong>Happy New Year</strong>
                            <i>Anim pariatur cliche reprehenderit</i>
                        </span>
                    </a>
                </li>
                <li data-id="id-12" class="web">
                    <a href="portfolio_item.html">
                    	<em class="overflow-hidden"><img src="assets/plugins/portfolioSorting/img/3.jpg" alt="" /></em>
                        <span>
                            <strong>Happy New Year</strong>
                            <i>Anim pariatur cliche reprehenderit</i>
                        </span>
                    </a>
                </li>
                <li data-id="id-13" class="ios">
                    <a href="portfolio_item.html">
                    	<em class="overflow-hidden"><img src="assets/plugins/portfolioSorting/img/6.jpg" alt="" /></em>
                        <span>
                            <strong>Happy New Year</strong>
                            <i>Anim pariatur cliche reprehenderit</i>
                        </span>
                    </a>
                </li>
                <li data-id="id-14" class="web">
                    <a href="portfolio_item.html">
                    	<em class="overflow-hidden"><img src="assets/plugins/portfolioSorting/img/9.jpg" alt="" /></em>
                        <span>
                            <strong>Happy New Year</strong>
                            <i>Anim pariatur cliche reprehenderit</i>
                        </span>
                    </a>
                </li>
                <li data-id="id-15" class="web">
                    <a href="portfolio_item.html">
                    	<em class="overflow-hidden"><img src="assets/plugins/portfolioSorting/img/7.jpg" alt="" /></em>
                        <span>
                            <strong>Happy New Year</strong>
                            <i>Anim pariatur cliche reprehenderit</i>
                        </span>
                    </a>
                </li>
            </ul>
        </div>
        <div class="pagination pagination-centered">
            <ul>
              <li><a href="#">前一页</a></li>
              <li><a href="#">1</a></li>
              <li><a href="#">2</a></li>
              <li class="active"><a href="#">3</a></li>
              <li><a href="#">4</a></li>
              <li><a href="#">5</a></li>
              <li><a href="#">6</a></li>
              <li><a href="#">7</a></li>
              <li><a href="#">8</a></li>
              <li><a href="#">后一页</a></li>
            </ul>
        </div>                  
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
<script type="text/javascript" src="assets/js/morecity.js"></script>       
<script type="text/javascript" src="assets/plugins/bootstrap/js/bootstrap.min.js"></script> 
<!-- JS Implementing Plugins -->           
<script type="text/javascript" src="assets/plugins/portfolioSorting/js/jquery.quicksand.js"></script>
<script type="text/javascript" src="assets/plugins/portfolioSorting/js/sorting.js"></script>
<script type="text/javascript" src="assets/plugins/back-to-top.js"></script>

<!-- JS Page Level -->           
<script type="text/javascript" src="assets/js/app.js"></script>
<script type="text/javascript">
    jQuery(document).ready(function() {
        App.init();
        
        $('#changebtn').click(function(e) {
        	//alert($('#ddlProvince').attr("value")+" "+$('#ddlCity').attr("value")+" "+$('#ddlStreet').attr("value"));
        	$('form#changeform input[name="address"]').attr("value", $('#ddlProvince').attr("value")+" "+$('#ddlCity').attr("value")+" "+$('#ddlStreet').attr("value"));
		  	$('#changebtn').attr("disabled",true);
		  	$('#changeform').submit();
	 	});  
	 		
    });
	 BindCity("洛阳");
</script>
<!--[if lt IE 9]>
    <script src="assets/js/respond.js"></script>
<![endif]-->
</body>
</html:html>
