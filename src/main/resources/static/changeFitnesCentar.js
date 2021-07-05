let id = new URL(window.location.href).searchParams.get("id");

$.ajax({
    type: "GET",
    url: "http://localhost:8080/api/fitnesCentri/" + id,
    dataType: "json",
    success: function (response) {
        console.log("SUCCESS:\n", response);
        $("#name1").val(response.naziv);
        $("#adress").val(response.adresa);
        $("#email").val(response.email);
        $("#phone").val(response.telefon);
    },
    error: function (response) {
        console.log("ERROR:\n", response);
    }
});

$(document).on("submit", "#changeFitnesCentar", function (event) {
    event.preventDefault();
    console.log('test');
    // preuzimamo vrednosti unete u formi
    let naziv = $("#name1").val();
    let adresa = $("#adress").val();
    let telefon = $("#phone").val();
    let email = $("#email").val();

    let newFitnesCentar = {
        naziv,
        adresa,
        telefon,
        email
    }

    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/api/fitnesCentri/" + id,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newFitnesCentar),
        success: function (response) {
            console.log(response);

            alert("Fitnes Centar " + response.id + " je uspešno izmenjen!");
            window.location.href = "fitnesCentar.html";
        },
        error: function () {
            alert("Greška prilikom izmene Fitnes Centra!");
        }
    });
});