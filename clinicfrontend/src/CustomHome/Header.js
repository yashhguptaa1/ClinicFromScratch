import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import GoogleAuth from './GoogleAuth';


class Header extends Component {
    //state = {  }



    render() {
        return (
            <div className="ui secondary  menu">
                <Link to="/" className="item">
                    Home
            </Link>
                < Link to="/doctor/book" className="item">
                    Book An Appointment
            </Link>
                <Link to="/doctor/consult" className="item active">
                    Video Consultation
            </Link>
                <div className="right menu">
                    <div className="item">
                        <div className="ui icon input">
                            <input type="text" placeholder="Search..." />
                            <i className="search link icon">
                            </i>
                        </div>
                    </div>
                    <GoogleAuth />
                </div>
            </div>
        );
    }
}

export default Header;





