$(document).on("submit", "#addingFitnesCentar", function (event) {
    event.preventDefault();
    console.log('test');
    // preuzimamo vrednosti unete u formi
    let naziv = $("#name1").val();
    let adresa = $("#adress").val();
    let telefon = $("#phone").val();
    let email = $("#email").val();

let newFitnesCentar = {
    naziv,
    adresa,
    telefon,
    email
}

$.ajax({
    type: "POST",
    url: "http://localhost:8080/api/dodavanjeFitnesCentra",
    dataType: "json",
    contentType: "application/json",
    data: JSON.stringify(newFitnesCentar),
    success: function (response) {
        console.log(response);

        alert("Fitnes Centar " + response.id + " je uspešno dodat!");
        window.location.href = "fitnesCentar.html";
    },
    error: function () {
        alert("Greška prilikom dodavanja Fitnes Centra!");
    }
});
});

/*$(function(){
    var $addFitnesCenter =$('#fitnesCentar');
    if($addFitnesCenter.length){
        $addFitnesCenter.validate({
            rules: {
                name1: {
                    required: true
                },
                adress: {
                    required: true
                },
                phone: {
                    required: true
                },
                email: {
                    required: true,
                }

            },
            messages:{
                name1:{
                    required: 'Unesite ime fitnes centra!'
                },
                adress: {
                    required: 'Unesite adresu!'
                },
                phone: {
                    required: 'Unesite broj telefona!'
                },
                email: {
                    required: 'Unesite email adresu!'
                }
            },
        })
    }
})*/

