let Id = localStorage.getItem("ID");

if(localStorage.getItem("ULOGA") == "TRENER") {
    $("#main-dropdown").html(`<button class="btn btn-primary" onclick=location.href="trainings.html" style="width: 120%;height: 100%" class="button">Raspored treninga</button>
                <button class="btn btn-light" onclick=location.href=\"listTrainings.html?id="+Id+"\" style="width: 120%;height: 100%" class="button">Lista treninga</button>`)
    $("#Identification").html(`<a href="homepage.html" type="button" onclick="logout()" class="btn btn-outline-danger">Odjavi se</a>`)


}else
if(localStorage.getItem("ULOGA")  == "CLAN") {
    $("#main-dropdown").html(`<button class="btn btn-primary" onclick=location.href="trainings.html" style="width: 120%;height: 100%" class="button">Raspored treninga</button>
            <button class="btn btn-light" onclick=location.href="prijavljeniTreninzi.html" style="width: 120%;height: 100%" class="button">Prijavljeni treninzi</button>
            <button class="btn btn-primary" onclick=location.href="odradjeniTreninzi.html" style="width: 120%;height: 100%" class="button">Odrađeni treninzi</button>
`)
    $("#Identification").html(`<a href="profil.html" type="button" style="margin-right: 5px" class="btn btn-warning">Moj profil</a><a href="homepage.html" type="button" onclick="logout()" class="btn btn-outline-danger">Odjavi se</a>`)


}else
if(localStorage.getItem("ULOGA") == "ADMINISTRATOR") {
    $("#main-dropdown").html(`<button class="btn btn-primary" onclick=location.href="trainings.html" style="width: 120%;height: 100%" class="button">Raspored treninga</button>
                <button class="btn btn-light" onclick=location.href="fitnesCentar.html" style="width: 120%;height: 100%" class="button">Fitnes centar</button>
                <button class="btn btn-primary" onclick=location.href="approval.html" style="width: 120%;height: 100%" class="button">Zahtevi trenera</button>
                <button class="btn btn-light" onclick=location.href="registrationCoachByAdmin.html" style="width: 120%;height: 100%" class="button">Registracija trenera</button>
                <button class="btn btn-primary" onclick=location.href="coaches.html" style="width: 120%;height: 100%" class="button">Uklanjanje trenera</button>
`)
    $("#Identification").html(`<a href="homepage.html" type="button" onclick="logout()" class="btn btn-outline-danger">Odjavi se</a>`)
}else{
    $("#main-dropdown").html(`<button class="btn btn-primary" onclick=location.href="trainings.html" style="width: 120%;height: 100%" class="button">Raspored treninga</button>`)
    $("#Identification").html(`<a href="login.html" type="button" class="btn btn-primary">Uloguj se</a>
    <a href="registration.html" type="button" class="btn btn-light">Registruj se</a>`)

}

function logout() {
    window.localStorage.clear();
    window.location.href = "homepage.html";
}