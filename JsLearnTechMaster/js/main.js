//1

let ans = 1;
function calculateFactorial(num) {
    for(let i = 1;i<= num;i++) {
        ans *= i;
    }
    console.log(ans);
}

calculateFactorial(5);

//2

function reverseString(str) {
    let res = "";
    for(let i = str.length - 1; i >= 0;i--) {
        res += str[i];
    }

    console.log(res);
}

reverseString("hello")

//3
let country = "VN";

switch(country) {
    case "VN": 
        console.log("Xin chao!");
        break;
    case "EN":
        console.log("Hello!");
        break;
    case "CN":
        console.log("Nihao!");
        break;
    case "TL":
        console.log("KhapKhap!");
        break;
    default:
        console.log("Invalid country");
}

//4

function subString(str) {
    if(str.length >= 15) {
        let newStr = "";
        for(let i = 0 ;i< 10;i++) {
            newStr += str[i];
        }
        console.log(newStr + "...");
    }else {
        console.log("can nhap chuoi co do dai hon 15 ki tu!");
    }
}

subString("helooooooooooooooooooooo");