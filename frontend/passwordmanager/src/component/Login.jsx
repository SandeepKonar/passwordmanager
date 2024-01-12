import React, { useState } from "react";
import { webClient } from "../scripts/config";
import Input from "./Input";

function Login() {
    const [inputs, setInputs] = useState({
        "username": "",
        "password": ""
    });

    const [error, setError] = useState(false);

    const validateUser = () => {
        webClient.post('/login', inputs).then(response => {
            alert("success - user found");
        }).catch(error => {
            console.log(error);
            alert('error ' + error.response.data.message);
        });
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        const username = inputs.username;
        const password = inputs.password;
        if(username.trim() === "")
            setError(true);
        else if(password.trim() === "")
            setError(true);
        else {
            const res = validateUser();
            console.log(res);
        }
    };

    const onChange = (event) => {
        setInputs({...inputs, [event.target.name]: event.target.value});
        console.log(inputs[event.target.name]);
    }

    return (
        <>
            <div className="login-container">
                <div className="logo-container">

                </div>
                <div className="login-form-container">
                    <form className="login-form" onSubmit={handleSubmit} method="POST">
                        <Input
                            id="input1" type="text" name="username" placeholder="username" value={inputs.username}
                            onChange={onChange} disabled={false} error={error}
                        ></Input>
                        <Input
                            id="input2" type="password" name="password" placeholder="password" value={inputs.password}
                            onChange={onChange} disabled={false} error={error}
                        ></Input>
                        <input type="submit" className="login-button"/>
                    </form>
                    <a href="#">Signup</a>
                </div>
            </div>
        </>
    );
}

export default Login;