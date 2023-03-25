import React, { useEffect, useState } from "react";

function Counter() {
    //const [share, setShape] = useState("square");
    const [counter, setCounter] = useState(0);
    

    const plus = () => {
        setCounter(counter + 1);
    }

    const prev = () => {
        setCounter(counter - 1);
    }
    
    return (
        <div class="main-container">
            <h1 class="title">Đếm số</h1>
            <h1 id="counter" style={{color: counter > 0 ? "green" : counter < 0 ? "red" : "#3333333"}}>{counter}</h1>
            <div class="btn-container">
                <button class="btn counterBtn prevBtn" onClick={prev}>Trừ</button>
                <button class="btn counterBtn nextBtn" onClick={plus}>Cộng</button>
            </div>
        </div>
    );
}
export default Counter;