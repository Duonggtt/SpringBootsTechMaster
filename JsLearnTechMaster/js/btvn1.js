//Bài 1: Viết function truyền vào 1 số nguyên dường. Tính giai thừa của số đó

function calculateFactorial(num) {
    ans = 1;
    for(let i = num; i >=1;i--) {
        ans *= i;
    }
    console.log(ans);
}

calculateFactorial(5);

//Bài 2: Viết function truyền vào 1 chuỗi. In ra chuỗi đảo ngược của chuỗi đó

function reverseString(str) {
    ans = "";
    for(let i = str.length - 1; i >=0 ;i--) {
        ans += str[i];
    }
    console.log(ans);
}

reverseString("hello");

//Bài 3: Viết function truyền vào mã quốc gia. Trả về message có ý nghĩa là “Xin chào”, tương ứng với mã quốc gia được truyền vào

function translate(country) {
    let ans = "";
    switch(country) {
        case 'VN': 
            ans += "Xin Chao";
            break;
        case 'EN':
            ans += "Hello" ;
            break;
        case 'CN':
            ans += "Ni Hao";
            break;
        case 'TL':
            ans += "KhapKhap";
            break;
        default:
            ans += "Invalide country !";
    }
    console.log(ans);
}

translate('VN');

//Bài 4: Cho function truyền vào 1 chuỗi dài hơn 15 ký tự. Viết 1 function cắt chuỗi, lấy ra 10 ký tự đầu tiên và thêm vào dấu “…” ở cuối chuỗi.

function subString() {
    let str;
    let ans = "";
    let dotdotdot = "...";
    while(true) {
        str = prompt("Truyen vao chuoi co do dai lon hon 15");
        if(str.length >= 15) {
            ans += str.slice(0,10);
            ans += dotdotdot;
            break;
        }else {
            console.log("String length must > 15");
        }
    }
    console.log(ans);
}

subString("heloooooooooooooooooooooooo");
