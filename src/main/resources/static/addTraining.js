let uloga = localStorage.getItem("ULOGA");
let idd;
let trainings;
let filtriraniTreninzi;
$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/treninzi/prikazTreninga",
        dataType: "json",
        success: function (response) {
            trainings=response;
            filtriraniTreninzi = JSON.parse(JSON.stringify(trainings));
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
                    if(uloga == "CLAN") {
                        row += "<td>" + `<button class='btn btn-primary' onclick=location.href="terminDetails.html?id=${termin.id}">Odaberi</button></td>"`;
                    }
                    $('#listTrainings').append(row);
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

            alert("Fitnes Centar " + response.id + " je uspe??no dodat!");
            window.location.href = "addFitnesCentar.html";
        },
        error: function () {
            alert("Gre??ka prilikom dodavanja Fitnes Centra!");
        }
    });
});

function poNazivu() {
    let naziv = $("#name1").val();
    let tip = $("#type").val();
    let opis = $("#description").val();
    let cena = $("#price").val();
    let vremePocetka = $("#termTime").val();


    filtriraniTreninzi = JSON.parse(JSON.stringify(trainings));
    if (naziv != "") {
        filtriraniTreninzi = filtriraniTreninzi.filter(function (trening) {
            return trening.naziv.includes(naziv);
        })
    }
    if (tip != "") {
        filtriraniTreninzi = filtriraniTreninzi.filter(function (trening) {
            return trening.tipTreninga.includes(tip);
        })
    }
    if (opis != "") {
        filtriraniTreninzi = filtriraniTreninzi.filter(function (trening) {
            return trening.opis.includes(opis);
        })
    }
    if (cena != "") {
        console.log(filtriraniTreninzi);
        for (let i in filtriraniTreninzi) {
            filtriraniTreninzi[i].listaTermina = filtriraniTreninzi[i].listaTermina.filter(function (termin) {
                return termin.cena <= cena;
            })
        }
    }

    if (vremePocetka != "") {
        console.log(filtriraniTreninzi);
        for (let i in filtriraniTreninzi) {
            filtriraniTreninzi[i].listaTermina = filtriraniTreninzi[i].listaTermina.filter(function (termin) {
                return (termin.vremePocetka > vremePocetka);
            })
        }
    }

    if ($("#priceSort").val() != "nothing") {
        sortiraj();
    } else {
        $('#listTrainings tbody').html("");
        for (let trening of filtriraniTreninzi) {
            for (let termin of trening.listaTermina) {
                let row = "<tr class=\"table-secondary\">";
                row += "<td>" + trening.id + "</td>";
                row += "<td>" + trening.naziv + "</td>";
                row += "<td>" + trening.opis + "</td>";
                row += "<td>" + trening.tipTreninga + "</td>";
                row += "<td>" + trening.trajanje + "</td>";
                row += "<td>" + termin.id + "</td>";
                row += "<td>" + termin.cena + "</td>";
                row += "<td>" + termin.vremePocetka.slice(0, 16).split('T').join(' ');
                +"</td>";
                $('#listTrainings').append(row);
            }
        }
    }
}
    function sortiraj() {
        let priceSort = $("#priceSort").val();
        let preSort = [];
        for (let trening of filtriraniTreninzi) {
            for(let termin of trening.listaTermina) {
                preSort.push({
                    id:trening.id,
                    naziv:trening.naziv,
                    opis:trening.opis,
                    tipTreninga: trening.tipTreninga,
                    trajanje: trening.trajanje,
                    termin: {
                        id: termin.id,
                        cena: termin.cena,
                        vremePocetka: termin.vremePocetka,
                    }
                })
            }
        }
        if(priceSort == "risingPrice"){
            preSort.sort(function (a, b){
                return a.termin.cena - b.termin.cena;
            });
        }else if(priceSort == "fallingPrice"){
            preSort.sort(function (b, a){
                return a.termin.cena - b.termin.cena;
            });
        }
        else if(priceSort == "risingTime"){
            preSort.sort(function (a, b){
                return new Date(a.termin.vremePocetka) - new Date( b.termin.vremePocetka);
            });
        }
        else if(priceSort == "fallingTime"){
            preSort.sort(function (b, a){
                return new Date(a.termin.vremePocetka) - new Date(b.termin.vremePocetka);
            });
        }
        $('#listTrainings tbody').html("");
        for (let trening of preSort) {
                let row = "<tr class=\"table-secondary\">";
                row += "<td>" + trening.id + "</td>";
                row += "<td>" + trening.naziv + "</td>";
                row += "<td>" + trening.opis + "</td>";
                row += "<td>" + trening.tipTreninga + "</td>";
                row += "<td>" + trening.trajanje + "</td>";
                row += "<td>" + trening.termin.id + "</td>";
                row += "<td>" + trening.termin.cena + "</td>";
                row += "<td>" + trening.termin.vremePocetka.slice(0, 16).split('T').join(' '); + "</td>";
                $('#listTrainings tbody').append(row);
        }
}
if(localStorage.getItem("ULOGA")  == "CLAN")
{
    document.getElementById("details").style.display = "";
}