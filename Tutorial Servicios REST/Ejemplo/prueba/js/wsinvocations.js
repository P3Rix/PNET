// CODIGO DE wsinvocations.js

function getMobile(mobileId) {
    var myUrl = "http://localhost:8080/mobiles/" + mobileId;
    $.ajax({
    type: "GET",
    dataType: "json",
    url: myUrl,
    success: function(data) {
    $("#resGetHello").html(JSON.stringify(data));
    },
    error: function(res) {
    alert("ERROR " + res.statusText);
}
});
}

// CODIGO DE wsinvocations.js

function postMobile() {
    $.ajax({
    type: "POST",
    url: "http://localhost:8080/mobiles/",
    contentType: "application/json",
    dataType: "text",
    data: JSON.stringify({
        "brand": "Apple",
        "name": "iPhone 6 64 gb",
        "price": 455
    }),
    success: function(data) {
    $("#resGetHello").html(data);
    },
    error: function(res) {
    alert("ERROR " + res.statusText);
}
});
}


// CODIGO DE wsinvocations.js

function getMobiles() {
    var myUrl = "http://localhost:8080/mobiles/";
    $.ajax({
    type: "GET",
    dataType: "json",
    url: myUrl,
    success: function(data) {
    $("#resGetHello").html(JSON.stringify(data));
    },
    error: function(res) {
    alert("ERROR " + res.statusText);
}
});
}

// CODIGO DE wsinvocations.js

function putMobile(mobileId) {
    var myUrl = "http://localhost:8080/mobiles/" + mobileId;
    $.ajax({
    type: "PUT",
    dataType: "json",
    url: myUrl,  
    data: ({
        "brand": "Samsung",
        "name": "Samsung Galaxy 7",
        "price": 360
    }),
    success: function(data) {
    $("#resGetHello").html(JSON.stringify(data));
    },
    error: function(res) {
    alert("ERROR " + res.statusText);
}
});
}

function deleteMobiles() {
    var myUrl = "http://localhost:8080/mobiles/";
    $.ajax({
    type: "DELETE",
    url: myUrl,  
    success: function(data) {
    $("#resGetHello").html(JSON.stringify(data));
    },
    error: function(res) {
    alert("ERROR " + res.statusText);
}
});
}

function deleteMobile(mobileId) {
    var myUrl = "http://localhost:8080/mobiles/" + mobileId ;
    $.ajax({
    type: "DELETE",
    url: myUrl,  
    success: function(data) {
    $("#resGetHello").html(JSON.stringify(data));
    },
    error: function(res) {
    alert("ERROR " + res.statusText);
}
});
}