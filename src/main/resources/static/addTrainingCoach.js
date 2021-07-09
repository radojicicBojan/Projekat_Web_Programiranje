let ID = localStorage.getItem("ID");
let uloga = localStorage.getItem("ULOGA");

$(document).on("submit", "#addTrainingCoach", function (event) {
    event.preventDefault();
    console.log('test');
    // preuzimamo vrednosti unete u formi
    let naziv = $("#name1").val();
    let opis = $("#description").val();
    let tipTreninga = $("#type").val();
    let trajanje = $("#duration").val();

    let newTrening = {
        naziv,
        opis,
        tipTreninga,
        trajanje,
        trenerId:ID
    }


    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/treninzi/addTraining" + "?uloga=" + uloga,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newTrening),
        success: function (response) {
            console.log(response);

            alert("Trening " + response.id + " je uspešno dodat!");
            window.location.href = "seeTrainings.html?id="+ID;
        },
        error: function () {
            alert("Greška prilikom dodavanja treninga!");
        }
    });
});