function newRegistration(){
    let username=document.getElementById("username").value;
    let pass=document.getElementById("pass").value;
    let user={
        username: username,
        password:  pass
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(user),
        //tên API
        url: "http://localhost:8080/users/registration",
        //xử lý khi thành công
        success: function (data) {
            window.location.href = "list.html";
        }
    });
    event.preventDefault();
}