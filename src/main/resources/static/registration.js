function provera(){
    let usernameID = document.getElementById('username');
    if(usernameID.value==''){
        username.value="Unesite korisničko ime";
    }
}
const form = document.getElementById('form');
const username = document.getElementById('username');
const email = document.getElementById('email');
const password = document.getElementById('password');
const password2 = document.getElementById('password2');
const name = document.getElementById('nanme');
const lastname = document.getElementById('lastname');
const phone = document.getElementById('phone');
const date = document.getElementById('date');

form.addEventListener('submit', (e)=>{
    e.preventDefault();

    checkInputs();
});

function checkInputs(){
    const usernameValue = username.value.trim();
    const emailValue = email.value.trim();
    const passwordValue = password.value.trim();
    const password2Value = password2.value.trim();

    if(usernameValue === ''){
        setErrorFor(username, "Korisnicko ime mora biti popunjeno!")
    } else {
        setSuccesFor(username);
    }

}
function setErrorFor(input, message){
    const controlGroup = input.parentElement;
    const small = controlGroup.querySelector('small');

    small.innerText = message;

    controlGroup.className = 'control-group error'
}