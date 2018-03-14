$(function () {
    // 搜索框绑定键盘输入事件
    $("#queryDevice").on('shown.bs.select', function (e) {
        console.log('展开之后');
        $('#queryDevice').prev().find("input").keydown(function () {
            $('#queryDevice').prev().find("input").attr('id', "deviceInput"); //为input增加id属性
            console.log($('#deviceInput').val()); //获取输入框值输出到控制台
            if ($('#deviceInput').val().trim() != "" && $('#deviceInput').val().trim() != null && $('#deviceInput').val().trim() != "undefined"){
                getArealList($('#deviceInput').val().trim())
            }
        })
    })
})

/**
 * 将后台返回的列表显示出来
 * @param name
 */
function getArealList(name) {//获取位置列表
    $.ajax({
        url: "/map/getMapByName",
        type: "get",
        dataType: "json",
        data: {'name': name},
        success: function (data) {
            $.each(data, function (i) {
                $('.selectpicker').append("<option value=" + data[i].lng + "," + data[i].lat + ">" + data[i].name + "</option>");

            });
            $('.selectpicker').selectpicker('refresh');

        },

        error: function (data) {

            alert("查询学校失败" + data);

        }
    })

}

