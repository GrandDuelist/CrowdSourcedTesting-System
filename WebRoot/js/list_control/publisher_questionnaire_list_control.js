$(document).ready(function(){

$("#detail a").click(function()
{
     

      
      $("form#selectForm input[name='subType']").attr("value","detail");
      $("form#selectForm input[name='id']").attr("value",$(this).attr("id"));
     $("form#selectForm").attr("action","questionnaireList.do?method=questionnaireDetail");
   	 $("form#selectForm").submit();
      

}
);

$("#pageNum a").click(function()
{
     

     
      $("form#selectForm input[name='subType']").attr("value","pageNum");
      $("form#selectForm input[name='page']").attr("value",$(this).attr("id"));
     $("form#selectForm").attr("action","questionnaireList.do?method=questionnaireList");
   	 $("form#selectForm").submit();
      

}
);


$("#previouPage a").click(function()
{
     

     
      $("form#selectForm input[name='subType']").attr("value","previousPage");
      $("form#selectForm input[name='page']").attr("value",$(this).attr("id"));
     $("form#selectForm").attr("action","questionnaireList.do?method=questionnaireList");
   	 $("form#selectForm").submit();
      

}
);

$("#nextPage a").click(function()
{
     


      $("form#selectForm input[name='subType']").attr("value","nextPage");
      $("form#selectForm input[name='page']").attr("value",$(this).attr("id"));
     $("form#selectForm").attr("action","questionnaireList.do?method=questionnaireList");
   	 $("form#selectForm").submit();
      

}
);

});