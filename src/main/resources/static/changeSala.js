let id = new URL(window.location.href).searchParams.get("id");
let uloga = localStorage.getItem("ULOGA");

$.ajax({
    type: "GET",
    url: "http://localhost:8080/api/sale/" + id + "?uloga=" + uloga,
    dataType: "json",
    success: function (response) {
        console.log("SUCCESS:\n", response);
        $("#capacity").val(response.kapacitet)
        $("#oznaka").val(response.oznaka)
        $("#fcid").val(response.fitnesCentarId);
    },
    error: function (response) {
        console.log("ERROR:\n", response);
    }
});

$(document).on("submit", "#changeSala", function (event) {
    event.preventDefault();
    console.log('test');
    let kapacitet = $("#capacity").val();
    let oznaka = $("#oznaka").val();
    let fitnesCentarId = $("#fcid").val();

    let newSala = {
        kapacitet,
        oznaka,
        fitnesCentarId
    }

    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/api/sale/" + id + "?uloga=" + uloga,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newSala),
        success: function (response) {
            console.log(response);

            alert("Sala " + response.id + " je uspešno izmenjen!");
            window.location.href = "sala.html?id="+ newSala.fitnesCentarId;
        },
        error: function () {
            alert("Greška prilikom izmene Sale!");
        }
    });
});