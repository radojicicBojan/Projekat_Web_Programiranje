$(document).on("submit", "#addingSala", function (event) {
    event.preventDefault();
    console.log('test');
    // preuzimamo vrednosti unete u formi
    let kapacitet = $("#capacity").val();
    let oznaka = $("#oznaka").val();

    let novaSala = {
        kapacitet,
        oznaka
    }

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/dodavanjeSale",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(novaSala),
        success: function (response) {
            console.log(response);

            alert("Sala " + response.id + " je uspešno dodata!");
            window.location.href = "addSala.html";
        },
        error: function () {
            alert("Greška prilikom dodavanja Sale!");
        }
    });
});