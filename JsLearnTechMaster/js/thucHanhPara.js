//1

let para = document.querySelector('p');
let content = para.innerText.split(' ');
content.map(ele => ele.length >= 8 ? `<span style = "background : yellow;">${ele}</span>` : ele).join(" ");

para.innerHTML = content;

//2

let link = document.createElement('a');
link.innerText = 'Facebook';
link.href = 'https://www.facebook.com/';
para.insertAdjacentElement('afterend',link);

//3

let countEle = document.createElement('div');
countEle.innerText = `${content.length} words`;

link.insertAdjacentElement('afterend',countEle);

//4

para.innerHTML = para.innerText.replace(/\?/g,'🤔');
para.innerHTML = para.innerText.replace(/\!/g,'😲');
