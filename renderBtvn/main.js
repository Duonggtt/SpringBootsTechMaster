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


const body = document.querySelector('tbody');
const table = document.querySelector('table');
let studentList = student_warning.students;
let teacherList = student_warning.teachers;
let className = student_warning.class;
let course = student_warning.course;
let sessions = student_warning.sessions;

//render header table

var headerRow = table.insertRow();
headerRow.style.backgroundColor = '#5f9ea0';
headerRow.style.color = 'white';
var stt = headerRow.insertCell(0);
stt.innerText = '#';
var nameCell = headerRow.insertCell(1);
nameCell.innerText = 'Họ tên';
var emailCell = headerRow.insertCell(2);
emailCell.innerText = 'Email';
var phoneCell = headerRow.insertCell(3);
phoneCell.innerText = 'Số điện thoại'
var takeOff = headerRow.insertCell(4);
takeOff.innerText = 'số buổi nghỉ';
var dateTakeOff = headerRow.insertCell(5);
dateTakeOff.innerText = 'Ngày nghỉ học';
var noteCell = headerRow.insertCell(6);
noteCell.innerText = 'Ghi chú';
var teacherCell = headerRow.insertCell(7);
teacherCell.innerText = 'Giảng viên';


//render body table

for(let i = 0 ; i < studentList.length;i++) {
    var row = table.insertRow();
    var stdSTT = row.insertCell(0);
    stdSTT.innerText = i+1;
    stdSTT.setAttribute('rowSpan', studentList[i].detail_info.length);
    var stdName = row.insertCell(1);
    stdName.innerText = studentList[i].name;
    stdName.setAttribute('rowSpan', studentList[i].detail_info.length);
    var stdEmail = row.insertCell(2);
    stdEmail.innerText = studentList[i].email;
    stdEmail.setAttribute('rowSpan', studentList[i].detail_info.length);
    var stdPhone = row.insertCell(3);
    stdPhone.innerText = studentList[i].phone;
    stdPhone.setAttribute('rowSpan', studentList[i].detail_info.length);
    var stdOff = row.insertCell(4);
    stdOff.innerText = studentList[i].total_off + '/' + studentList[i].sessions;
    stdOff.className = 'text-center';   
    stdOff.setAttribute('rowSpan', studentList[i].detail_info.length);
}