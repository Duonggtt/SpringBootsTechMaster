let student_warning = {
    students: [
        {
            name: "Lê Hoài Nam",
            email: "namlehoai@gmail.com",
            phone: "123456789",
            total_off: 2,
            sessions: 14,
            detail_info: [
                {
                    date: "01-09-2020",
                    note: "Xin nghỉ ốm",
                    teacher: "Bùi Hiên",
                },
                {
                    date: "05-09-2020",
                    note: "Buồn vì thất tình",
                    teacher: "Nguyễn Hàn Duy",
                },
            ],
        },
        {
            name: "Đỗ Đăng Nguyên",
            email: "nguyen@gmail.com",
            phone: "0123987654",
            total_off: 2,
            sessions: 14,
            detail_info: [
                {
                    date: "01-09-2020",
                    note: "Mưa to nên ngại đi học",
                    teacher: "Bùi Hiên",
                },
                {
                    date: "05-09-2020",
                    note: "Trượt lô, nên rút học phí để đánh",
                    teacher: "Nguyễn Hàn Duy",
                },
            ],
        },
        {
            name: "Nguyễn Xuân Ba",
            email: "3nx92nd@gmail.com",
            phone: "0344005987",
            total_off: 3,
            sessions: 14,
            detail_info: [
                {
                    date: "01-09-2020",
                    note: "Đang training không đi học được",
                    teacher: "Bùi Hiên",
                },
                {
                    date: "07-09-2020",
                    note: "Soạn giáo án đặc vụ 0175",
                    teacher: "Nguyễn Hàn Duy",
                },
                {
                    date: "10-09-2020",
                    note: "Ganks team còng lưng nên chưa đi học được",
                    teacher: "Nguyễn Hàn Duy",
                },
            ],
        },
    ],
    class: "Lập trình Game 2D Canvas",
    course: "Lập trình Game",
    sessions: 14,
    teachers: [
        {
            name: "Bùi Hiên",
            email: "hien@techmaster.vn",
            phone: "0123456789",
        },
        {
            name: "Nguyễn Hàn Duy",
            email: "duy@techmaster.vn",
            phone: "0987654321",
        },
    ],
};

// Dựa vào thông tin của object student_warning. Hãy hiển thị dự liệu tương tự như demo trong mã HTML

let clazz = student_warning.class;
let course = student_warning.course;
const className  = document.querySelector(".class-inner p:nth-child(1)");
const classSpanName = document.querySelector(".class-inner p:nth-child(1) span");
const courseName = document.querySelector(".class-inner p:nth-child(2)");
const courseSpanName = document.querySelector(".class-inner p:nth-child(2) span");

className.innerText = `${classSpanName.textContent} : ${clazz}`;
courseName.innerText = `${courseSpanName.textContent} : ${course}`;
console.log(student_warning.students);

const tbody = document.querySelector('tbody');
const name1 = document.querySelector('tbody tr:nth-child(1) td:nth-child(2)');
const email1 = document.querySelector('tbody tr:nth-child(1) td:nth-child(3)');
const phone1 = document.querySelector('tbody tr:nth-child(1) td:nth-child(4)');
const takeOff1 = document.querySelector('tbody tr:nth-child(1) td:nth-child(5)');
const date1_1 = document.querySelector('tbody tr:nth-child(1) td:nth-child(6)');
const note1_1 = document.querySelector('tbody tr:nth-child(1) td:nth-child(7)');
const teacher1_1 = document.querySelector('tbody tr:nth-child(1) td:nth-child(8)');
const date1_2 = document.querySelector('tbody tr:nth-child(2) td:nth-child(1)');
const note1_2 = document.querySelector('tbody tr:nth-child(2) td:nth-child(2)');
const teacher1_2 = document.querySelector('tbody tr:nth-child(2) td:nth-child(3)');

const name2 = document.querySelector('tbody tr:nth-child(3) td:nth-child(2)');
const email2 = document.querySelector('tbody tr:nth-child(3) td:nth-child(3)');
const phone2 = document.querySelector('tbody tr:nth-child(3) td:nth-child(4)');
const takeOff2 = document.querySelector('tbody tr:nth-child(3) td:nth-child(5)');
const date2_1 = document.querySelector('tbody tr:nth-child(3) td:nth-child(6)');
const note2_1 = document.querySelector('tbody tr:nth-child(3) td:nth-child(7)');
const teacher2_1 = document.querySelector('tbody tr:nth-child(3) td:nth-child(8)');
const date2_2 = document.querySelector('tbody tr:nth-child(4) td:nth-child(1)');
const note2_2 = document.querySelector('tbody tr:nth-child(4) td:nth-child(2)');
const teacher2_2 = document.querySelector('tbody tr:nth-child(4) td:nth-child(3)');

const name3 = document.querySelector('tbody tr:nth-child(5) td:nth-child(2)');
const email3 = document.querySelector('tbody tr:nth-child(5) td:nth-child(3)');
const phone3 = document.querySelector('tbody tr:nth-child(5) td:nth-child(4)');
const takeOff3 = document.querySelector('tbody tr:nth-child(5) td:nth-child(5)');
const date3_1 = document.querySelector('tbody tr:nth-child(5) td:nth-child(6)');
const note3_1 = document.querySelector('tbody tr:nth-child(5) td:nth-child(7)');
const teacher3_1 = document.querySelector('tbody tr:nth-child(5) td:nth-child(8)');
const date3_2 = document.querySelector('tbody tr:nth-child(6) td:nth-child(1)');
const note3_2 = document.querySelector('tbody tr:nth-child(6) td:nth-child(2)');
const teacher3_2 = document.querySelector('tbody tr:nth-child(6) td:nth-child(3)');
const date3_3 = document.querySelector('tbody tr:nth-child(7) td:nth-child(1)');
const note3_3 = document.querySelector('tbody tr:nth-child(7) td:nth-child(2)');
const teacher3_3 = document.querySelector('tbody tr:nth-child(7) td:nth-child(3)');

name1.innerHTML = student_warning.students[0].name;
email1.innerHTML = student_warning.students[0].email;
phone1.innerHTML = student_warning.students[0].phone;
date1_1.innerHTML = student_warning.students[0].detail_info[0].date;
note1_1.innerHTML = student_warning.students[0].detail_info[0].note;
date1_2.innerHTML = student_warning.students[0].detail_info[1].date;
note1_2.innerHTML = student_warning.students[0].detail_info[1].note;

name2.innerHTML = student_warning.students[1].name;
email2.innerHTML = student_warning.students[1].email;
phone2.innerHTML = student_warning.students[1].phone;
date2_1.innerHTML = student_warning.students[1].detail_info[0].date;
note2_1.innerHTML = student_warning.students[1].detail_info[0].note;
date2_2.innerHTML = student_warning.students[1].detail_info[1].date;
note2_2.innerHTML = student_warning.students[1].detail_info[1].note;

name3.innerHTML = student_warning.students[2].name;
email3.innerHTML = student_warning.students[2].email;
phone3.innerHTML = student_warning.students[2].phone;
date3_1.innerHTML = student_warning.students[2].detail_info[0].date;
note3_1.innerHTML = student_warning.students[2].detail_info[0].note;
date3_2.innerHTML = student_warning.students[2].detail_info[1].date;
note3_2.innerHTML = student_warning.students[2].detail_info[1].note;