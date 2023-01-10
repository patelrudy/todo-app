import React, { useEffect, useState } from 'react'

const TodoItem = (props) => {
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

    return (
        <>
            <input
                type='checkbox' checked={todoItem.isComplete}
                onChange={() => {
                    setIsUpdated(true);
                    setTodoItem({ ...todoItem, isComplete: !todoItem.isComplete })

                }}
            />
            <span>{todoItem.task}</span>
        </>
    )
};

export default TodoItem;