import React from 'react';

const HomePage=props=>{
    console.log(props);

    const link=`http://localhost:8080/${props.person}/index`
    return(

        <div align="center">
            <a href={link}>If you are a {props.person} </a>
        </div>
    );
};

export default HomePage;