$(function () {
    // 搜索框绑定键盘输入事件
    $("#queryDevice").on('shown.bs.select', function (e) {
        console.log('展开之后');

        // 键盘按下触发事件
        // $('#queryDevice').prev().find("input").keydown(function () {
        //     $('#queryDevice').prev().find("input").attr('id', "deviceInput"); //为input增加id属性
        //     console.log($('#deviceInput').val()); //获取输入框值输出到控制台
        //     if ($('#deviceInput').val().trim().length > 0 && $('#deviceInput').val().trim() != null && $('#deviceInput').val().trim() != "undefined") {
        //             getArealList($('#deviceInput').val().trim())
        //
        //     }
        // })

        // 连续输入中断触发事件
        $('#queryDevice').prev().find("input").attr('id', "deviceInput"); //为input增加id属性
        $(function () {
            $('#deviceInput').koala({
                delay: 300,
                keyup: function (event) {
                    if ($('#deviceInput').val().trim().length > 0 && $('#deviceInput').val().trim() != null && $('#deviceInput').val().trim() != "undefined") {
                        getArealList($('#deviceInput').val().trim())

                    }
                }
            });

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
            $('.selectpicker').empty()
            $.each(data, function (i) {
                $('.selectpicker').append("<option value=" + data[i].lng + "," + data[i].lat + "," + data[i].id + ">" + data[i].name + "</option>");

            });
            $('.selectpicker').selectpicker('refresh');

        },

        error: function (data) {

            alert("查询学校失败" + data);

        }
    })

}

/**
 * bootstrap-select 中选择事件
 * @param obj
 */
function selectOnchang(obj) {
    console.log("经度，纬度是：" + obj.options[obj.selectedIndex].value)
    console.log(obj)
    var lnglat = obj.options[obj.selectedIndex].value;
    var pitchName = $(obj.options[obj.selectedIndex]).text();
    console.log("当前选择的地名为：" + pitchName)
    var lng = lnglat.split(",")[0]
    var lat = lnglat.split(",")[1]
    var pitchId = lnglat.split(",")[2]
    markPositionAndSetCenter(lat, lng, pitchName)
}

/**
 * 获取一些poi地址用来在地图上标记
 */
function initMark() {
    $.ajax({
        url: "/map/getAllMap",
        type: "get",
        dataType: "json",
        data: {"page": 1, "rows": 100},
        success: function (data) {
            $(data).each(function (index, item) {
                markPosition(item.lat, item.lng, item.name);
            });
        },
        error: function () {

        }
    })
}

/**
 * 地图上的点击事件
 * @param e
 */
function onMapClick(e) {
    popup
        .setLatLng(e.latlng)
        .setContent("当前点击位置的纬度,经度 " + e.latlng.toString())
        .openOn(map);
}
