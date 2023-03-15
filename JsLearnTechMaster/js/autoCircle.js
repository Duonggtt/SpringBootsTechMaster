//1

let quote = document.createElement('p');
let text = document.querySelector('p');
quote.innerHTML = "Noi dung bat ki";
function listen() {
    text.insertAdjacentElement('afterend', quote);
}

//2
let ran = [0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H'];

function randomHex() {
    ans = '#';
    for(let i =0;i<6;i++) {
        ans += ran[Math.floor(Math.random() * ran.length)];
    }
    console.log(ans);
    return ans;
}

let btn2 = document.querySelector('#btn-2');
let p = document.querySelector('p');
btn2.onclick = function() {
    p.style.color ='' + randomHex();
}

//3

let arrNum = [0,1,2,3,4,5,6,7,8,9];

function randomRgb() {
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
let btn3 = document.querySelector('#btn-3');
btn3.addEventListener('click', function() {
    p.style.backgroundColor = '' + randomRgb();
});