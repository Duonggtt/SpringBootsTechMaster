import React from "react";

function TodoItem({todo, onDelete}) {

    const handleDelete = () => {
        onDelete(todo.id);
    };

    return (
        <li>
            {todo.title}
            <button onClick={handleDelete}>Edit</button>
            <button onClick={handleDelete}>Delete</button>
        </li>
    )
}

export default TodoItem;