// Prikaz svih zaposlenih
$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    // ajax poziv za dobavljanje svih zaposlenih sa backend-a i prikaz u tabeli
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/approval",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);
            for (let korisnik of response) {
                let row = "<tr class=\"table-secondary\">";
                row += "<td>" + korisnik.ime + "</td>";
                row += "<td>" + korisnik.prezime + "</td>";
                row += "<td>" + korisnik.telefon + "</td>";
                row += "<td>" + korisnik.email + "</td>";
                row += "<td>" + "NE" + "</td>";
                row += "<td>" + korisnik.datumRodjenja.slice(0, 10); + "</td>";
                row += "<td><input type='radio' korisnik_id='"+korisnik.id+"' name='radiobutton' class='rb'/></td>";


            $('#treneri tbody').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});

function aktivan(){
    let ids = [];
    var rb = document.getElementsByClassName('rb');
    for(let j=0; j<rb.length; j++) {
        if (rb[j].checked) {
            ids.push($(rb[j]).attr("korisnik_id"));
            $(rb[j]).closest("tr").remove();
        }
    }
    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/api/approval",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(ids),
        success: function (response) {
           alert("Odobreni trener sa ID-jem: " + ids.join(","));
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });

}