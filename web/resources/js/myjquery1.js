$(document).ready(function () {

    $(".ddd").hide();
    $(".ddd1").hide();
//    $(".ddd1").hide();
    $("#top1form li").click(function (event) {
        // alert("jo");


    });
    $("#editform a").click(function (event) {
        // alert("jo");
        event.preventDefault();
        var divId = $(this).attr("href");
        //  console.log("divId: "+divId);
        $(".ddd").hide();
        $(".ddd2").hide();
        $(".ddd1").hide();
        $(divId).show();
//        alert(aI);

    });
 
    $("#editformdiv li").click(function (event) {
       // alert("jo");
//        event.preventDefault();
        $(".ddd1").hide();
        $(".ddd2").show();

    });
    $("#editform li").click(function (event) {
        event.preventDefault();
        var aI = $(this).attr("id");//获取li的id；
        // alert(aI);
        $("#editform .dwe").removeClass("active");//删除id为editform样式中的类为dwe的class;
        $("#" + aI).addClass("active");
    });

});

