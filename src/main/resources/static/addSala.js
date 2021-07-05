$(document).on("submit", "#addingSala", function (event) {
    event.preventDefault();
    console.log('test');
    // preuzimamo vrednosti unete u formi
    let kapacitet = $("#capacity").val();
    let oznaka = $("#oznaka").val();
    let fitnesCentarID = $("#fitnesCentri").val();

    let novaSala = {
        kapacitet,
        oznaka,
        fitnesCentarID
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
            window.location.href = "sala.html?id="+response.fitnesCentarID;
        },
        error: function () {
            alert("Greška prilikom dodavanja Sale!");
        }
    });
});

$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/fitnesCentri",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);
            for (let fitnesCentar of response) {
                    $('#fitnesCentri').append("<option value='"+ fitnesCentar.id +"'>" + fitnesCentar.naziv + "</option>");
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});