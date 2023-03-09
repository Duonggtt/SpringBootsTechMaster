let products = [
    {
        name: "Iphone 13 Pro Max", // Tên sản phẩm
        price: 3000000, // Giá mỗi sản phẩm
        brand: "Apple", // Thương hiệu
        count: 2, // Số lượng sản phẩm trong giỏ hàng
    },
    {
        name: "Samsung Galaxy Z Fold3",
        price: 41000000,
        brand: "Samsung",
        count: 1,
    },
    {
        name: "IPhone 11",
        price: 15500000,
        brand: "Apple",
        count: 1,
    },
    {
        name: "OPPO Find X3 Pro",
        price: 19500000,
        brand: "OPPO",
        count: 3,
    },
]

//Thêm 1 sản phẩm bất kỳ vào trong mảng product
function addNewProduct() {
    products.push({
        name: "IPhone 12",
        price: 25500000,
        brand: "Apple",
        count: 2
    });
}
addNewProduct();

//Xóa tất cả sản phẩm của thương hiệu "Samsung" trong giỏ hàng

function deleteProductByBrand() {
    const newProduct = products.filter(item => item.brand !== "Samsung");
    console.log(newProduct);
}
deleteProductByBrand();

//Sắp xếp giỏ hàng theo price tăng dần

function sortProductByPriceASC() {
    products.sort((a,b) => a.price - b.price);
    console.log(products);
}
sortProductByPriceASC();


//Sắp xếp giỏ hàng theo count giảm dần

function sortProductByCountDESC() {
    products.sort((a,b) => b.count - a.count);
    console.log(products);
}
sortProductByCountDESC();

//Lấy ra 2 sản phẩm bất kỳ trong giỏ hàng

function getRandomElement() {
    const ans = [];
    for(let i = 0 ; i < 2; i++) {
        ans[i] = products[Math.floor(Math.random() * products.length)];
    }
    console.log(ans);
}
getRandomElement();



