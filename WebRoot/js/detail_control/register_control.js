$(document).ready(function(){

$("#checkConfirm").click(function()
{
     

   
      $("form#idForm input[name='subType']").attr("value","yes");
     
    $("form#idForm").attr("action","checkRegisterDetail.do?method=checkConfirm");
    $("form#idForm").submit();
      

}
);


$("#checkFail").click(function()
{
     

      
      $("form#idForm input[name='subType']").attr("value","no");
     
    $("form#idForm").attr("action","checkRegisterDetail.do?method=checkConfirm");
    $("form#idForm").submit();
      

}
);


$("#checkConfirm2").click(function()
{
     

      
      $("form#idForm input[name='subType']").attr("value","yes");
     
    $("form#idForm").attr("action","checkRegisterDetail.do?method=checkConfirm");
    $("form#idForm").submit();
      

}
);


$("#checkFail2").click(function()
{
     

      
     $("form#idForm input[name='subType']").attr("value","no");
     
    $("form#idForm").attr("action","checkQuestionnaireDetail.do?method=checkConfirm");
    $("form#idForm").submit();
      

}
);

});