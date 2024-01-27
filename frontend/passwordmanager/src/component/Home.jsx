import React from "react";
import { useSelector } from "react-redux";
import AddAppForm from './AddAppForm';
import { useState } from "react";



export default () => {
    const user = useSelector(store => store.user);
    return (<>
        <h1>{user.username || 'please login'}</h1>
        <button type="button" className="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addAppModal">Launch demo modal </button>
        <AddAppForm />
    </>);
}