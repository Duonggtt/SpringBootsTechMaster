const username = document.getElementById('username');
const password = document.getElementById('password');
const confirmPassword = document.getElementById('confirmPassword');
const labelUsername = document.createElement('label');
const labelPassword = document.createElement('label');
const labelConfirm = document.createElement('label');
const btn = document.getElementById('btn');
const input = document.querySelectorAll('input');

labelUsername.innerHTML = "Username : ";
labelPassword.innerHTML = "Password :";
labelConfirm.innerHTML = "Confirm password :";
username.insertAdjacentElement('beforebegin',labelUsername);
password.insertAdjacentElement('beforebegin',labelPassword);
confirmPassword.insertAdjacentElement('beforebegin',labelConfirm);

function passwordConfirm() {
    confirmPassword.addEventListener('input', function() {
        if(confirmPassword.value === password.value) {
            btn.disabled = false;
            clickBtn();
        }else {
            btn.disabled = true;
        }   
    });
}


function clickBtn() {
    btn.addEventListener('click', function() {
        alert("Dang ki thanh cong!");
    })
}
username.addEventListener('input', function() {
    if(username.value && password.value && confirmPassword.value && confirmPassword.value === password.value) {
        btn.disabled = false;
        btn.style.backgroundColor = 'blue';
        clickBtn();
    }else {
        btn.disabled = true;
        btn.style.backgroundColor = 'red';
    }
});

password.addEventListener('input', function() {
    if(username.value && password.value && confirmPassword.value && confirmPassword.value === password.value) {
        btn.disabled = false;
        btn.style.backgroundColor = 'blue';
        clickBtn();
    }else {
        btn.disabled = true;
        btn.style.backgroundColor = 'red';
    }
});

confirmPassword.addEventListener('input', function() {
    if(username.value && password.value && confirmPassword.value && confirmPassword.value === password.value) {
        btn.disabled = false;
        btn.style.backgroundColor = 'blue';
        clickBtn();
    }else {
        btn.disabled = true;
        btn.style.backgroundColor = 'red';
    }
});
