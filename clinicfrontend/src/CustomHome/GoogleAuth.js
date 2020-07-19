import React, { Component } from 'react';
//import {connect} from 'react-redux';
//import {signIn,signOut} from '../actions';

class GoogleAuth extends Component {
    state = {isSignedIn: null  };

    componentDidMount()
    {
        window.gapi.load('client:auth2',()=>{
            window.gapi.client.init({
                clientId:'328479823716-5r60rh45fqpt37snug1vqg8pputmmjm1.apps.googleusercontent.com',
                scope: 'email'
            }).then(()=>{
                this.auth=window.gapi.auth2.getAuthInstance();
                this.setState({isSignedIn: this.auth.isSignedIn.get()})
                this.auth.isSignedIn.listen(this.onAuthChange);
            });
        });
    }

    onAuthChange=()=>{
        this.setState({isSignedIn: this.auth.isSignedIn.get()});
    };

    onSignIn=()=>{
        this.auth.signIn();

    };

    onSignOut=()=>{
        this.auth.signOut();
    };

    renderAuthButton(){

        if(this.state.isSignedIn===null){
            return null;
        }
        else if(this.state.isSignedIn)
        {
            return(
                <button onClick={this.onSignOut} className="ui red google button">
                    <i className="google icon"/>
                    Logout
                </button>
            );
        }
        else
        {
            return(
                <button onClick={this.onSignIn} className="ui red google button">
                    <i className="google icon"/>
                    Login with Gmail
                </button>
            );
        }
    }

    render() { 
        return ( 
            <div>
                {this.renderAuthButton()}            
            </div>
         );
    }
}
 
export default GoogleAuth;