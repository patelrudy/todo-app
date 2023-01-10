import './App.css';
import React, { useEffect, useState } from "react";
import TodoItem from './components/todoItem';

function App() {
  const [todoItems, setTodoItems] = useState(null);



  useEffect(() => {
    console.log("initialized");

    if (!todoItems) {
      fetch('http://localhost:8080/api/todoItems')
        .then((response) => response.json())
        .then(data => {
          console.log("Todo items list: ", data);
          setTodoItems(data);
        });
    }
  }, [todoItems]);

  return (
    <div>
      {todoItems
        ? todoItems.map(todoItem => {
          return (
            <TodoItem key={todoItem.id} data={todoItem} />
          );
        })
        : 'Loading'}
    </div>
  );
}

export default App;
