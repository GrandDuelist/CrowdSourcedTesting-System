package filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.RequestProcessor;

public class MyRequestProcessor extends RequestProcessor{
public MyRequestProcessor(){}
@Override
protected boolean processPreprocess(HttpServletRequest request,
    HttpServletResponse response){
   try{
    request.setCharacterEncoding("UTF-8");//在此设置字符集
	response.setContentType("text/html;charset=utf-8");
   }
   catch(Exception ex){
    System.out.println("字符集设置失败");
   }
   return true;
}
}