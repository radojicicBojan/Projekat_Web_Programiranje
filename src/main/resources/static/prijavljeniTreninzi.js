let id = localStorage.getItem("ID");

$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/termini/prikazPrijavljenihTreninga/" + id,
        dataType: "json",
        success: function (response) {
            trainings=response;
            console.log("SUCCESS:\n", response);
            for (let trening of response) {
                let row = "<tr class=\"table-secondary\">";
                row += "<td>" + trening.id + "</td>";
                row += "<td>" + trening.naziv + "</td>";
                row += "<td>" + trening.opis + "</td>";
                row += "<td>" + trening.tipTreninga + "</td>";
                row += "<td>" + trening.trajanje + "</td>";
                row += "<td>" + trening.oznaka + "</td>";
                row += "<td>" + trening.cena + "</td>";
                row += "<td>" + trening.vremePocetka.slice(0, 16).split('T').join(' '); + "</td>";
                row += "<td>" + `<button class='btn btn-primary' onclick='otkazivanje()' '>Otkaži</button></td>"`;

                $('#prijavljeniTreninzi').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});

function otkazivanje(){
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/termini/otkazivanjePrijave/" + id,
        dataType: "text",
        contentType: "application/json",
        data: JSON.stringify(window.localStorage.getItem("ID")),
        success: function (response) {
            console.log(response);

            alert("Uspešno ste otkazali trening!");
            window.location.href = "terminDetails.html?id=" + id;
        },
        error: function () {
            alert("Greška prilikom otkazivanja!");
        }
    });
}