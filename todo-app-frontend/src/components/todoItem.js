import React, { useEffect, useState } from 'react'

const TodoItem = (props) => {
    const { emitDeleteTodoItem } = props;
    const [todoItem, setTodoItem] = useState(props.data);
    const [isUpdated, setIsUpdated] = useState(false);

    useEffect(() => {
        if (isUpdated) {
            fetch(`http://localhost:8080/api/todoItems/${todoItem.id}`, {
                method: 'PUT',
                headers: {
                    "content-type": "application/json",
                },
                body: JSON.stringify(todoItem),
            })
                .then(response => response.json())
                .then((data) => {
                    setIsUpdated(false);
                    setTodoItem(data);
                    console.log("Todo item updated", todoItem);
                });
        }

    }, [todoItem, isUpdated]);

    // useEffect(() => {
    //     console.log(todoItem.task);
    // }, [todoItem]);

    function updateTask(e) {
        setIsUpdated(true);
        setTodoItem({ ...todoItem, task: e.target.value });
        //added using useEffect because of react asyc
        // console.log(todoItem.task);
    }
    function deleteTodoItem() {
        fetch(`http://localhost:8080/api/todoItems/${todoItem.id}`, {
            method: 'DELETE',
            headers: {
                "content-type": "application/json",
            },
        })
            .then((response) => {
                console.log("Todo item deleted", todoItem);
                emitDeleteTodoItem(todoItem);
            })
            
    }


    return (
        <div>
            <input
                type='checkbox' checked={todoItem.isComplete}
                onChange={() => {
                    setIsUpdated(true);
                    setTodoItem({ ...todoItem, isComplete: !todoItem.isComplete })
                }}
            />

            {
                todoItem.isComplete ? (
                    <span style={{ textDecoration: "line-through" }}> {todoItem.task} </span>
                ) : (
                    <input type='text' value={todoItem.task} onChange={updateTask} />
                )
            }

            <span
                style={{ marginRight: "1rem", cursor: "pointer" }}
                onClick={deleteTodoItem}> 🗑️ </span>
        </div>
    );
};

export default TodoItem;