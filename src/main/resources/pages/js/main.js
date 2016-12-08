/**
 * Created by kvasa on 07.12.2016.
 */
function createAccount() {
    var username = document.getElementById("inputUsername").value;
    var password = document.getElementById("inputPassword").value;
    var result = {"username" : username,
                  "password": password};
    if(isAccountValid()) {
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: '/account',
            data: JSON.stringify(result),
            dataType: 'json',
            success: function (data) {
                alert("User created");
            }
        });
    } else {
        alert("Заполните поля");
    }
}
function isAccountValid() {
    var result;
    var checkUsername = document.getElementById('inputUsername').value.length;
    var checkPassword = document.getElementById('inputPassword').value.length;
    var checkName = document.getElementById('inputName').value.length;
    if(checkUsername == 0 || checkPassword == 0 || checkName == 0) {
        result = false;
    } else {
        result = true;
    }
    return result;
}