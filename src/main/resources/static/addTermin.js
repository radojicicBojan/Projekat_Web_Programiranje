let id = new URL(window.location.href).searchParams.get("id");
let ID = localStorage.getItem("ID")


$(document).on("submit", "#addTermin", function (event) {
    event.preventDefault();
    console.log('test');
    let vremePocetka = $("#date").val();
    let cena = $("#price").val();
    let sala_id = $("#sale").val();
    let fitnesCentarId = $("#fitnesCentar").val();

    let novTermin = {
        vremePocetka,
        cena,
        sala_id,
        fitnesCentarId
    }

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/treninzi/dodavanjeTermina/" + ID +"/"+ sala_id,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(novTermin),
        success: function (response) {
            console.log(response);

            alert("Termin " + response.id + " je uspešno dodat!");
            window.location.href = "seeTrainings.html?id=" + ID;
        },
        error: function () {
            alert("Greška prilikom dodavanja Termina!");
        }
    });
});

$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/sale/fitnesCentar/"+ 1,
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);
            for (let sala of response) {
                $('#sale').append("<option value='"+ sala.id + "'>" + sala.oznaka + "</option>");
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});
