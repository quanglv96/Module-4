// list product
function displayProduct() {
    $.ajax({
        type: "GET",
        //tên API
        url: "http://localhost:8080/products",
        success: function (data) {
            let content = '<table class="table table-striped"><tr>\n' +
                '        <td>#</td><td>ID</td>\n' +
                '        <td>Name</td>\n' +
                '        <td>Price</td>\n' +
                '        <td>Image</td>\n' +
                '        <td>Category</td>\n' +
                '        <td colspan="2">Action</td>\n' +
                '    </tr>';
            for (let i = 0; i < data.length; i++) {
                content += getProduct(data[i], i);
            }
            content += "</table>";
            filedCategory(0);
            document.getElementById('listProduct').innerHTML = content;
            clearModal();
        }
    });
}

//toString
function clearModal() {
    document.getElementById("img").value = null;
    document.getElementById("btn").value = "ADD";
    document.getElementById("id_product").value = 0;
    document.getElementById("img").value = "";
    document.getElementById("name").value = "";
    document.getElementById("price").value = "";

}

function getProduct(products, i) {
    return `<tr><td>${i}</td><td>${products.id_product}</td>` +
        `<td >${products.name}</td>` +
        `<td>${products.price} $</td>` +
        `<td><img height="50px" width="50px" src="../../src/main/resources/image/${products.image}"</td>` +
        `<td>${products.category.name}</td>` +
        `<td><button class="btn btn-danger" onclick="deleteProduct(${products.id_product})">Delete</td>` +
        `<td><button class="btn btn-warning" onclick="fieldEditProduct(${products.id_product})">Update</td></tr>`;

}


function deleteProduct(index) {
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            // Authorization: "Bearer " + token
        },
        type: "DELETE",
        //tên API
        url: "http://localhost:8080/products/" + index,
        success: displayProduct
    });
    event.preventDefault();
}

function filedCategory(index) {
    $.ajax({
        type: "GET",
        //tên API
        url: "http://localhost:8080/category",
        //xử lý khi thành công
        success: function (data) {
            let content = ""
            for (let i = 0; i < data.length; i++) {
                if (index === data[i].id_category) {
                    content += `<option  value="${data[i].id_category}" selected="selected">${data[i].name}</option>`
                } else {
                    content += `<option  value="${data[i].id_category}">${data[i].name}</option>`
                }

            }
            document.getElementById("listCategory").innerHTML = content;
        }
    });
}


function addNewProduct() {
    let formData = new FormData($('#formDemo')[0]);
    $.ajax({
        type: "POST",
        data: formData,
        enctype: "multipart/form-data",
        contentType: false,
        processData: false,
        //tên API
        url: "http://localhost:8080/products",
        success: function () {
            modal.style.display = "none";
            displayProduct()
        }
    });
    event.preventDefault();
}

// edit
function fieldEditProduct(index) {
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            // Authorization: "Bearer " + token
        },
        type: "GET",
        //tên API
        url: "http://localhost:8080/products/" + index,
        //xử lý khi thành công
        success: function (data) {
            filedCategory(data.category.id_category);
            document.getElementById("btn").setAttribute("onclick", "updateProduct(" + index + ")")
            document.getElementById("btn").value = "Update";
            document.getElementById("name").value = data.name;
            document.getElementById("price").value = data.price;
            document.getElementById("id_product").value = data.id_product;
            modal.style.display = "block";
        }
    })
    event.preventDefault();
}

function updateProduct(index) {
    let formData = new FormData($('#formDemo')[0]);
    $.ajax({
        headers: {
            // Authorization: "Bearer " + token
        },
        type: "PUT",
        enctype: "multipart/form-data",
        contentType: false,
        processData: false,
        data: formData,
        //tên API
        url: "http://localhost:8080/products",
        //xử lý khi thành công
        success: function () {
            modal.style.display = "none";
            displayProduct()
            document.getElementById("btn").setAttribute("onclick", "addNewProduct()");
            clearModal()
            filedCategory(0);
        }
    });
    //chặn sự kiện mặc định của thẻ
    event.preventDefault();
}

function search() {
    let text = document.getElementById("textSearch").value;
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "GET",
        //tên API
        url: "http://localhost:8080/products/search?search=" + text,
        //xử lý khi thành công
        success: function (data) {
            let content = '<table class="table table-striped"><tr>\n' +
                '        <td>#</td><td>ID</td>\n' +
                '        <td>Name</td>\n' +
                '        <td>Price</td>\n' +
                '        <td>Image</td>\n' +
                '        <td>Category</td>\n' +
                '        <td colspan="2">Action</td>\n' +
                '    </tr>';
            for (let i = 0; i < data.length; i++) {
                content += getProduct(data[i], i);
            }
            content += "</table>";
            filedCategory(0);
            document.getElementById('listProduct').innerHTML = content;
            clearModal();
        }
    });
    //chặn sự kiện mặc định của thẻ
    event.preventDefault();
}
