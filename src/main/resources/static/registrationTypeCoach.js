$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/fitnesCentri/prikaz",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);
            for (let fitnesCentar of response) {
                $('#fitnesCentri').append("<option value='"+ fitnesCentar.id +"'>" + fitnesCentar.naziv + "</option>");
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});

$(document).on("submit", "#registrationTypeCoach", function (event) {
    event.preventDefault();
    console.log('test');
    // preuzimamo vrednosti unete u formi
    let korisnickoIme = $("#username").val();
    let lozinka = $("#password").val();
    let ime = $("#name1").val();
    let prezime = $("#lastname").val();
    let telefon = $("#phone").val();
    let email = $("#email").val();
    let datumRodjenja = $("#date").val();
    let uloga = "TRENER";
    let fitnesCentarId = $("#fitnesCentri").val();


    let Trener = {
        korisnickoIme,
        lozinka,
        ime,
        prezime,
        telefon,
        email,
        datumRodjenja,
        uloga,
        fitnesCentarId
    }


    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/registration",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(Trener),
        success: function (response) {
            console.log(response);

            alert("Trener " + response.id + " je uspešno registrovan!");
            window.location.href = "registrationCoachByAdmin.html";
        },
        error: function () {
            alert("Greška prilikom dodavanja trenera!");
        }
    });
});
