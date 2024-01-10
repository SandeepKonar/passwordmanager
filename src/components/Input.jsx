import React from 'react';

function Input(props){
    return  <div className="form-floating">
        <input type={props.type} className="form-control" value={props.value} id={props.id} placeholder={props.placeholder} onChange={props.onChange} required/>
        <label htmlFor={props.id}>{props.placeholder}</label>
    </div>
}

export default Input;