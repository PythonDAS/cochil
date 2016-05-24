/**
 * Created by donghoon on 2016. 5. 23..
 */
$(document).ready(function () {
    $("#submit").on("click", function () {
        console.log("성분 저장.");

        var ingredientName = $("#ingredientName").val();
        var ingredientExplanation = $("#ingredientExplanation").val();

        $.ajax({
            type: "post",
            url: "/ingredient/save",
            dataType: "json",
            data: {
                name: ingredientName,
                explanation: ingredientExplanation
            },
            success: function (response) {
                $("#ingredientName").val("");
                $("#ingredientExplanation").val("");
                console.log(response);

                $.ajax({
                    type: "post",
                    url: "/ingredient/count",
                    success: function (response) {
                        $("#ingredientCount").text(response);
                        console.log(response);
                    }
                })
            }
        })

    });
});
