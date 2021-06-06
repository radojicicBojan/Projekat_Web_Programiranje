// Prikaz svih zaposlenih
$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    // ajax poziv za dobavljanje svih zaposlenih sa backend-a i prikaz u tabeli
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/approval",
        url: "http://localhost:8080",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);

            for (let korisnik of response) {
                let row = "<tr>";
                row += "<td>" + korisnik.ime + "</td>";
                row += "<td>" + korisnik.prezime + "</td>";


                $('#treneri').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});
