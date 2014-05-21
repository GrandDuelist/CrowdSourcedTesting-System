$(document).ready(function(){

$("#detail1 a").click(function()
{
     
   
      $("form#selectForm input[name='subType']").attr("value","detail");
      $("form#selectForm input[name='id']").attr("value",$(this).attr("id"));
     $("form#selectForm").attr("action","checkTestTaskList.do?method=checkWebDetail");
   	 $("form#selectForm").submit();
      

}
);


$("#detail2 a").click(function()
{
     
   
      $("form#selectForm input[name='subType']").attr("value","detail");
      $("form#selectForm input[name='id']").attr("value",$(this).attr("id"));
     $("form#selectForm").attr("action","checkTestTaskList.do?method=checkAndroidDetail");
   	 $("form#selectForm").submit();
      

}
);


$("#detail3 a").click(function()
{
     
   
      $("form#selectForm input[name='subType']").attr("value","detail");
      $("form#selectForm input[name='id']").attr("value",$(this).attr("id"));
     $("form#selectForm").attr("action","checkTestTaskList.do?method=checkDesktopDetail");
   	 $("form#selectForm").submit();
      

}
);


$("#pageNum1 a").click(function()
{
     

     
	  
      $("form#selectForm input[name='subType']").attr("value","pageNum");
      $("form#selectForm input[name='page']").attr("value",$(this).attr("id"));
     $("form#selectForm").attr("action","checkTestTaskList.do?method=checkWebList");
   	 $("form#selectForm").submit();
      

}
);


$("#previouPage1 a").click(function()
{
     

     
      $("form#selectForm input[name='subType']").attr("value","previousPage");
      $("form#selectForm input[name='page']").attr("value",$(this).attr("id"));
     $("form#selectForm").attr("action","checkTestTaskList.do?method=checkWebList");
   	 $("form#selectForm").submit();
      

}
);

$("#nextPage1 a").click(function()
{
     


      $("form#selectForm input[name='subType']").attr("value","nextPage");
      $("form#selectForm input[name='page']").attr("value",$(this).attr("id"));
     $("form#selectForm").attr("action","checkTestTaskList.do?method=checkWebList");
   	 $("form#selectForm").submit();
      

}
);


$("#pageNum2 a").click(function()
		{
		     

		     
		      $("form#selectForm input[name='subType']").attr("value","pageNum");
		      $("form#selectForm input[name='page']").attr("value",$(this).attr("id"));
		     $("form#selectForm").attr("action","checkTestTaskList.do?method=checkAndroidList");
		   	 $("form#selectForm").submit();
		      

		}
		);


		$("#previouPage2 a").click(function()
		{
		     

		     
		      $("form#selectForm input[name='subType']").attr("value","previousPage");
		      $("form#selectForm input[name='page']").attr("value",$(this).attr("id"));
		     $("form#selectForm").attr("action","checkTestTaskList.do?method=checkAndroidList");
		   	 $("form#selectForm").submit();
		      

		}
		);

		$("#nextPage2 a").click(function()
		{
		     


		      $("form#selectForm input[name='subType']").attr("value","nextPage");
		      $("form#selectForm input[name='page']").attr("value",$(this).attr("id"));
		     $("form#selectForm").attr("action","checkTestTaskList.do?method=checkAndroidList");
		   	 $("form#selectForm").submit();
		      

		}
		);
		
		$("#pageNum3 a").click(function()
				{
				     

				     
				      $("form#selectForm input[name='subType']").attr("value","pageNum");
				      $("form#selectForm input[name='page']").attr("value",$(this).attr("id"));
				     $("form#selectForm").attr("action","checkTestTaskList.do?method=checkDesktopList");
				   	 $("form#selectForm").submit();
				      

				}
				);


				$("#previouPage3 a").click(function()
				{
				     

				     
				      $("form#selectForm input[name='subType']").attr("value","previousPage");
				      $("form#selectForm input[name='page']").attr("value",$(this).attr("id"));
				     $("form#selectForm").attr("action","checkTestTaskList.do?method=checkDesktopList");
				   	 $("form#selectForm").submit();
				      

				}
				);

				$("#nextPage3 a").click(function()
				{
				     


				      $("form#selectForm input[name='subType']").attr("value","nextPage");
				      $("form#selectForm input[name='page']").attr("value",$(this).attr("id"));
				     $("form#selectForm").attr("action","checkTestTaskList.do?method=checkDesktopList");
				   	 $("form#selectForm").submit();
				      

				}
				);

});