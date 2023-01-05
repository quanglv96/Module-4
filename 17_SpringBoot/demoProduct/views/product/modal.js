// Get the modal
var modal = document.getElementById("myModal");

// Get the button that opens the modal
var turnOnModal = document.getElementById("turnOnModal");

// Get the <span> element that closes the modal
var closeModal = document.getElementById("closeModal");

// When the user clicks on the button, open the modal
turnOnModal.onclick = function () {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
closeModal.onclick = function () {
    modal.style.display = "none";
}

// When the user clicks anywhere outsideof the modal, close it
window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}