<%@page import="java.util.Date"%>
<%@ page language="java" pageEncoding="utf-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="true">
  <head>
    <html:base />
    
    <title>registration_tester_code.jsp</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <body>
    <form action="registrationTester.do?method=testerRegistration" method="post">
    <div>
    <input type="text" id="vcode" name="randomcode" value="" onblur="checkCode();"/>
    <span class="text-error" id="nonempty3" style="display:none;">字段不能为空</span>
    <span class="text-error" id="error" style="display:none;">验证码输入错误</span>
    </div>
    <button id="comfirm" disabled="disabled">确认</button>
    
    <input class="form-control" type="text" name="email" value=<%=(String)request.getAttribute("email") %> style="display:none;" />
    <input class="form-control" type="password" name="password" value=<%=(String)request.getAttribute("password") %> style="display:none;" />
    <input class="form-control" type="text" name="name" value=<%=(String)request.getAttribute("name") %> style="display:none;" />
    <input class="form-control" type="text" name="gender" value=<%=(Boolean)request.getAttribute("gender") %> style="display:none;" />
    <input class="form-control" type="text" name="mobile" value=<%=(String)request.getAttribute("mobile") %> style="display:none;" />
    <input type="text" id="datepicker" class="form-control datepicker margin-top-none" value=<%=(String)request.getAttribute("birthday") %> style="display:none;" />
    
    </form>
    
  </body>
<script type="text/javascript">
	function checkCode()
	{
		var code = document.getElementById("vcode").value;
		var randomcode = "<%=request.getAttribute("randomcode")%>";
		if(code == "")
		{
			document.getElementById("nonempty3").style.display = "block";
			document.getElementById("error").style.display="none";
			return false;
		}
		else if(randomcode != code)
		{
			document.getElementById("nonempty3").style.display = "none";
			document.getElementById("error").style.display="block";
			return false;
		}
		else if(randomcode == code)
		{
			document.getElementById("nonempty3").style.display = "none";
			document.getElementById("error").style.display="none";
			document.getElementById("comfirm").disabled = "";
			return true;
		}
	}
</script>
</html>
