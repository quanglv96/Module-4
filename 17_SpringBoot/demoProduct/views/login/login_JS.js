function login() {
    let username = $("#username").val()
    let password = $("#password").val()
    let user = {
        username: username,
        password: password,
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(user),
        url: "http://localhost:8080/users/login",
        success: function (data) {
            sessionStorage.setItem("token", data.accessToken)
            window.location.href = "list.html"
        }
    })
    event.preventDefault();
}