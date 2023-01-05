function addCategory() {
    let name = document.getElementById("nameCategory").value;
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(name),
        //tên API
        url: "http://localhost:8080/category",
        //xử lý khi thành công
        success: function (data) {
            window.location.href = "list.html";
        }
    });
    event.preventDefault();
}
function openFormCategory(){
    window.location.href="addNewCategory.html";
}