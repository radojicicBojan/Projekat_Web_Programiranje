let id = localStorage.getItem("ID");

$.ajax({
    type: "GET",
    url: "http://localhost:8080/api/prikazKorisnika/" + id,
    dataType: "json",
    success: function (response) {
        console.log("SUCCESS:\n", response);
        $("#username").val(response.korisnickoIme)
        $("#password").val(response.lozinka)
        $("#password2").val(response.lozinka);
        $("#name1").val(response.ime)
        $("#lastname").val(response.prezime)
        $("#phone").val(response.telefon);
        $("#email").val(response.email);
        $("#date").val(response.datumRodjenja);


    },
    error: function (response) {
        console.log("ERROR:\n", response);
    }
});

$(document).on("submit", "#changeProfil", function (event) {
    event.preventDefault();
    console.log('test');
    let korisnickoIme = $("#username").val();
    let lozinka = $("#password").val();
    let ime = $("#name1").val();
    let prezime = $("#lastname").val();
    let telefon = $("#phone").val();
    let email = $("#email").val();
    let datumRodjenja = $("#date").val();

    let newProfil = {
        korisnickoIme,
        lozinka,
        ime,
        prezime,
        telefon,
        email,
        datumRodjenja
    }

    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/api/izmenaKorisnika/" + id,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newProfil),
        success: function (response) {
            console.log(response);

            alert("Profil " + response.id + " je uspešno izmenjen!");
            window.location.href = "homepage.html";
        },
        error: function () {
            alert("Greška prilikom izmene profila!");
        }
    });
});