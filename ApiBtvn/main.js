const province = document.getElementById('province');
const district = document.getElementById('district');
const commune = document.getElementById('commune');

getDistrict(1);
getCommune(1);

async function getProvince() {
    let res = await axios.get("https://provinces.open-api.vn/api/p/");
    let arr = res.data;
    for(let i = 0; i < arr.length; i++) {
        const option = document.createElement('option');
        option.innerText = arr[i].name;
        option.value = arr[i].code;
        province.appendChild(option);
    }
    province.addEventListener('click',function() {
        district.innerText = '';
        getDistrict(province.value);
    });
}
getProvince();

async function getDistrict(provinceCode) {
    let res = await axios.get(`https://provinces.open-api.vn/api/p/${provinceCode}?depth=2`);
    let arr = res.data.districts;
    for(let i = 0; i < arr.length; i++) {
        const option = document.createElement('option');
        option.innerText = arr[i].name;
        option.value = arr[i].code;
        district.appendChild(option);
    }
}

async function getCommune(districtCode) {
    let res = await axios.get(`https://provinces.open-api.vn/api/d/${districtCode}?depth=2`);
    let arr = res.data.wards;
    for(let i = 0; i < arr.length; i++) {
        const option = document.createElement('option');
        option.innerText = arr[i].name;
        option.value = arr[i].code;
        commune.appendChild(option);
    }
    district.addEventListener('click',function() {
        commune.innerText = '';
        getCommune(district.value);
    });
}
