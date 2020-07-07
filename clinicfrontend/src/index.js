import React from 'react';
import ReactDOM from 'react-dom';
import HomePage from './CustomHome/homepage';
import CR from './CustomHome/checkOrRegCard';


const App=()=>{
  return (
  <div >
    <CR>
      <HomePage person="doctor" />
    </CR>

    <CR>
      <HomePage person="patient"/>
    </CR>

  </div>
  );
};

//Take the react component and show it on 
ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
);

 