let id = new URL(window.location.href).searchParams.get("id");

$(document).on("submit", "#addTermin", function (event) {
    event.preventDefault();
    console.log('test');
    let vreme = $("#date").val();
    let cena = $("#price").val();

    let novTermin = {
        vreme,
        cena
    }

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/termini/dodavanjeTermina/" + id,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(novTermin),
        success: function (response) {
            console.log(response);

            alert("Termin " + response.id + " je uspešno dodat!");
            window.location.href = "seeTrainings.html";
        },
        error: function () {
            alert("Greška prilikom dodavanja Termina!");
        }
    });
});