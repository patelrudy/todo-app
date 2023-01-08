import './App.css';
import {useEffect} from "react";

function App() {

  useEffect(() => {
    console.log("initialized");
    fetch('http://localhost:8080/api/todoItems')
    .then((response) => response.json()
    ).then(todoItems => {
      console.log("Todo items list: ", todoItems);
    });
  });

  return <div> Hi There !</div>;
}

export default App;
