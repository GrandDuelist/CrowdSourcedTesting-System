<%@ page language="java" import="java.util.*,cn.com.crowdsourcedtesting.bean.*,java.util.List,cn.com.other.page.*;" contentType="text/html; charset=UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE html>
<!--[if IE 7]> <html lang="en" class="ie7"> <![endif]-->  
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->  
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->  
<!--[if !IE]><!--> <html lang="cn"> <!--<![endif]-->  
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
                           <a href="index.html">主页
                            
                            </a>
                           
                      </li>
                        <li>
                            <a href="gifts.html">礼品中心
                                                        
                            </a>
                                       
                        </li>
                        <li class="active">
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
                       <li>
                            <a href="page_questionaire.html">问卷调查
                            </a>
                            
                                                    
                        </li>
                        <li><a class="search search-nav"><i class="icon-search search-btn"></i></a></li>                                
                    </ul>
                    <div class="search-open">
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
<div class="breadcrumbs margin-bottom-40">
	<div class="container">
        <h1 class="color-green pull-left">任务内容</h1>
        <ul class="pull-right breadcrumb">
            <li><a href="index.html">主页</a> <span class="divider">/</span></li>
            <li><a href="index.html">任务广场</a> <span class="divider">/</span></li>
            <li class="active"></li>
        </ul>
    </div><!--/container-->
</div><!--/breadcrumbs-->
<!--=== End Breadcrumbs ===-->

<!--=== Content Part ===-->
<div class="container">		
	<div class="row-fluid blog-page blog-item">
        <!-- Left Sidebar -->
    	<div class="span9">
        	<div class="blog margin-bottom-30">
            	<h3>LOL测试英雄连招bug</h3>
            	<ul class="unstyled inline blog-info">
                	<li><i class="icon-calendar"></i> February 02, 2013</li>
                	<li><i class="icon-pencil"></i> Diana Anderson</li>
                	<li><i class="icon-comments"></i> <a href="#">24 Comments</a></li>
                </ul>
            	<ul class="unstyled inline blog-tags">
                    <li>
                        <i class="icon-tags"></i> 
                        <a href="#">Technology</a> 
                        <a href="#">Education</a>
                        <a href="#">Internet</a>
                        <a href="#">Media</a>
                    </li>
                </ul>
                <div class="blog-img"><img src="assets/img/posts/1.jpg" alt="" /></div>
                <p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut non libero consectetur adipiscing elit magna. Sed et quam lacus. Fusce condimentum eleifend enim a feugiat. Pellentesque viverra vehicula sem ut volutpat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut non libero magna. Sed et quam lacus. Fusce condimentum eleifend enim a feugiat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut non libero magna. Sed et quam lacus. Fusce condimentum eleifend enim a feugiat.</p>

                <blockquote class="hero">
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit posuere erat a ante.</p>
                    <small>Someone famous <cite title="Source Title">Source Title</cite></small>
                </blockquote>

                <p>Accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias feugiat. Pellentesque viverra vehicula sem ut volutpat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut non libero magna. Sed et quam lacus. Fusce condimentum eleifend enim a feugiat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut non libero magna. Sed et quam lacus. Fusce condimentum eleifend enim a feugiat.</p>
            </div><!--/blog-->

			<hr />
            <!-- Media -->
            <div class="media">
            	<h3 class="color-green">评论列表</h3>
                <a class="pull-left" href="#">
                    <img class="media-object" src="assets/img/sliders/elastislide/2.jpg" alt="" />
                </a>
                
                
 <%
 List <TaskComment> comments  =(List<TaskComment>) request.getAttribute("comments");
 Page commentpage = (Page)request.getAttribute("page");
 Iterator<TaskComment> it= comments.iterator();
 TaskComment comment = null;
 
 for(int i=0;i<commentpage.getPerRows();i++)
	{ 
		if(!it.hasNext())
			break;
			
		comment=it.next();

 %>                            
                <div class="media-body">
                <h4 class="media-heading"><%=comment.getTester().getTesterName()%><span><%=comment.getCommentTime()%></span></h4>
                <p><%=comment.getCommentContent()%></p>                                   
                </div>
 <%
	}
 %>               
                
                
                
                
            </div><!--/media-->
            <hr />

            <!-- Leave a Comment -->
            <div class="post-comment">
            	<h3 class="color-green">评论</h3>
                <form action="comment.do?method=addNewComment" method="post">
                    <label>内容</label>
                    <textarea name="comment" rows="8" class="span10"></textarea>
                    <p><button type="submit" class="btn-u">发送</button></p>
                </form>
            </div><!--/post-comment-->
        </div><!--/span9-->

        <!-- Right Sidebar -->
    	<div class="span3">
        	<!-- Photo Stream -->
        	<div class="headline"><h3>任务流</h3></div>
            <ul class="unstyled blog-ads">
            	<li><a href="#"><img src="assets/img/sliders/elastislide/5.jpg" alt="" class="hover-effect" /></a></li>
            	<li><a href="#"><img src="assets/img/sliders/elastislide/6.jpg" alt="" class="hover-effect" /></a></li>
            	<li><a href="#"><img src="assets/img/sliders/elastislide/8.jpg" alt="" class="hover-effect" /></a></li>
            	<li><a href="#"><img src="assets/img/sliders/elastislide/10.jpg" alt="" class="hover-effect" /></a></li>
            	<li><a href="#"><img src="assets/img/sliders/elastislide/11.jpg" alt="" class="hover-effect" /></a></li>
            	<li><a href="#"><img src="assets/img/sliders/elastislide/1.jpg" alt="" class="hover-effect" /></a></li>
            	<li><a href="#"><img src="assets/img/sliders/elastislide/2.jpg" alt="" class="hover-effect" /></a></li>
            	<li><a href="#"><img src="assets/img/sliders/elastislide/7.jpg" alt="" class="hover-effect" /></a></li>
            </ul>

        	<!-- Blog Tags -->
        	<div class="headline"><h3>任务标签</h3></div>
            <ul class="unstyled inline blog-tags">
            	<li><a href="#"><i class="icon-tags"></i> Business</a></li>
            	<li><a href="#"><i class="icon-tags"></i> Music</a></li>
            	<li><a href="#"><i class="icon-tags"></i> Internet</a></li>
            	<li><a href="#"><i class="icon-tags"></i> Education</a></li>
            	<li><a href="#"><i class="icon-tags"></i> People</a></li>
            	<li><a href="#"><i class="icon-tags"></i> Math</a></li>
            	<li><a href="#"><i class="icon-tags"></i> Photos</a></li>
            	<li><a href="#"><i class="icon-tags"></i> Electronics</a></li>
            	<li><a href="#"><i class="icon-tags"></i> Apple</a></li>
            	<li><a href="#"><i class="icon-tags"></i> Canada</a></li>
            </ul>

        	<!-- Blog Latest Tweets -->
            <div class="blog-twitter">
                <div class="headline"><h3>最近评论</h3></div>
                <p><a href="">@htmlstream</a> At vero eos et accusamus et iusto odio dignissimos. <a href="#">http://t.co/sBav7dm</a> <span>5 hours ago</span></p>
                <p><a href="">@unify</a> At vero eos et accusamus et iusto odio dignissimos. <a href="#">http://t.co/f58Ddg4</a> <span>8 hours ago</span></p>
                <p><a href="">@veroeos</a> At vero eos et accusamus et iusto odio dignissimos. <a href="#">http://t.co/adVs9f</a> <span>17 hours ago</span></p>
                <p><a href="">@accusamus </a> At vero eos et accusamus et iusto odio dignissimos. <a href="#">http://t.co/wf5Fs6</a> <span>23 hours ago</span></p>
                <p><a href="">@veroeoset</a> At vero eos et accusamus et iusto odio dignissimos. <a href="#">http://t.co/7EsffP</a> <span>1 day ago</span></p>
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