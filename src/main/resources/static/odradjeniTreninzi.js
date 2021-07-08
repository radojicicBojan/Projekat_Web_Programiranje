let id = localStorage.getItem("ID");

$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/termini/prikazOdradjenihTreninga/" + id,
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
                row += "<td>" + trening.ocena + "</td>";

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
        url: "http://localhost:8080/api/termini/prikazOdradjenihTreninga/" + id,
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
                    row += "<td>" + `<button onclick='oceni()' class='btn btn-primary'>Oceni</button></td>"`;

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
        url: "http://localhost:8080/api/termini/prikazOdradjenihTreninga/" + id,
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

function oceni(){
    /*let ids = [];
    var rb = document.getElementsByClassName('rb');
    for(let j=0; j<rb.length; j++) {
        if (rb[j].checked) {
            ids.push($(rb[j]).attr("fitnesCentar_id"));
            $(rb[j]).closest("tr").remove();
        }
    }*/
    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/api/termini/oceni/" + id/ + ID,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(ids),
        success: function (response) {
            alert("Obrisan Fitnes centar sa ID-jem: " + ids.join(","));
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
}