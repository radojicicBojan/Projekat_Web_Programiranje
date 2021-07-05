$(document).ready(function () {
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
                row += "<td><a href=\"sala.html?id=" + fitnesCentar.id+"\" type=\"button\" class=\"btn btn-primary\">Prikaži sale</a></td>";
                row += "<td><a href=\"changeFitnesCentar.html?id="+fitnesCentar.id+"\" type=\"button\" class=\"btn btn-primary\">Izmeni</a></td>";
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
    let ids = [];
    var rb = document.getElementsByClassName('rb');
    for(let j=0; j<rb.length; j++) {
        if (rb[j].checked) {
            ids.push($(rb[j]).attr("fitnesCentar_id"));
            $(rb[j]).closest("tr").remove();
        }
    }
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/delete",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(ids),
        success: function (response) {
            alert("Obrisan Fitnes centar sa ID-jem: " + ids.join(","));
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
}

