import React, { Component } from 'react';


//for iterating over every piece of data
class AddDoctor extends Component{

    submitDoc(event)
    {
        //event.preventDefault();

        let doctor={
            doctorID: this.refs.id.value,
            name: this.refs.docName.value,
            phone: this.refs.phone.value,

        }

        fetch("http://localhost:8080/doctor/registerDoctor", {
            method: "POST",
            headers: {
                "content-type": "application/json",
            },
            body: JSON.stringify(doctor),
        })
        .then(response => response.json());

        window.location.reload();

    }

    render()
    {
        return(
            <div>
                <form class="ui form" onSubmit={this.submitDoc.bind(this)}>
                    <div class="field">
                        <label>Medical Registration Number</label>
                        <input type="text" ref="id" placeholder="Medical Registration Number"/>
                    </div>
                    <div class="field">
                        <label>First Name</label>
                        <input type="text" ref="docName" placeholder="First Name"/>
                    </div>
                    <div class="field">
                        <label>Phone</label>
                        <input type="text" ref="phone" placeholder="Phone"/>
                    </div>
                    <div class="field">
                    <div class="ui checkbox">
                        <input type="checkbox" tabindex="0" class="hidden"/>
                        <label>I agree to the Terms and Conditions</label>
                    </div>
                    </div>

                    <button class="ui button" type="submit">Submit</button>

                </form>
                
            </div>
        );
    }

} 

export default AddDoctor;   