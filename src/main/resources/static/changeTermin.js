let id = new URL(window.location.href).searchParams.get("id");
let ID = localStorage.getItem("ID");
let uloga = localStorage.getItem("ULOGA");

$.ajax({
    type: "GET",
    url: "http://localhost:8080/api/termini/ispis/" + id + "?uloga=" + uloga,
    dataType: "json",
    success: function (response) {
        console.log("SUCCESS:\n", response);
        $("#name1").val(response.naziv);
        $("#description").val(response.opis);
        $("#type").val(response.tipTreninga);
        $("#duration").val(response.trajanje);
        $("#time").val(response.vremePocetka);
        $("#price").val(response.cena);

    },
    error: function (response) {
        console.log("ERROR:\n", response);
    }
});

function izmeni() {

    let naziv = $("#name1").val();
    let opis = $("#description").val();
    let tipTreninga = $("#type").val();
    let trajanje = $("#duration").val();
    let vremePocetka = $("#time").val();
    let cena = $("#price").val();

    let newTermin = {
        naziv,
        opis,
        tipTreninga,
        trajanje,
        vremePocetka,
        cena
    }

    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/api/treninzi/izmena/" + id + "?uloga=" + uloga,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newTermin),
        success: function (response) {
            console.log(response);

            alert("Termin " + response.id + " je uspešno izmenjen!");
            window.location.href = "listTrainings.html?id="+ID;
        },
        error: function () {
            alert("Greška prilikom izmene Termina!");
        }
    });
}