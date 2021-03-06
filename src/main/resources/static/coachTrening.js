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
                for(let termin of trening.listaTermina) {
                    let row = "<tr class=\"table-secondary\">";
                    row += "<td>" + trening.naziv + "</td>";
                    row += "<td>" + trening.opis + "</td>";
                    row += "<td>" + trening.tipTreninga + "</td>";
                    row += "<td>" + trening.trajanje + "</td>";
                    row += "<td>" + termin.cena + "</td>";
                    row += "<td>" + termin.vremePocetka.slice(0, 16).split('T').join(' '); + "</td>";
                    row += "<td>" + termin.oznaka + "</td>";
                    row += "<td>" + termin.kapacitet + "</td>";
                    row += "<td><a href=\"changeTermin.html?id=" + termin.id + "\" type=\"button\" class=\"btn btn-primary\">Izmeni</a></td>";
                    $('#treninzi').append(row);
                }
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});