let uloga = localStorage.getItem("ULOGA");
let id = new URL(window.location.href).searchParams.get("id");


$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/treninzi/prosireniPrikazTreninga/" + id +"?uloga=" + uloga,
        dataType: "json",
        success: function (response) {
            trainings=response;
            console.log("SUCCESS:\n", response);
            let trening = response;
                    let row = "<tr class=\"table-secondary\">";
                    row += "<td>" + trening.id + "</td>";
                    row += "<td>" + trening.naziv + "</td>";
                    row += "<td>" + trening.opis + "</td>";
                    row += "<td>" + trening.tipTreninga + "</td>";
                    row += "<td>" + trening.trajanje + "</td>";
                    row += "<td>" + id + "</td>";
                    row += "<td>" + trening.cena + "</td>";
                    row += "<td>" + trening.vremePocetka.slice(0, 16).split('T').join(' '); + "</td>";
                    row += "<td>" + trening.oznaka + "</td>";
                    row += "<td>" + trening.kapacitet + "</td>";
                    row += "<td>" + trening.brojPrijavljenihClanova + "</td>";
                    row += "<td>" + trening.brojSlobodnihMesta + "</td>";
                    row += "<td>" + `<button class='btn btn-primary' onclick='prijava()' '>Prijavi se</button></td>"`;

                    let brojPrijavljenihClanova = trening.brojPrijavljenihClanova;
                    $('#trainings').append(row);
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});
function prijava(){
    let uloga = window.localStorage.getItem("ULOGA");
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/termini/prijavaZaTrening/" + id + "?uloga=" + uloga,
        dataType: "text",
        contentType: "application/json",
        data: JSON.stringify(window.localStorage.getItem("ID")),
        success: function (response) {
            console.log(response);

            alert("Uspešno ste se prijavili za trening!");
            window.location.href = "prijavljeniTreninzi.html";
        },
        error: function () {
            alert("Greška prilikom prijavljivanja!");
        }
    });
}



