$(document).ready(function(){

$("#sureButton").click(function()
{
    $("form#informationForm input[name='username']").attr("value",$("a#username").html());
    $("form#informationForm input[name='birthday']").attr("value",$("a#dob").html());
    $("form#informationForm").attr("action","information.do?method=maintainTester");
    $("form#informationForm").submit();
      

}
);


});