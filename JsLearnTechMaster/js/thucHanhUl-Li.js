//1

let ul = document.querySelector('#list');
for(let i = 8;i<= 10;i++) {
    let item = document.createElement('li');
    item.innerText = 'item ' + i;
    ul.insertAdjacentElement('beforeend',item);
}

//2

let firstLi = document.querySelector('#list li:nth-child(1)');
let thirdLi = document.querySelector('#list li:nth-child(3)');
let forthLi = document.querySelector('#list li:nth-child(4)');
let newLi = document.createElement('li');
newLi.innerHTML = 'Some random contents';
firstLi.style.color = 'red';
thirdLi.style.backgroundColor = 'lightBlue';
forthLi.remove();
thirdLi.insertAdjacentElement('afterend',newLi);

let btn = document.createElement('button');
btn.innerHTML = 'Add';
ul.insertAdjacentElement('afterend',btn);


let inputText = document.createElement('input');
ul.insertAdjacentElement('afterend',inputText);
btn.addEventListener('click',function() {
    const newI = document.createElement('li');
    newI.innerText = inputText.value;
    ul.appendChild(newI);
    inputText.value = ' ';
})

//7

const btnRemove = document.createElement('button');
let lastLi = document.querySelector('#list li:last-child');
btnRemove.innerHTML = 'Remove';
ul.append(btnRemove);
btnRemove.addEventListener('click',function() {
    if(lastLi) {
        lastLi.remove();
    }
    return;
});

//8


const hideShowBtn = document.createElement('button');
const body = document.querySelector('body');
body.insertAdjacentElement('afterbegin',hideShowBtn);
hideShowBtn.innerHTML = 'Hide';
hideShowBtn.addEventListener('click',function() {
    if(hideShowBtn.textContent == 'Hide') {
        ul.style.visibility = 'hidden';
        hideShowBtn.innerHTML = 'Show';
    }else {
        ul.style.visibility = 'visible';
        hideShowBtn.innerHTML = 'Hide';
    }
})