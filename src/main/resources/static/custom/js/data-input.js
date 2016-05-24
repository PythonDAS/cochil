/**
 * Created by donghoon on 2016. 5. 23..
 */
$(document).ready(function () {
    $("#igSubmit").on("click", function () {
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
                    url: "/ingredient/igCount",
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

    $("#mfSubmit").on("click", function () {
        var manufacturerName = $("#manufacturerName").val();
        var mfNationality = $(':radio[name="mfNationality"]:checked').val();
        console.log("name: " + manufacturerName + ", nationalityCode: " + mfNationality);

        $.ajax({
            type: "post",
            url: "/manufacturer/save",
            dataType: "json",
            data: {
                name: manufacturerName,
                nationalityCode: mfNationality
            },
            success: function (response) {
                console.log("제조사 저장 성공.");
                console.log(response);

                $.ajax({
                    type: "post",
                    url: "/manufacturer/mfCount",
                    success: function (response) {
                        $("#manufacturerCount").text(response);
                        console.log(response);
                    }
                })
            },
            error: function (error) {
                console.log("성분 저장 실패.");
                console.log(error);
                if (error.responseText === "") {
                    $("#manufacturerName").attr("placeholder", "이름은 비어 있으면 안됩니다.");
                }
            }
        })

    });
});
