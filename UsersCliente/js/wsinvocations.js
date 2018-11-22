function getHello(){
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/",
        success: function(data){
            $("#resGetHello").html(data);      },
        error:function(res){
            alert("ERROR: "+ res.statusText);  }
    });
}

function postUser(nombre, apellido) {
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/users/",
        contentType: "application/json",
        dataType: "text",
        data: JSON.stringify({
            "firstname": nombre,
            "lastname": apellido,
        }),
        success: function(data) {
            $("#resGetHello").html(data);
        },
        error: function(res) {
            alert("ERROR " + res.statusText);
        }
    });
}

function getUsers()
{
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/users/",
        dataType: "text",
        success: function(data){
            $("#resGetHello").html(data);      },
        error:function(res){
            alert("ERROR: "+ res.statusText);  }
    });
}

function getUser(id){
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/users/" + id,
        success: function(data){
            $("#resGetHello").html(JSON.stringify(data));      },
        error:function(res){
            alert("ERROR: "+ res.statusText);  }
    });
}

function putUser(id){
    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/users/" + id,
        data: {
            "title": "Dunkirk",
            "director": "David Corral",
            "year": 2017
        },
        success: function(data){
            $("#resGetHello").html(JSON.stringify(data));      },
        error:function(res){
            alert("ERROR: "+ res.statusText);  }
    });
}

function deleteUsers()
{
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/users/",
        dataType: "text",
        success: function(data){
            $("#resGetHello").html(data);      },
        error:function(res){
            alert("ERROR: "+ res.statusText);  }
    });
}

function deleteUser(id)
{
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/users/" + id,
        dataType: "text",
        success: function(data){
            $("#resGetHello").html(data);      },
        error:function(res){
            alert("ERROR: "+ res.statusText);  }
    });
}