$(function() {
    $('.portion').bind('keyup', function(event) {
        var oldPortion = parseFloat($("#previousPortion").val());
        var newPortion = parseFloat($(event.target).val());

        if (oldPortion && newPortion) { 
            $('.serving').each(function(index, elem) {
                var ingredientNow = $('.amount', elem);
                var oldAmount = parseFloat(ingredientNow.text());
                var newAmount = oldAmount * newPortion / oldPortion;
                ingredientNow.text(newAmount);
            });
            $('#previousPortion').val(newPortion);
        }
    });
});


var buttons = document.getElementsByTagName("button");
var buttonsCount = buttons.length;
for (var i = 0; i <= buttonsCount; i += 1) {
    buttons[i].onclick = function(e) {
        alert(this.id);
    };
}


//var x = document.getElementById("myBtn").value;
    //document.getElementById("demo").innerHTML = x;