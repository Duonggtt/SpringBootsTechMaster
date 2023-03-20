//Vừa vào trang hiển thị danh sách quiz (bao gồm tiêu đề và danh sách các câu trả lời)
//Khi bấm vào nút “Random Answer” thì random câu trả lời cho từng câu hỏi và tự động được check vào (Mỗi câu hỏi chỉ check 1 câu trả lời)
const quizes = [
    {
        id: 1,
        question: "1 + 1 = ?",
        answers: [1, 2, 3, 4],
    },
    {
        id: 2,
        question: "2 + 2 = ?",
        answers: [2, 3, 4, 5],
    },
    {
        id: 3,
        question: "3 + 3 = ?",
        answers: [3, 4, 5, 6],
    },
];

const container = document.querySelector(".quiz-container");
const ranBtn = document.getElementById('btn');

function addQuizz(quizes) {
    for(let i = 0; i < quizes.length; i++) {
        const quizItem = document.createElement('div');
        const h3 = document.createElement('h3');
        const ans = document.createElement('div');
        
        quizItem.className = 'quiz-item';
        quizItem.appendChild(h3);
        ans.className = 'quiz-answer';
        quizItem.appendChild(ans);
        container.appendChild(quizItem);
        h3.innerText = `Câu ${quizes[i].question}`;
        for(let j = 0; j < quizes[i].answers.length; j++) {
            const quizAnswerItems = document.createElement('div');
            quizAnswerItems.className = 'quiz-answer-items';
            ans.appendChild(quizAnswerItems);
            const input = document.createElement('input');
            const label = document.createElement('label');
            input.type = 'radio';
            input.name = quizes[i].id;
            label.innerText = quizes[i].answers[j];
            quizAnswerItems.appendChild(input);
            quizAnswerItems.appendChild(label);
        }
    }
}
addQuizz(quizes);

ranBtn.addEventListener('click', function() {   
    const quizAnswerItems = document.querySelectorAll('.quiz-answer-items input');
    console.log(quizAnswerItems);
    btn.addEventListener("click", () => {
        quizes.forEach((quiz) => {
          const randomIndex = Math.floor(Math.random() * quiz.answers.length);
          const selectedAnswer = document.querySelectorAll('input[type="radio"]')[randomIndex];
          console.log(selectedAnswer);
          selectedAnswer.checked = true;
        });
      });
});