//1
const heading = document.getElementById('heading');
heading.style.color = 'red';
heading.style.textTransform = 'uppercase';

//2

const para = document.querySelectorAll('.para');
Array.from(para).map(ele => ele.style.color = 'blue');
Array.from(para).map(ele => ele.style.fontSize = '20px');

//3

const link = document.createElement('a');
link.setAttribute("href","https://www.facebook.com/");
link.innerHTML = "http://www.facebook.com";

const para3 = document.querySelector('.para-3'); 
para3.insertAdjacentElement('afterend', link);


//4

let title = document.getElementById('title');
title.innerText = "Đây là thẻ tiêu đề";

//5

const desc = document.getElementsByClassName('description');
desc[0].classList.add('text-bold');

//6

const btn = document.createElement('button');
btn.innerText = "click me";
para3.parentNode.replaceChild(btn, para3);

//7

const para2 = document.querySelector('.para-2');
const newPara2 = para2.cloneNode(true);
newPara2.innerText = para2.innerText;

para2.insertAdjacentElement('beforebegin', newPara2);


//8

const para1 = document.querySelector('.para-1');
para1.remove();






