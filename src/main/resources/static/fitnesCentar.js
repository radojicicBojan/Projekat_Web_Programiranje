$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    // ajax poziv za dobavljanje svih zaposlenih sa backend-a i prikaz u tabeli
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/fitnesCentri",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);
            for (let fitnesCentar of response) {
                let row = "<tr class=\"table-secondary\">";
                row += "<td>" + fitnesCentar.adresa + "</td>";
                row += "<td>" + fitnesCentar.email + "</td>";
                row += "<td>" + fitnesCentar.naziv + "</td>";
                row += "<td>" + fitnesCentar.telefon + "</td>";
                row += "<td><a href=\"login.html\" type=\"button\" class=\"btn btn-primary\">Izmeni</a></td>";
                row += "<td><input type='radio' style='margin-left: 10px' fitnesCentar_id='"+fitnesCentar.id+"' name='radio' class='rb'/></td>";


                $('#fitnesCentri tbody').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});

function obrisi(){
    var rb = document.getElementsByClassName('rb');
    for(let j=0; j<rb.length; j++) {
        if (rb[j].checked) {

            $(rb[j]).closest("tr").remove();
        }
    }
}