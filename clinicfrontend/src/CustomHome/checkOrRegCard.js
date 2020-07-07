import React from 'react'

const checkOrReg=(props)=>{
    console.log(props.children);
    return(
        <div className="ui card">
            <div className="content">{props.children}
            </div>
                <div className="extra content">
                    <div className="ui basic green button">
                        Check Booking 
                    </div>
                    <div className="ui basic red button">
                        Register
                    </div>
                </div>
        </div>
    );
};

export default checkOrReg;