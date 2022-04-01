// import logo from './logo.svg';
 import './App.css';

// function App() {
//   return (
//     <div className="App">
//       <header className="App-header">
//         <img src={logo} className="App-logo" alt="logo" />
//         <p>
//           Edit <code>src/App.js</code> and save to reload.
//         </p>
//         <a
//           className="App-link"
//           href="https://reactjs.org"
//           target="_blank"
//           rel="noopener noreferrer"
//         >
//           Learn React
//         </a>
//       </header>
//     </div>
//   );
// }

// export default App;

import React, { useState } from "react";

export default function MyComponent() {
    const [toggleButton, setButton] = useState("Off");

    return(
        <div>
            <p>This is a button that you can toggle on and off</p>
            <button
                variant="outlined"
                onClick={() => {
                    fetch("/toggle_button/" + toggleButton)
                        .then(response => 
                            response.json()
                        )
                        .then(data => {
                            setButton(data.button)
                        })
                        .catch(error => {
                            console.log(error)
                        })
                }}
            >
                {toggleButton}
            </button>
        </div>
    );
}

