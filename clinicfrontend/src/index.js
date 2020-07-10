import React from 'react';
import ReactDOM from 'react-dom';
//import HomePage from './CustomHome/homepage';
//import CR from './CustomHome/checkOrRegCard';
import News from './fetchaxios/News'

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      doc: {
        type: 'doctor',
        query: 'index'
      },
      pat: {
        type: 'patient',
        query: 'index'
      },
      book: {
        type: 'book',
        query: 'index'
      }
    };
  }

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <h1 className="App-title">My feed</h1>
        </header>
        <News news={this.state.doc} />
        <News news={this.state.pat} />
        <News news={this.state.book} />
      </div>
    );
  }
}

//Take the react component and show it on 
ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
);

 