$(document).ready(function(){

$("#checkConfirm").click(function()
{
     

   
      $("form#idForm input[name='subType']").attr("value","yes");
     
    $("form#idForm").attr("action","checkTestTaskDetail.do?method=checkConfirm");
    $("form#idForm").submit();
      

}
);


$("#checkFail").click(function()
{
     

      
      $("form#idForm input[name='subType']").attr("value","no");
     
    $("form#idForm").attr("action","checkTestTaskDetail.do?method=checkConfirm");
    $("form#idForm").submit();
      

}
);
});
