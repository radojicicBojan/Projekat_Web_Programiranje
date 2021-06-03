
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

function validation(){
    if(username.value == 0 || username.value.length < 4){
        document.getElementById('error').innerText = "Neispravni podaci!";
        return false;
    }else if(password.value == 0 || password.value.length < 4){
        document.getElementById('error').innerText = "Neispravni podaci!";
        return false;
    }else{
        alert('Uspešno ste se ulogovali!')
    }
}