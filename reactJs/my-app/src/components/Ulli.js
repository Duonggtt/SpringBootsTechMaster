import React,{useState} from "react";

function Ulli() {

    const [items, setItems] = useState(['Item 1', 'Item 2', 'Item 3']);
    const [inputValue, setInputValue] = useState('');
    const [isHiden, setIsHiden] = useState(false);

    function getLiFromInput() {
        setItems([...items,inputValue]);
        setInputValue('');
    }

    function isHideAndShow() {
        setIsHiden(!isHiden);
    }

    const handleInputChange = (event) => {
        setInputValue(event.target.value);
    }

    function removeItem() {
        const newList = [...items];
        newList.pop();
        setItems(newList);
    }
 
    return (
        <div>
            <button onClick={isHideAndShow}>{isHiden ? 'show' : 'hide'}</button>
            {!isHiden ? 
            <ul>
                {items.map((item,i) => (
                    <li key = {i}>{item}</li>
                ))}
            </ul> : null}
            <input id="addInput" value={inputValue} onChange={handleInputChange}/>
            <button onClick={getLiFromInput}>Add</button>
            <button onClick={removeItem}>Remove</button>
        </div>
    )
}

export default Ulli;