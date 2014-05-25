$(document).ready(function(){

$("#sureButton").click(function()
{
    $("form#informationForm input[name='username']").attr("value",$("a#username").html());
    $("form#informationForm input[name='license']").attr("value",$("a#license").html());
    $("form#informationForm input[name='credit']").attr("value",$("a#credit").html());
    $("form#informationForm input[name='company']").attr("value",$("a#company").html());
    $("form#informationForm input[name='publisherType']").attr("value","Company");
    $("form#informationForm").attr("action","information.do?method=maintainPublisher");
    $("form#informationForm").submit();
      

}
);
$("#sureButton2").click(function()
		{
		    $("form#informationForm input[name='username']").attr("value",$("a#username").html());
		    $("form#informationForm input[name='license']").attr("value",$("a#license").html());
		    $("form#informationForm input[name='credit']").attr("value",$("a#credit").html());
		    $("form#informationForm input[name='company']").attr("value",$("a#company").html());
		    $("form#informationForm input[name='publisherType']").attr("value","Person");
		    $("form#informationForm").attr("action","information.do?method=maintainPublisher");
		    $("form#informationForm").submit();
		      

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