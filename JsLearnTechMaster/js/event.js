
function drawCircle() {
    var canvas = document.getElementById("myCanvas");
    canvas.width = window.innerWidth;
    canvas.height = window.innerHeight;
    let x = event.clientX;
    let y = event.clientY;
    var ctx = canvas.getContext("2d");
    ctx.beginPath();
    ctx.arc(x, y, 40, 0, 2 * Math.PI);
    ctx.stroke();
}
document.addEventListener('click', function() {
    drawCircle();
}); 

//====================================

function drawCircleRandom() {
    var canvas = document.getElementById("myCanvas");
    canvas.width = window.innerWidth;
    canvas.height = window.innerHeight;
    let x = Math.floor(Math.random() * 1000);
    let y = Math.floor(Math.random() * 1000);
    var ctx = canvas.getContext("2d");
    ctx.beginPath();
    ctx.arc(x, y, 40, 0, 2 * Math.PI);
    ctx.stroke();
}

function drawSquareRandom() {
    var canvas = document.getElementById("myCanvas");
    canvas.width = window.innerWidth;
    canvas.height = window.innerHeight;
    let x = Math.floor(Math.random() * 1000);
    let y = Math.floor(Math.random() * 1000);
    var ctx = canvas.getContext("2d");
    ctx.beginPath();
    ctx.arc(x, y, 40, 0, 2 * Math.PI);
    ctx.stroke();
}

function randomRgb() {
    let arrNum = [0,1,2,3,4,5,6,7,8,9];
    let a = 0;
    let b = 0;
    let c = 0;
    for(let i = 0; i < 3; i++) {
        a = (a * 10) + arrNum[Math.floor(Math.random() * arrNum.length)];
        b = (b * 10) + arrNum[Math.floor(Math.random() * arrNum.length)];
        c = (c * 10) + arrNum[Math.floor(Math.random() * arrNum.length)];
    }
    ans = 'rgb(' + a + ',' + b + ',' + c + ')';
    console.log(ans);
    return ans;
}

document.addEventListener("keydown", function (event) {
    if (event.keyCode == 13) {
        drawCircleRandom();
    }else if(event.keyCode == 32){
        drawSquareRandom();
    }
    else {
        var canvas = document.getElementById("myCanvas");
        canvas.width = window.innerWidth;
        canvas.height = window.innerHeight;
        canvas.style.backgroundColor = '' + randomRgb();
    }
});

//============================

let text = document.querySelector('input');
let btn = document.querySelector('button');

btn.addEventListener('click',function() {
    if(btn.innerText === "Show") {
        text.type = "text";
        btn.innerText = "Hide";
    }else {
        text.type = "password";  
        btn.innerText = "Show";
    }
});
