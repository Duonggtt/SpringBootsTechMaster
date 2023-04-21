const hexBtn = document.querySelector('#random-hex-color');
const colorBtn = document.querySelector('#random-color-name');
const rgbBtn = document.querySelector('#random-rgb-color');

hexBtn.addEventListener('click',() => {
    console.log("1");
    getRandomColor(1);
});

colorBtn.addEventListener('click',() => {
    getRandomColor(2);
});

rgbBtn.addEventListener('click',() => {
    getRandomColor(3);
});

function getRandomColor(type) {
    fetch(`http://localhost:8080/random-color?type=${type}`)
        .then(response => {
            if(!response.ok) {
                throw new Error(response.statusText);
            }
            return response.text();
        })
        .then(color => {
            document.body.style.backgroundColor = color;
        })
        .catch(err => {
            console.error(err);
        });

}