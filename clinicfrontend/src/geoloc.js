import React from 'react';
import ReactDOM from 'react-dom'
import SeasonDisplay from 'Seasondisplay'


// in this function 
//first denotes return on successful callback
//second denotes return on error callback
//functional component fails on async operations
//we get position even before geolocation returns actual
//location
/*const App=()=>{
    window.navigator.geolocation.getCurrentPosition(
        position=>console.log(position),
        err=>console.log(err)
    );

    return <div>Latitude: </div>;
};
*/

//Converting functional component to class based component
//state in react to overcome above problem

//Learning to initialize state
//super(props) compulsory to mention first in constructor
class App extends React.Component{
    //constructor(props)
    //{
      //  super(props);

        //this.state={lat: null,errorMsg:''};

        //These two changes is same as using constructor before
        state={lat: null,errorMsg:''};

       componentDidMount(){
           window.navigator.geolocation.getCurrentPosition(
            position=>{
                this.setState({lat:position.coords.latitude});

                // we did not !!! not to be done at all
                //this.state.lat=position.coords.latitude
        },
            err=>{this.setState({errorMsg: err.message});
        }
        );
    }

    //React says Class must have a render()
    render(){ 
        
        if(this.state.errorMsg && !this.state.lat)
        {
            return(<div>
                Error:{this.state.errorMsg}
            </div>);
        }

        if(!this.state.errorMsg && this.state.lat)
        {
            return(
                <div>
                    <SeasonDisplay lat={this.state.lat}/> 
                </div>
            );
        }
        return(
        <div>
            Loading !
        </div>
        );

    }
}


ReactDOM.render(<App/>,document.querySelector('#root'));

//OUTPUT on Executing this code 

//Latitude: 28.670772799999998