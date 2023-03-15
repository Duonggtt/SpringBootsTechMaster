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

function renderBox() {
    for(let i = 0; i < colors.length; i++) {
        let box = document.createElement('div');
        box.style.backgroundColor = '' + colors[i];
        box.classList.add('box');
        boxes.insertAdjacentElement('beforeend',box);
        count++;
    }
}

function totalCount() {
    let count = document.createElement()
    total.insertAdjacentElement('beforeend',count);
}
totalCount();

renderBox();
btn.addEventListener('click', function() {    
    renderBox();
});


