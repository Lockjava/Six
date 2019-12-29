$(document).ready(function () {
  
  
    $("#xyform li a").each(function (event) {
       if($($(this))[0].href===String(window.location)){
           $('#xyform li').removeClass("active");
           $(this).parent().addClass("active");
       }       
    });
    

});


