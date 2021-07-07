let id = new URL(window.location.href).searchParams.get("id");

$.ajax({
    type: "GET",
    url: "http://localhost:8080/api/termini/ispis/" + id,
    dataType: "json",
    success: function (response) {
        console.log("SUCCESS:\n", response);
        $("#name1").val(response.naziv);
        $("#description").val(response.opis);
        $("#type").val(response.tipTreninga);
        $("#duration").val(response.trajanje);
        $("#time").val(response.vremePocetka);
        $("#price").val(response.cena);

    },
    error: function (response) {
        console.log("ERROR:\n", response);
    }
});

$(document).on("submit", "#changeTermin", function (event) {
    event.preventDefault();
    console.log('test');
    // preuzimamo vrednosti unete u formi
    let name = $("#name1").val();
    let description = $("#description").val();
    let type = $("#type").val();
    let duration = $("#duration").val();
    let time = $("#time").val();
    let price = $("#price").val();

    let newTermin = {
        name,
        description,
        type,
        duration,
        time,
        price
    }

    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/api/termini/izmena/" + id,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newTermin),
        success: function (response) {
            console.log(response);

            alert("Termin " + response.id + " je uspešno izmenjen!");
            window.location.href = "changeTermin.html";
        },
        error: function () {
            alert("Greška prilikom izmene Termina!");
        }
    });
});