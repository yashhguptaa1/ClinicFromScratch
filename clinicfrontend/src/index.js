import React from 'react';
import ReactDOM from 'react-dom';
// import aliasname from librarry name

function getButtonText()
{
  return 'click on me from function';
}
//Create a react component
const App=()=>{

  //1.
  //make sure the opening tag is on the same line as return
  //otherwise it will consider return undefined or use parenthesis

  //2.
  //Outer curly braces indicates we want to reference javascript variable
  //Inner curly braces indicate javascript object
  //background-color in html is same as
  //backgroundColor in JSX

  //3.
  //in html we use class in tags
  //in jsx we use className keyword

  //4. we can  directly reference javascript variables
  //replace buttonText in curly braces withfunction getButtonText
  const buttonText='click me from var';
  
  return (
  <div>
    <label className="label" htmlFor="name">
      ENTER NAME:
    </label>
    
    <input id="name" type="text"/>
    <button style={{backgroundColor:'red',color:'white'}}>
      {getButtonText()}
    </button>
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

 