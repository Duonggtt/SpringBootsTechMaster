//1.Viết function truyền vào mảng các chuỗi có độ dài bất kỳ. Kết quả trả về là 1 mảng các chuỗi có độ dài lớn nhất

let arr = ['aba', 'aa', 'ad', 'c', 'vcd'];

function getStringHasMaxLength(arr) {
    let ans = [];
    let max = arr[0].length;
    for(let i = 0; i < arr.length; i++) {
        if(arr[i].length > max) {
            max = arr[i].length;
        }
    }
    arr.forEach(function(x) {
        if(x.length == max) {
            ans.push(x);
        }
    })
    return ans;
}
console.log(getStringHasMaxLength(arr));

//2.Cho mảng users như sau:

users = [
    {
        name: "Bùi Công Sơn",
        age: 30,
        isStatus: true
    },
    {
        name: "Nguyễn Thu Hằng",
        age: 27,
        isStatus: false
    },
    {
        name: "Phạm Văn Dũng",
        age: 20,
        isStatus: false
    }
]

//Viết function truyền vào 1 mảng các object user. Trả về mảng các user có age > 25 và isStatus = true

function getUserByAgeAndStatus(users) {
    let ans = [];
    users.forEach(user => user.age > 25 && user.isStatus == true ? ans.push(user) : user);
    return ans;
}

console.log(getUserByAgeAndStatus(users));

//Viết function truyền vào 1 mảng các object user. Trả về mảng các user có age tăng dần

function getUserBySortAgeASC(users) {
    return users.sort((a,b) => a.age - b.age);;
}

console.log(getUserBySortAgeASC(users));

//3.Viết function truyền vào 1 mảng các chuỗi. Trả về Object hiển thị xem mỗi phần tử trong mảng xuất hiện bao nhiêu lần
let arrNum = ["one", "two", "three", "one", "one", "three"];

function getCountElement(arrNum) {
    let ans = {
        'one': 0,
        'two': 0,
        'three':0
    };
    for(let i = 0; i < arrNum.length; i++) {
        if(arrNum[i] == 'one') {
            ans.one++;
        }
        if(arrNum[i] == 'two') {
            ans.two++;
        }
        if(arrNum[i] == 'three') {
            ans.three++;
        }
    }
    return ans;
}
console.log(getCountElement(arrNum));