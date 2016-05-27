/**
 * Created by donghoon on 2016. 5. 23..
 */
$(document).ready(function () {
    var editor = CKEDITOR.replace("ingredientEditor");
    $(".ingredient-multiple").select2();

    $("#igSubmit").on("click", function () {
        var ingredientName = $("#ingredientName").val();
        var ingredientExplanation = editor.getData();

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
                $("#ingredientName").attr("placeholder", "ex) 자일리톨");
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
                $("#manufacturerName").val("");
                $("#manufacturerName").attr("placeholder", "ex) LG 화학");
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
                console.log("제조사 저장 실패.");
                console.log(error);
                if (error.responseText === "") {
                    $("#manufacturerName").attr("placeholder", "이름은 비어 있으면 안됩니다.");
                }
            }
        })
    });

    $("#prSubmit").on("click", function () {
        var productName = $("#productName").val();
        var productCode = $(':radio[name="productCode"]:checked').val();
        var ingredientList = $("#select-ingredient option:selected").val();
        console.log("name: " + productName + ", productCode: " + productCode + ", ingredientList: " + ingredientList);

        $.ajax({
            type: "post",
            url: "/product/save",
            dataType: "json",
            data: {
                name: productName,
                productCode: productCode,
                ingredientList: ingredientList
            },
            success: function (response) {
                console.log("상품 저장 성공.");
                $("#productName").val("");
                $("#productName").attr("placeholder", "ex) 어린이 2080");
                console.log(response);

                $.ajax({
                    type: "post",
                    url: "/product/prCount",
                    success: function (response) {
                        $("#productCount").text(response);
                        console.log(response);
                    }
                })
            },
            error: function (error) {
                console.log("상품 저장 실패.");
                console.log(error);
                if (error.responseText === "") {
                    $("#productName").attr("placeholder", "이름은 비어 있으면 안됩니다.");
                }
            }
        })
    });

});
