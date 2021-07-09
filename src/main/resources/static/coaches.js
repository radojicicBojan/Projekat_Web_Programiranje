let uloga = localStorage.getItem("ULOGA");

$(document).ready(function () {

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/coaches" + "?uloga=" + uloga,
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);
            for (let korisnik of response) {
                let row = "<tr class=\"table-secondary\">";
                row += "<td>" + korisnik.ime + "</td>";
                row += "<td>" + korisnik.prezime + "</td>";
                row += "<td>" + korisnik.telefon + "</td>";
                row += "<td>" + korisnik.email + "</td>";
                row += "<td>" + (korisnik.aktivan ? "AKTIVAN" : "NIJE AKTIVAN") + "</td>";
                row += "<td>" + korisnik.datumRodjenja.slice(0, 10); + "</td>";
                row += "<td><input type='radio' trener_id='"+korisnik.id+"' class='rb' name='radiobutton'/></td>";


                $('#treneri tbody').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});

function obrisiTrenera(){
    let ids = [];
    var rb = document.getElementsByClassName('rb');
    for(let j=0; j<rb.length; j++) {
        if (rb[j].checked) {
            ids.push($(rb[j]).attr("trener_id"));
            $(rb[j]).closest("tr").remove();
        }
    }
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/deleteCoach",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(ids),
        success: function (response) {
            alert("Obrisan trener sa ID-jem: " + ids.join(","));
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
}
