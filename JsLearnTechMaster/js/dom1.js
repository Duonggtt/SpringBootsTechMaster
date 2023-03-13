//cau 1

const text = document.querySelector('#text');
text.style.color = "#777";
text.style.fontSize = "2rem";
text.innerHTML = "Tôi có thể làm <em> bất cứ điều gì </em> tôi muốn với Javascript";

//cau 2

const lis = document.querySelectorAll('li');
lis.forEach(function(item) {
    item.style.color = "blue";
});

//cau 3

const list = document.querySelector('#list');
j = 8;
let item;
//1.
for(let i =0;i<3;i++) {
    item = document.createElement("li");
    item.innerHTML = "Item " + j;
    list.insertAdjacentElement('beforeend',item);
    j++;
}

//2.
let listItem = document.querySelectorAll('li');
listItem.forEach(function(item) {
    if(item.innerHTML === "Item 1") {
        item.style.color = "red";
    }
});
//3.
listItem.forEach(function(item) {
    if(item.innerHTML === "Item 3") {
        item.style.backgroundColor = "lightblue";
    }
});
//4.
listItem.forEach(function(item) {
    if(item.innerHTML === "Item 4") {
        item.remove();
    }
});
//5.
let newItem = document.createElement('li');
newItem.innerHTML = "Noi dung bat ki";
listItem.forEach(function(item) {
    if(item.innerHTML === "Item 3") {
        item.insertAdjacentElement('afterend',newItem);
    }
});