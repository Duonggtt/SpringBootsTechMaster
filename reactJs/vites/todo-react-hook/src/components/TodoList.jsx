import React, { useEffect, useState } from "react";
import TodoItem from "./TodoItem";
const API_URL = "http://localhost:8081/api/todos";

function TodoList() {
    const [todos, setTodos] = useState([]);
    const [title, setTitle] = useState();
  
    useEffect(() => {
      const getAllTodoList = async () => {
          try {
              let todoList = await (await fetch(API_URL)).json();
              console.log("loading todoList:", todoList);
              setTodos(todoList);
          } catch (error) {
              console.error(error);
          }
      }
      getAllTodoList();
    }, []);
  
    const handeDelete = async (index) => {
      try {
        let result = await fetch(API_URL + "/" + index, {
          method: "DELETE",
        });
        if (result.status === 204) {
          let resultTodoList = todos.filter((todo) => todo.id !== index);
          setTodos(resultTodoList);
        } else {
          console.error(result);
          alert("error when delete");
        }
      } catch (error) {
        console.error(error);
      }
    };

    const addTodoItem = async () => {
      if(title.trim() === '') {
        alert("input is null !");
        return;
      }
      const newTodo = {
        title: title,
      };
      //goi Post API de tao todo moi
        try {
          let postResult = await fetch(API_URL, {
            headers: {
              'content-type': 'application/json ; charset=utf-8'
            },
            method: "POST",
            body: JSON.stringify(newTodo)
          });
          if(postResult.status === 201) {
            console.log(postResult);
            let createdTodo = postResult.json();
            let updatedTodoList = [...todos,createdTodo];
            setTodos(updatedTodoList);
            setTitle('');
          }else {
            console.error(postResult);
            alert("Error when add item !!!");
          }
        } catch (error) {
          console.error(error);
        }
      
    }

    const updateStatus = async id => {
      const todo = todos.find(todo => todo.id === id);
      let updateTodo = {}
    }
  
    return (
      <>
        <h1>TodoList App</h1>
        <input id="todoText" type="text" placeholder="Enter todo title..." value={title} onChange={e => setTitle(e.target.value)}/>
        <button id="addtodoButton" onClick={addTodoItem}>Add</button>
  
        <ul>
          {todos.length > 0 &&
            todos.map((todo) => (
              <TodoItem key={todo.id} todo={todo} onDelete={handeDelete} />
            ))}
        </ul>
      </>
    );
}

export default TodoList;