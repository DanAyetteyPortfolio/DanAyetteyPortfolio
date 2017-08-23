/**
 * Created by Ayettey on 2016-03-19.
 */


$(document).ready(function(){



    $(".rating a").click(function(){
        $(this).css({"backgroundImage":"url(star_highlight.png)"}



        );


    });
    $(".rating a").focus(function(){
        $(this).css({"backgroundImage":"url(star_highlight.png)"}



        );


    });



        $(".rating a").mouseenter(function(){
            $(this).css({"backgroundImage":"url(star_empty.png)"}



            );






    });

});


