/**
 * Created by donghoon on 2016. 5. 23..
 */
$(document).ready(function () {
    $("#submit").on("click", function () {
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
                console.log("성분 저장 성공.");

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
            },
            error: function (error) {
                console.log("성분 저장 실패.");
                console.log(error);
                if (error.responseText === "") {
                    $("#ingredientName").attr("placeholder", "이름은 비어 있으면 안됩니다.");
                    $("#ingredientExplanation").attr("placeholder", "내용은 비어 있으면 안됩니다.");
                }
            }
        })

    });
});
