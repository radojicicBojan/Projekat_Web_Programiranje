// Prikaz svih zaposlenih
$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    // ajax poziv za dobavljanje svih zaposlenih sa backend-a i prikaz u tabeli
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/treninzi/prikazTreninga",
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
                    $('#treninzi').append(row);
                }
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});

function aktivan(){
    var chb = document.getElementsByClassName('chb');
    for(let j=0; j<chb.length; j++) {
        if (chb[j].checked) {

            $(chb[j]).closest("tr").remove();
        }
    }
}

$(document).on("submit", "#addingFitnesCentar", function (event) {
    event.preventDefault();
    console.log('test');
    // preuzimamo vrednosti unete u formi
    let naziv = $("#name1").val();
    let adresa = $("#adress").val();
    let telefon = $("#phone").val();
    let email = $("#email").val();

    let newFitnesCentar = {
        naziv,
        adresa,
        telefon,
        email
    }

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/dodavanjeFitnesCentra",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newFitnesCentar),
        success: function (response) {
            console.log(response);

            alert("Fitnes Centar " + response.id + " je uspešno dodat!");
            window.location.href = "fitnesCentar.html";
        },
        error: function () {
            alert("Greška prilikom dodavanja Fitnes Centra!");
        }
    });
});