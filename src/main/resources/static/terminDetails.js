let uloga = localStorage.getItem("ULOGA");
let id = new URL(window.location.href).searchParams.get("id");


$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/treninzi/prosireniPrikazTreninga/" + id,
        dataType: "json",
        success: function (response) {
            trainings=response;
            console.log("SUCCESS:\n", response);
            let trening = response;
                for(let termin of trening.listaTermina) {
                    let row = "<tr class=\"table-secondary\">";
                    idd = termin.id;
                    row += "<td>" + trening.id + "</td>";
                    row += "<td>" + trening.naziv + "</td>";
                    row += "<td>" + trening.opis + "</td>";
                    row += "<td>" + trening.tipTreninga + "</td>";
                    row += "<td>" + trening.trajanje + "</td>";
                    row += "<td>" + termin.id + "</td>";
                    row += "<td>" + termin.cena + "</td>";
                    row += "<td>" + termin.vremePocetka.slice(0, 16).split('T').join(' '); + "</td>";
                    row += "<td>" + `<button class='btn btn-primary' onclick=location.href="terminDetails.html?id="+idd>Odaberi</button></td>"`;

                    $('#trainings').append(row);
                }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});