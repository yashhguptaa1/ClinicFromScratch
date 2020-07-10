import React, { Component } from 'react';
import Axios from 'axios';
import SingleSide from './SingleSide';
import Errorr from './Errorr';

class SideNews extends Component {
  constructor(props) {
    super(props);
    this.state = {
      sidenews: [],
      error: false,
    };
  }

  //Note from postman 
  //the whole data is in square brackets 
  //that means its an array

  componentDidMount() {
    const url = `http://localhost:8080/${this.props.news.type}/${this.props.news.query}`;

    //Axios.post(url,{})

    Axios.get(url)
    .then((response)=>{
        this.setState({
            sidenews:response.data
        })
    })
    .catch((error)=>{

        this.setState({
            error:true
        })
    });
    
  }

  renderItems() {
    if(!this.state.error)
    {
        return this.state.sidenews.map((item) => (
      <SingleSide key={item.id} item={item} />
    ));
    }
    else{
        return <Errorr/>
    }
  }
  

  render() {
    return (
    <ul>
        {this.renderItems()}
    </ul>
    );
  }
}

export default SideNews;
