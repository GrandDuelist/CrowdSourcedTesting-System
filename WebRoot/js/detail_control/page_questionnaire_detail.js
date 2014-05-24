$(document).ready(function(){

$("#submitQuestionnaire").click(function()
{
     
    
      
    
    var questions=$('#question1:checked');
    
  
    var len =  questions.length;
    var content ="";
    for(var i=0;i<len;i++)
    	{
    	   var question = $(questions[i]);
    	   content = content+"||"+question.attr("name")+"-"+question.attr("value");  	   
    	}
    $("form#idForm input[name='subType']").attr("value",content);
    $("form#idForm").attr("action","pageQuestionnaireDetail.do?method=subQuestionnaire");
    $("form#idForm").submit();
      

}
);




});