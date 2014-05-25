$(document).ready(function(){

	
$("#detail1 a").click(function()
{
     
   
      $("form#selectForm input[name='subType']").attr("value","detail");
      $("form#selectForm input[name='id']").attr("value",$(this).attr("id"));
      $("form#selectForm input[name='publisherType']").attr("value","Company");
     $("form#selectForm").attr("action","information.do?method=managePublisherDetail");
   	 $("form#selectForm").submit();
      

}
);

$("#pageNum a").click(function()
{
     

     
      $("form#selectForm input[name='subType']").attr("value","pageNum");
      $("form#selectForm input[name='page']").attr("value",$(this).attr("id"));
     $("form#selectForm").attr("action","information.do?method=manageCompanyList");
   	 $("form#selectForm").submit();
      

}
);


$("#previouPage a").click(function()
{
     

     
      $("form#selectForm input[name='subType']").attr("value","previousPage");
      $("form#selectForm input[name='page']").attr("value",$(this).attr("id"));
     $("form#selectForm").attr("action","information.do?method=manageCompanyList");
   	 $("form#selectForm").submit();
      

}
);

$("#nextPage a").click(function()
{
     


      $("form#selectForm input[name='subType']").attr("value","nextPage");
      $("form#selectForm input[name='page']").attr("value",$(this).attr("id"));
     $("form#selectForm").attr("action","information.do?method=manageCompanyList");
   	 $("form#selectForm").submit();
      

}
);
$("#detail2 a").click(function()
		{
		     
		   
		      $("form#selectForm input[name='subType']").attr("value","detail");
		      $("form#selectForm input[name='id']").attr("value",$(this).attr("id"));
		      $("form#selectForm input[name='publisherType']").attr("value","Person");
		     $("form#selectForm").attr("action","information.do?method=managePublisherDetail");
		   	 $("form#selectForm").submit();
		      

		}
		);

$("#pageNum2 a").click(function()
		{
		     

		     
		      $("form#selectForm input[name='subType']").attr("value","pageNum");
		      $("form#selectForm input[name='page']").attr("value",$(this).attr("id"));
		    
		     $("form#selectForm").attr("action","information.do?method=managePersonList");
		   	 $("form#selectForm").submit();
		      

		}
		);


		$("#previouPage2 a").click(function()
		{
		     

		     
		      $("form#selectForm input[name='subType']").attr("value","previousPage");
		      $("form#selectForm input[name='page']").attr("value",$(this).attr("id"));
		     $("form#selectForm").attr("action","information.do?method=managePersonList");
		   	 $("form#selectForm").submit();
		      

		}
		);

		$("#nextPage2 a").click(function()
		{
		     


		      $("form#selectForm input[name='subType']").attr("value","nextPage");
		      $("form#selectForm input[name='page']").attr("value",$(this).attr("id"));
		     $("form#selectForm").attr("action","information.do?method=managePersonList");
		   	 $("form#selectForm").submit();
		      

		}
		);

});