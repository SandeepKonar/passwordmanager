import React from "react";
import { useSelector } from "react-redux";


export default () => {
    const user = useSelector(store => store.user);
    console.dir(user);
    return (<>
        <h1>{user.username || 'please login'}</h1>
    </>);
}