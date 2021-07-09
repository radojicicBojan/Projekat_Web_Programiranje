let id = new URL(window.location.href).searchParams.get("id");
let uloga = localStorage.getItem("ULOGA");

$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/treninzi/prikazListeTreninga/" + id + "?uloga=" + uloga,
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);
            for (let trening of response) {
                    let row = "<tr class=\"table-secondary\">";
                    row += "<td>" + trening.naziv + "</td>";
                    row += "<td>" + trening.opis + "</td>";
                    row += "<td>" + trening.tipTreninga + "</td>";
                    row += "<td>" + trening.trajanje + "</td>";
                    row += "<td><a href=\"changeTraining.html?id=" + trening.id + "\" type=\"button\" class=\"btn btn-primary\">Izmeni</a></td>";
                    row += "<td><a href=\"addTermin.html?id=" + trening.id + "\" type=\"button\" class=\"btn btn-primary\">Dodaj</a></td>";
                    $('#treninzi').append(row);
                }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});