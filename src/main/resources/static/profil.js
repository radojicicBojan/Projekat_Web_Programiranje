let id = localStorage.getItem("ID");

$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/prikazKorisnika/" + id,
        dataType: "json",
        success: function (response) {
            trainings=response;
            console.log("SUCCESS:\n", response);
            let korisnik = response;
            let row = "<tr class=\"table-secondary\">";
            let aktivan;
            if(korisnik.aktivan){
                aktivan = "Aktivan";
            }else{
                aktivan = "Neaktivan";
            }
            row += "<td>" + korisnik.uloga + "</td>";
            row += "<td>" + korisnik.id + "</td>";
            row += "<td>" + korisnik.ime + "</td>";
            row += "<td>" + korisnik.prezime + "</td>";
            row += "<td>" + korisnik.datumRodjenja.slice(0, 16). split('T').join(' '); + "</td>";
            row += "<td>" + korisnik.email + "</td>";
            row += "<td>" + korisnik.korisnickoIme + "</td>";
            row += "<td>" + korisnik.telefon + "</td>";
            row += "<td>" +  aktivan + "</td>";
            row += "<td><a href=\"changeProfil.html\" type=\"button\" class=\"btn btn-primary\">Izmeni</a></td>";
            $('#profil').append(row);
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});