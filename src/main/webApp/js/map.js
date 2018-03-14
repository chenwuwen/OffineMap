/**
 * 标记位置
 * @param lat
 * @param lng
 */
function markPosition(lat, lng, pitchName) {
    console.log("mark lat: " + lat)
    console.log("mark lng: " + lng)
    // 将当前位置设为中心点
    //打标注
    L.marker([lat, lng], {icon: villageIcon}, 15).addTo(map)
        .bindPopup("<div class=''>" + pitchName + " " + lat + " " + lng + "</div>").openPopup();
}

/**
 * 标记位置并且设置中心点
 * @param lat
 * @param lng
 */
function markPositionAndSetCenter(lat, lng, pitchName) {
    console.log("mark lat: " + lat)
    console.log("mark lng: " + lng)
    // 将当前位置设为中心点
    map.setView([lat, lng], 12);
    //打标注
    L.marker([lat, lng], {icon: villageIcon}, 15).addTo(map)
        .bindPopup("<div class=''>" + pitchName + " " + lat + " " + lng + "</div>").openPopup();
}

/**
 * 标注圆圈
 * @param lat
 * @param lng
 */
function circlePosition(lat, lng) {
    L.circle([lat, lng], 5000, {
        color: 'red',
        fillColor: '#f03',
        fillOpacity: 0.5
    }).addTo(map).bindPopup("I am a circle.");
}


