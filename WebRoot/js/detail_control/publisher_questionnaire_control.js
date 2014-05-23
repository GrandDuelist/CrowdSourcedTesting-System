$(document).ready(function(){

$("#checkConfirm").click(function()
{
     

      
      $("form#idForm input[name='subType']").attr("value","yes");
     
    $("form#idForm").attr("action","questionnaireList.do?method=checkConfirm");
    $("form#idForm").submit();
      

}
);


$("#checkFail").click(function()
{
     

      
      $("form#idForm input[name='subType']").attr("value","no");
     
    $("form#idForm").attr("action","questionnaireList.do?method=checkConfirm");
    $("form#idForm").submit();
      

}
);

});