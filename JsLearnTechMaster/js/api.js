const btn = document.getElementById('btn');
const select = document.getElementById('breeds-list');
const h1 = document.createElement('h1');
const ul = document.createElement('ul');

async function getBreedList() {
    
    let res = await axios.get("https://dog.ceo/api/breeds/list/all")
    
    renderBreed(res.data.message);
}

function renderBreed(breeds) {
    for(const key in breeds) {
        const opt = document.createElement('option');
        opt.innerText = key;
        select.appendChild(opt);
    }
}
getBreedList();

async function getSubBreedList(breed) {

    let result = await axios.get("https://dog.ceo/api/breed/" + breed + "/list");

    renderSubbreed(result.data.message);
}

async function getSubBreedImg(subBreeds) {

    let result = await axios.get("https://dog.ceo/api/breed/hound/"+ subBreeds +  "/images");// sua lai 

    renderSubbreedImg(result.data.message);
    console.log(result.data.message)
}

function renderSubbreedImg(subBreedImg) {
    const img = document.createElement("img");
    
    if(subBreedImg.length > 0) {
        for(let i = 0; i < subBreedImg.length; i++) {
            console.log(subBreedImg[i])
            img.src = subBreedImg[i];
            img.appendChild(ul);
    }
}
}

function renderSubbreed(subBreeds) {
    h1.innerText = "Sub Breed List";
    btn.insertAdjacentElement('afterend',h1);
    h1.insertAdjacentElement('afterend',ul);
    if(subBreeds.length > 0) {
        for(let i = 0;i< subBreeds.length;i++) {
            const li = document.createElement('li');
            li.value = subBreeds[i];
            li.innerText = subBreeds[i];
            ul.appendChild(li);
            li.addEventListener('click',function() {
                getSubBreedImg(li.value);
            });
        }
        
    }else {
        const li = document.createElement('li');
        li.innerText = "invalid";
        ul.appendChild(li);
    }
    
}

btn.addEventListener('click',function() {

    getSubBreedList(select.value);  
    
});