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
                    row += "<td>" + `<button class='btn btn-primary' type='submit'>Prijavi se</button></td>"`;

                    let brojPrijavljenihClanova = trening.brojPrijavljenihClanova;
                    $('#trainings').append(row);
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});

$(document).on("submit", function (event) {
    event.preventDefault();
    console.log('test');


    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/api/treninzi/prijavaZaTrening" + id,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(brojPrijavljenihTreninga),
        success: function (response) {
            console.log(response);

            alert("Uspešno ste se prijavili za trening!");
            window.location.href = "terminDetails.html";
        },
        error: function () {
            alert("Greška prilikom prijavljivanja!");
        }
    });
});

