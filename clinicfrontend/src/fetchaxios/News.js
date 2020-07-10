import React, { Component } from 'react';
import NewSingle from './NewSingle';

class News extends Component {
  constructor(props) {
    super(props);
    this.state = {
      news: [],
    };
  }

  //Note from postman 
  //the whole data is in square brackets 
  //that means its an array

  componentDidMount() {
    const url = `http://localhost:8080/${this.props.news.type}/${this.props.news.query}`;

    //const url = 'http://localhost:8080/patient/index';

    fetch(url)
      .then((response) => {
        return response.json();
      })
      .then((data) => {
        this.setState({
          news: data
        })
      })
      .catch((error) => console.log(error));
  }

  renderItems() {
    // main thing to remember is that key must be unique
    //it can be system generated item.id
    //or we can consider id from our
    return this.state.news.map((item) => (
      <NewSingle key={item.id} item={item} />
    ));
  }
  
/*
  return this.state.news.map((item) => (
      <NewSingle key={item.id} item={item} />
    ));
  }
*/
  render() {
    return (
      <div>
        <div>
          {this.renderItems()}
        </div>
        
    </div>
    );
  }
}

export default News;
