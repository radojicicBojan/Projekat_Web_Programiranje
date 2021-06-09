$(function(){
    var $registerForm =$('#registration');
    if($registerForm.length){
        $registerForm.validate({
            rules: {
                username: {
                    required: true
                },
                email: {
                    required: true
                },
                password: {
                    required: true
                },
                password2: {
                    required: true,
                    equalTo: '#password'
                },
                name: {
                    required: true,
                    noSpace: true
                },
                lastname: {
                    required: true,
                    //noSpace: true
                },
                phone: {
                    required: true
                },
                date: {
                    required: true,
                },
                role: {
                    required: true
                }
            },
            messages:{
                username:{
                    required: 'Unesite korisničko ime!'
                },
                email: {
                    required: 'Unesite email adresu!',
                    //error message for the email field
                    email: 'Uneta adresa nije validna!'
                },
                password: {
                    required: 'Unesite lozinku!'
                },
                password2: {
                    required: 'Unesite lozinku!',
                    equalTo: 'Lozinke se ne poklapaju'
                },
                phone: {
                    required: 'Unesite broj telefona!'
                },
                name: {
                    required: 'Unesite ime!'
                },
                lastname: {
                    required: 'Unesite prezime!'
                },
                date: {
                    required: 'Odaberite datum rođenja!'
                },
                role: {
                    required: ''
                }
            },
        })
    }
})

var username = document.querySelector('#username');
username.addEventListener('keyup', function (){
    var u_times = document.querySelector('.u_times');
    var u_check = document.querySelector('.u_check');
    if(username.value.length == 0 || username.value.length < 4){
        username.style.border = '1px solid red';
        u_times.style.display = 'block';
        u_check.style.display = 'none';
        return false;
    }else{
        username.style.border = '1px solid green';
        u_times.style.display = 'none';
        u_check.style.display = 'block';
    }
})

var password = document.querySelector('#password');
password.addEventListener('keyup', function (){
    var p_times = document.querySelector('.p_times');
    var p_check = document.querySelector('.p_check');
    if(password.value.length == 0 || password.value.length < 4){
        password.style.border = '1px solid red';
        p_times.style.display = 'block';
        p_check.style.display = 'none';
        return false;
    }else{
        password.style.border = '1px solid green';
        p_times.style.display = 'none';
        p_check.style.display = 'block';
    }
})

var password2 = document.querySelector('#password2');
password2.addEventListener('keyup', function (){
    var p2_times = document.querySelector('.p2_times');
    var p2_check = document.querySelector('.p2_check');
    if(password2.value.length == 0 || password2.value.length < 4){
        password2.style.border = '1px solid red';
        p2_times.style.display = 'block';
        p2_check.style.display = 'none';
        return false;
    }else{
        password2.style.border = '1px solid green';
        p2_times.style.display = 'none';
        p2_check.style.display = 'block';
    }
})

var phone = document.querySelector('#phone');
phone.addEventListener('keyup', function (){
    var ph_times = document.querySelector('.ph_times');
    var ph_check = document.querySelector('.ph_check');
    if(phone.value.length == 0 || phone.value.length < 4){
        phone.style.border = '1px solid red';
        ph_times.style.display = 'block';
        ph_check.style.display = 'none';
        return false;
    }else{
        phone.style.border = '1px solid green';
        ph_times.style.display = 'none';
        ph_check.style.display = 'block';
    }
})

var email = document.querySelector('#email');
email.addEventListener('keyup', function (){
    var e_times = document.querySelector('.e_times');
    var e_check = document.querySelector('.e_check');
    if(email.value.length == 0 || email.value.length < 4 || /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/.test(email.value)){
        email.style.border = '1px solid red';
        e_times.style.display = 'block';
        e_check.style.display = 'none';
        return false;
    }else{
        email.style.border = '1px solid green';
        e_times.style.display = 'none';
        e_check.style.display = 'block';
    }
})

var name1 = document.querySelector('#name1');
name1.addEventListener('keyup', function (){
    var n_times = document.querySelector('.n_times');
    var n_check = document.querySelector('.n_check');
    if(name1.value.length == 0 || name1.value.length < 4){
        name1.style.border = '1px solid red';
        n_times.style.display = 'block';
        n_check.style.display = 'none';
        return false;
    }else{
        name1.style.border = '1px solid green';
        n_times.style.display = 'none';
        n_check.style.display = 'block';
    }
})

var lastname = document.querySelector('#lastname');
lastname.addEventListener('keyup', function (){
    var l_times = document.querySelector('.l_times');
    var l_check = document.querySelector('.l_check');
    if(lastname.value.length == 0 || lastname.value.length < 4){
        lastname.style.border = '1px solid red';
        l_times.style.display = 'block';
        l_check.style.display = 'none';
        return false;
    }else{
        lastname.style.border = '1px solid green';
        l_times.style.display = 'none';
        l_check.style.display = 'block';
    }
})

$(document).on("submit", "#registration", function (event) {
    event.preventDefault();
    console.log('test');
    // preuzimamo vrednosti unete u formi
    let korisnickoIme = $("#username").val();
    let lozinka = $("#password").val();
    let ime = $("#name1").val();
    let prezime = $("#lastname").val();
    let telefon = $("#phone").val();
    let email = $("#email").val();
    let datumRodjenja = $("#date").val();
    let uloga = $("#role").val();


    let newTrener = {
        korisnickoIme,
        lozinka,
        ime,
        prezime,
        telefon,
        email,
        datumRodjenja,
        uloga
    }


    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/registration",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newTrener),
        success: function (response) {
            console.log(response);

            alert("Korisnik " + response.id + " je uspešno registrovan!");
            window.location.href = "registration.html";
        },
        error: function () {
            alert("Greška prilikom dodavanja zaposlenog!");
        }
    });
});


