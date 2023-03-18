const listPro = document.querySelector('.list-unstyled');
const lastChildPro = document.querySelector('.list-unstyled li:last-child')
let newLi = document.createElement('li');
newLi.innerHTML = '24/7 Phone support';
lastChildPro.insertAdjacentElement('beforeend',newLi);

//2

const pro = document.querySelector('.pro-plan');
const basic = document.querySelector('.basic-plan');
let row = document.querySelector('.row');
let col = document.querySelectorAll('.col-md-4');
row.innerHTML = '';
row.appendChild(col[1]);
row.appendChild(col[0]);
