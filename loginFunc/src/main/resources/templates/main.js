const form = document.querySelector('#login-form');
const inputForm = document.querySelector('.name');
const passForm = document.querySelector('.pass');
const btn = document.querySelector('.login-form-btn')
const message = document.querySelector('#message');

btn.addEventListener('click', event => {
    event.preventDefault();
    const username = inputForm.value;
    console.log(inputForm.value);
    const password = passForm.value;

    if (username.trim() === '' || password.trim() === '') {
        alert('Please enter username and password.');
        return;
    }

    fetch('http://localhost:8081/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ username, password })
    })
        .then(response => response.json())
        .then(data => {
            if (data.username) {

                message.textContent = 'Username or password is incorrect.';
                message.style.display = 'block';
            } else {

                form.style.display = 'none';
                message.textContent = `Xin chào ${data.username}. Email: ${data.email}. Avatar: ${data.avatar}.`;
                message.style.display = 'block';
            }
        })
        .catch(error => console.error(error));
});