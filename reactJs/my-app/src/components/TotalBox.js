import React, { useEffect, useState } from "react";

let colors = [
    '#3498db',
    '#9b59b6',
    '#e74c3c',
    '#2c3e50',
    '#d35400',
]

function TotalBox() {

    const [boxQuantity,setBoxQuantity] = useState(5);
    const [point,setPoint] = useState(5);
    
    function addBlock() {
        setBoxQuantity(boxQuantity + 5);
        setPoint(point + 5);
    }

    function blockHandle() {
        setBoxQuantity(boxQuantity - 1);
        setPoint(point - 1);
    }

    const boxes = [];
    let j = 0;
    for(let i = 0; i < boxQuantity; i++) {
        const boxColor = {backgroundColor: colors[j]};
        j++;
        if(j == colors.length - 1) {
            j = 0;
        }
        console.log(colors[i]);
        boxes.push(<div key={i} className="box" style={boxColor} onClick={blockHandle}></div>)
    }

    return (
        <div className="wrap">
            <h1> JS DOM</h1>
            <button id="btn" onClick={addBlock}>More boxes</button>
            <h4 id="score"> Total box:<span className="points">{point}</span></h4>
            <div className="boxes">{boxes}</div>
        </div>
    );
}
export default TotalBox;