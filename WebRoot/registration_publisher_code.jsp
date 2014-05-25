<%@ page language="java" pageEncoding="utf-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="true">
  <head>
    <html:base />
    
    <title>registration_publisher_code.jsp</title>

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
    <form action="registrationPublisher.do?method=publisherRegistration" method="post">
	<div>
    <input type="text" id="vcode" name="randomcode" value="" onblur="checkCode();"/>
    <span class="text-error" id="nonempty3" style="display:none;">字段不能为空</span>
    <span class="text-error" id="error" style="display:none;">验证码输入错误</span>
    </div>
    <button id="comfirm" disabled="disabled">确认</button>
    
    <input class="form-control" type="text" name="authority" value=<%=(Boolean)request.getAttribute("authority") %> style="display:none;" />
    <input class="form-control" type="text" name="logEmail" value=<%=(String)request.getAttribute("logEmail") %> style="display:none;" />
    <input class="form-control" type="text" name="publisherName" value=<%=(String)request.getAttribute("publisherName") %> style="display:none;" />
    <input class="form-control" type="text" name="type" value=<%=(Boolean)request.getAttribute("type") %> style="display:none;" />
    <input class="form-control" type="text" name="credit" value=<%=(Double)request.getAttribute("credit") %> style="display:none;" />
    <input class="form-control" type="password" name="password" value=<%=(String)request.getAttribute("password") %> style="display:none;" />
    <input class="form-control" type="text" name="connectEmail" value=<%=(String)request.getAttribute("connectEmail") %> style="display:none;" />
    <input class="form-control" type="text" name="companyName" value=<%=(String)request.getAttribute("companyName") %> style="display:none;" />
    <input class="form-control" type="text" name="license" value=<%=(String)request.getAttribute("license") %> style="display:none;" />
    <input class="form-control" type="text" name="photo" value=<%=(Boolean)request.getAttribute("photo") %> style="display:none;" />
    
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
