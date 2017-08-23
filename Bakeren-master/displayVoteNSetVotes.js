/**
 * Created by Ayettey on 2016-03-20.
 */




/* Get data from the server */
function getVotes(){
    $("#messageDiv").html("<p><img src=loader3.gif></p>");
    $.ajax({
        method:"GET",

       url:"https://edu.oscarb.se/sjk15/api/recipe/?api_key=d0dfb51f086c95eb&recipe=dye_capcakes",

        success: function (data) {
            $("#rating1").text(data.rating);
            $("#vote").text(data.votes);
            $("#recipe").text(data.recipe);
            $("#messageDiv").empty();

        }

        } );


    $(".rating").click(function(){

        var getValue=$(this).text();
        console.log("rating");

       var url="https://edu.oscarb.se/sjk15/api/recipe/?api_key=d0dfb51f086c95eb&recipe=dye_capcakes&rating=5";
        var params="";

        $("#messageDiv").html("<p><img src=loader3.gif></p>");

        $.ajax({

            method: "GET",
            data:{score_rating:getValue},
             url:url+params,
            success:function(){
                getVotes();
                $("#messageDiv").empty();
            }


        })


    });

}

/* call the function innerHtml*/
$(document).ready(function(){
    getVotes();

});

