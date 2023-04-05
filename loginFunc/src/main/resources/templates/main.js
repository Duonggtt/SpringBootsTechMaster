const loginBtn = document.querySelector('.login-form-btn');


loginBtn.addEventListener('click', function () {
    const usernameInput = document.querySelector('.name');
    const passwordInput = document.querySelector('.pass');
    const username = usernameInput.value;
    const password = usernameInput.value;
    console.log(username)
    if(usernameInput === "" && passwordInput === "") {
        alert("Vui lòng nhập thông tin đầy đủ !");
        return;
    }else if(usernameInput === "" || passwordInput === "") {
        alert("Vui lòng nhập đầy đủ car username và password !");
        return;
    }

    const RequestData = {username,password};

    fetch("http://localhost:8080/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(RequestData)
    })
        .then(response => response.json())
        .then(data => {
            if(data.error) {
                alert(data.message);
            }else {
                const userI4 = data.user;
                const message = `Hello ${userI4.username} // :v cần phải lấy ra cả thông tin email vs avatar của user nữa`;
                alert(message);
            }
        })
        .catch(error => {
            console.error("ERROR" , error);
        });
})