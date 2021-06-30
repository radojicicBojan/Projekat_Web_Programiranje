// Prikaz svih zaposlenih
$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    // ajax poziv za dobavljanje svih zaposlenih sa backend-a i prikaz u tabeli
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/coaches",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);
            for (let korisnik of response) {
                let row = "<tr class=\"table-secondary\">";
                row += "<td>" + korisnik.ime + "</td>";
                row += "<td>" + korisnik.prezime + "</td>";
                row += "<td>" + korisnik.telefon + "</td>";
                row += "<td>" + korisnik.email + "</td>";
                row += "<td>" + korisnik.aktivan + "</td>";
                row += "<td>" + korisnik.datumRodjenja.slice(0, 10); + "</td>";
                row += "<td><input type='radio' korisnik_id='"+korisnik.id+"' class='chb' name='radiobutton'/></td>";


                $('#treneri tbody').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});
