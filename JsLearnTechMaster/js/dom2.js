let colors = [
    '#3498db',
    '#9b59b6',
    '#e74c3c',
    '#2c3e50',
    '#d35400',
]
let total = document.querySelector('.points');
let totalLc = document.querySelector('#score');
let boxes = document.querySelector('.boxes');
let btn = document.querySelector('#btn');
let count = document.createElement('span');
count.innerText = '0';

function renderBox() {
    for(let i = 0; i < colors.length; i++) {
        let box = document.createElement('div');
        box.style.backgroundColor = '' + colors[i];
        box.classList.add('box');
        boxes.insertAdjacentElement('beforeend',box);
        count.textContent ++;
    } 
    totalLc.insertAdjacentElement('beforeend',count);
}

renderBox();
btn.addEventListener('click', function() { 
    count.remove();
    renderBox();
});

let delBox = document.querySelectorAll('.box');

function deleteBox() {
    delBox.forEach(function(box) {
        box.addEventListener("click",function() {
            count.textContent --;
            box.remove();
        })
    })
}
deleteBox();
