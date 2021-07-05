let id = new URL(window.location.href).searchParams.get("id");

$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    // ajax poziv za dobavljanje svih zaposlenih sa backend-a i prikaz u tabeli
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/sale/fitnesCentar/" + id,
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);
            for (let sala of response) {
                let row = "<tr class=\"table-secondary\">";
                row += "<td>" + sala.kapacitet + "</td>";
                row += "<td>" + sala.oznaka + "</td>";
                row += "<td><a href=\"changeSala.html?id=" + sala.id + "\" type=\"button\" class=\"btn btn-primary\">Izmeni</a></td>";
                row += "<td><input type='radio' style='margin-left: 10px' sala_id='" + sala.id + "' name='radio' class='rb'/></td>";


                $('#sale tbody').append(row);
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
            ids.push($(rb[j]).attr("sala_id"));
            $(rb[j]).closest("tr").remove();
        }
    }
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/deleteSala",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(ids),
        success: function (response) {
            alert("Obrisana sala sa ID-jem: " + ids.join(","));
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
}