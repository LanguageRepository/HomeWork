/**
 * Created by kvasa on 07.12.2016.
 */
function createAccount() {
    var username = document.getElementById("inputUsername").value;
    var password = document.getElementById("inputPassword").value;
    var result = {"username" : username,
                  "password": password};
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: '/account',
        data: JSON.stringify(result),
        dataType: 'json',
        success: function () {
            alert("User created");
        }
    });

}