//Vừa vào trang gọi API load danh sách tỉnh - thành phố (province) và hiển thị lên trên giao diện
let province = document.getElementById('province');
async function getPrpvince() {
    getDistrict(1);
    getCommune(1);
    let res = await axios.get("https://provinces.open-api.vn/api/p/")
    let arr = res.data;
    for(let i = 0; i < arr.length; i++){
        let option = document.createElement('option');
        option.innerText = arr[i].name;
        option.value = arr[i].code;
        province.appendChild(option);

    }
}

// Khi người dùng chọn 1 tỉnh - thành phố (province) cụ thể thì tiếp tục gọi API để lấy danh sách quận - huyện (district) tương ứng với tỉnh - thành phố đã chọn trước đó
let district = document.getElementById('district');
async function getDistrict(provinceCode){
   
    let res = await axios.get(`https://provinces.open-api.vn/api/p/${provinceCode}?depth=2`);
    let arr = res.data.districts;
 
    for(let i = 0; i < arr.length; i++){
        let option = document.createElement('option');
        option.innerText = arr[i].name;
        option.value = arr[i].code;
        district.appendChild(option);
    }
}

// Làm tương tự với xã phường (commune)
let commune = document.getElementById('commune');
async function getCommune(districtCode){
    
    let res = await axios.get(`https://provinces.open-api.vn/api/d/${districtCode}?depth=2`);
    let arr = res.data.wards;
    console.log(arr)
    for(let i =0; i < arr.length; i++){
        let option = document.createElement('option');
        option.innerText = arr[i].name;
        option.value = arr[i].code;
        commune.appendChild(option);
    }
}

getPrpvince()
province.addEventListener('click', function(){
   
    district.innerHTML = ``;
    getDistrict(province.value);

})
district.addEventListener('click',function(){
    commune.innerHTML = ``;
    getCommune(district.value);
})