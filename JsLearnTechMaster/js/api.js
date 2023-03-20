// const btn = document.getElementById('btn');
// const select = document.getElementById('breeds-list');
// const h1 = document.createElement('h1');
// const ul = document.createElement('ul');

// async function getBreedList() {
    
//     let res = await axios.get("https://dog.ceo/api/breeds/list/all")
    
//     renderBreed(res.data.message);
// }

// function renderBreed(breeds) {
//     for(const key in breeds) {
//         const opt = document.createElement('option');
//         opt.innerText = key;
//         select.appendChild(opt);
//     }
// }
// getBreedList();

// async function getSubBreedList(breed) {

//     let result = await axios.get("https://dog.ceo/api/breed/" + breed + "/list");

//     renderSubbreed(result.data.message);
// }

// async function getSubBreedImg(subBreeds) {

//     let result = await axios.get("https://dog.ceo/api/breed/hound/"+ subBreeds +  "/images");// sua lai 

//     renderSubbreedImg(result.data.message);
//     console.log(result.data.message)
// }

// function renderSubbreedImg(subBreedImg) {
//     const img = document.createElement("img");
    
//     if(subBreedImg.length > 0) {
//         for(let i = 0; i < subBreedImg.length; i++) {
//             console.log(subBreedImg[i])
//             img.src = subBreedImg[i];
//             img.appendChild(ul);
//     }
// }
// }

// function renderSubbreed(subBreeds) {
//     h1.innerText = "Sub Breed List";
//     btn.insertAdjacentElement('afterend',h1);
//     h1.insertAdjacentElement('afterend',ul);
//     if(subBreeds.length > 0) {
//         for(let i = 0;i< subBreeds.length;i++) {
//             const li = document.createElement('li');
//             li.value = subBreeds[i];
//             li.innerText = subBreeds[i];
//             ul.appendChild(li);
//             li.addEventListener('click',function() {
//                 getSubBreedImg(li.value);
//             });
//         }
        
//     }else {
//         const li = document.createElement('li');
//         li.innerText = "invalid";
//         ul.appendChild(li);
//     }
    
// }

// btn.addEventListener('click',function() {

//     getSubBreedList(select.value);  
    
// });


const select = document.getElementById('breeds-list');
const btn = document.getElementById('btn');
const ul = document.createElement('ul');
const img = document.createElement('img');

async function getBreedList() {
    let res = await axios.get("https://dog.ceo/api/breeds/list/all");

    renderBreedList(res.data.message);
}

function renderBreedList(breeds) {
    for(const key in breeds) {
        const opt = document.createElement('option');
        opt.innerText = key;
        opt.value = key;
        select.appendChild(opt);
    }
}   

getBreedList();

// sub breed list

async function getSubBreedList(breed) {
    let res = await axios.get("https://dog.ceo/api/breed/" + breed + "/list");

    renderSubBreedList(res.data.message);
}


function renderSubBreedList(subBreed) {
    const h1 = document.createElement('h1');
    h1.innerText = 'Sub Breeds List';
    btn.insertAdjacentElement('afterend', h1);
    h1.insertAdjacentElement('afterend',ul);
    if(subBreed.length > 0) {
        
        for(let i = 0; i < subBreed.length; i++) {
            const li = document.createElement('li');
            li.innerText = subBreed[i];
            ul.appendChild(li);
           
        }
    }else {
        const li = document.createElement('li');
        li.innerText = 'Empty information';
        ul.appendChild(li);
    }
}

btn.addEventListener('click',function() {
    getSubBreedList(select.value);
})
ul.insertAdjacentElement('afterend',img);
async function getSubBreedImg(subBreed) {
    let res = await axios.get("https://dog.ceo/api/breed/"+select.value+"/"+ subBreed +"/images/random");

    img.src = res.data.message;
}

ul.addEventListener('click',function() {
    ul.querySelectorAll('li').forEach(function(ele) {
        ele.addEventListener('click',function() {
            getSubBreedImg(ele.textContent);
        })
    });
});