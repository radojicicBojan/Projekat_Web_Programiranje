let id = new URL(window.location.href).searchParams.get("id");

$.ajax({
    type: "PUT",
    url: "http://localhost:8080/api/sale/fitnesCentar" + id,
    dataType: "json",
    success: function (response) {
        console.log("SUCCESS:\n", response);
        $("#capacity").val(response.kapacitet)
        $("#oznaka").val(response.oznaka)
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

    let newSala = {
        kapacitet,
        oznaka
    }

    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/api/sale/" + id,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newSala),
        success: function (response) {
            console.log(response);

            alert("Sala " + response.id + " je uspešno izmenjen!");
            window.location.href = "sala.html";
        },
        error: function () {
            alert("Greška prilikom izmene Sale!");
        }
    });
});