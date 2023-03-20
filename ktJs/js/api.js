const title = document.querySelector('#title span');
const ul = document.createElement('ul');
const btn = document.querySelector('.btn');
const postBtn = document.querySelector('.postBtn');
const photoBtn = document.querySelector('.photoBtn');
const albumBtn = document.querySelector('.albumBtn');
btn.appendChild(ul);
title.innerHTML = 'posts';

async function getPosts() {
    let res = await axios.get("https://jsonplaceholder.typicode.com/posts");
    let arr = res.data;
    for(let i = 0; i < arr.length; i++) {
        let li = document.createElement('li');
        li.innerText = arr[i].title;
        li.value = arr[i].id;
        ul.appendChild(li);
        console.log(arr[i].title);
        postBtn.style.backgroundColor = 'red';
        postBtn.style.color = 'white';
    }
}

async function getphotos() {
    let res = await axios.get("https://jsonplaceholder.typicode.com/photos");
    let arr = res.data;
    for(let i = 0; i < arr.length; i++) {
        let li = document.createElement('li');
        li.innerText = arr[i].title;
        li.value = arr[i].id;
        ul.appendChild(li);
        console.log(arr[i].title);
    }
}

async function getAlbums() {
    let res = await axios.get("https://jsonplaceholder.typicode.com/albums");
    let arr = res.data;
    for(let i = 0; i < arr.length; i++) {
        let li = document.createElement('li');
        li.innerText = arr[i].title;
        li.value = arr[i].id;
        ul.appendChild(li);
        console.log(arr[i].title);
    }
}

getPosts();

postBtn.addEventListener("click",function() {
    ul.innerText = '';
    getPosts();
    postBtn.style.backgroundColor = 'red';
    postBtn.style.color = 'white';
    photoBtn.style.backgroundColor = '#efefef';
    photoBtn.style.color = 'black';
    albumBtn.style.backgroundColor = '#efefef';
    albumBtn.style.color = 'black';
});

photoBtn.addEventListener("click",function() {
    ul.innerText = '';
    getphotos();
    photoBtn.style.backgroundColor = 'red';
    photoBtn.style.color = 'white';
    postBtn.style.backgroundColor = '#efefef';
    postBtn.style.color = 'black';
    albumBtn.style.backgroundColor = '#efefef';
    albumBtn.style.color = 'black';
});

albumBtn.addEventListener("click",function() {
    ul.innerText = '';
    getAlbums();
    albumBtn.style.backgroundColor = 'red';
    albumBtn.style.color = 'white';
    postBtn.style.backgroundColor = '#efefef';
    postBtn.style.color = 'black';
    photoBtn.style.backgroundColor = '#efefef';
    photoBtn.style.color = 'black';
});
