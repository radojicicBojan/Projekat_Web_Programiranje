let id = localStorage.getItem("ID");
let uloga = localStorage.getItem("ULOGA");

$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/termini/prikazOdradjenihTreninga/" + id + "?uloga=" + uloga,
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

                $('#odradjeniTreninzi').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});

$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/termini/prikazOdradjenihTreninga/" + id + "?uloga=" + uloga,
        dataType: "json",
        success: function (response) {
            trainings=response;
            console.log("SUCCESS:\n", response);
            for (let trening of response) {
                if(trening.ocena == null){
                    let row = "<tr class=\"table-secondary\">";
                    row += "<td>" + trening.id + "</td>";
                    row += "<td>" + trening.naziv + "</td>";
                    row += "<td>" + trening.opis + "</td>";
                    row += "<td>" + trening.tipTreninga + "</td>";
                    row += "<td>" + trening.trajanje + "</td>";
                    row += "<td>" + trening.oznaka + "</td>";
                    row += "<td>" + trening.cena + "</td>";
                    row += "<td>" + `<input id='oceni' style='width: 50px'></input></td>"`;
                    row += "<td>" + `<button onclick='oceni(${trening.terminId})' class='btn btn-primary'>Oceni</button></td>"`;

                    $('#neocenjeniTreninzi').append(row);
                }
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});

$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/termini/prikazOdradjenihTreninga/" + id + "?uloga=" + uloga,
        dataType: "json",
        success: function (response) {
            trainings=response;
            console.log("SUCCESS:\n", response);
            for (let trening of response) {
                if(trening.ocena != null){
                    let row = "<tr class=\"table-secondary\">";
                    row += "<td>" + trening.id + "</td>";
                    row += "<td>" + trening.naziv + "</td>";
                    row += "<td>" + trening.opis + "</td>";
                    row += "<td>" + trening.tipTreninga + "</td>";
                    row += "<td>" + trening.trajanje + "</td>";
                    row += "<td>" + trening.oznaka + "</td>";
                    row += "<td>" + trening.cena + "</td>";
                    row += "<td>" + trening.ocena + "</td>";

                    $('#ocenjeniTreninzi').append(row);
                }
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});

function oceni(terminId){

    let ocena = document.getElementById('oceni').value;

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/termini/oceni/" + terminId +"/"+ id + "?uloga=" + uloga,
        contentType: "application/json",
        dataType: "text",
        data: JSON.stringify(ocena),
        success: function (response) {
            window.location.href="ocenjeniTreninzi.html";
            alert("Uspešno ocenjen ");
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
}