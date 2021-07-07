let id = new URL(window.location.href).searchParams.get("id");
$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/treninzi/prikazTreninga/" + id,
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);
            for (let trening of response) {
                for(let termin of trening.listaTermina) {
                    let row = "<tr class=\"table-secondary\">";
                    row += "<td>" + trening.id + "</td>";
                    row += "<td>" + trening.naziv + "</td>";
                    row += "<td>" + trening.opis + "</td>";
                    row += "<td>" + trening.tipTreninga + "</td>";
                    row += "<td>" + trening.trajanje + "</td>";
                    row += "<td>" + termin.id + "</td>";
                    row += "<td>" + termin.cena + "</td>";
                    row += "<td>" + termin.vremePocetka.slice(0, 16).split('T').join(' '); + "</td>";
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