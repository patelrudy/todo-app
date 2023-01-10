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

  function addNewTodoItem() {
    fetch('http://localhost:8080/api/todoItems', {
      headers: {
        "content-type": "application/json",
      },
      method: 'POST',
    })
      .then(response => response.json())
      .then((data) => {
        console.log(data);
        setTodoItems([...todoItems, data]);
      });
  }

  function handleTodoItemDelete(item) {
    const updatedTodoItems = todoItems.filter(data => data.id !== item.id);
    console.log("updated todo Items after delete", updatedTodoItems);
    setTodoItems([...updatedTodoItems]);

  }

  return (
    <>
      <div>
        <button onClick={addNewTodoItem}> Add new task </button>
      </div>
      <div>
        {todoItems
          ? todoItems.map(todoItem => {
            return (
              <TodoItem key={todoItem.id} data={todoItem} emitDeleteTodoItem={handleTodoItemDelete} />
            );
          })
          : 'Loading'}
      </div>
    </>
  );
}

export default App;
