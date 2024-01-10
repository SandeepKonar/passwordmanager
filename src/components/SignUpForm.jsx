import React, {useState} from 'react';
import Input from './Input';
import {useNavigate} from 'react-router-dom';
import {Link} from 'react-router-dom';

function SignUpForm(){
    const navigate = useNavigate();
    const emptyUser = {
        username: "",
        password: "",
        confirmPassword: ""
    }
    const [user, setUser] = useState(emptyUser);

    function handleOnChange(event){
        const { id, value }=  event.target;
        setUser(prevUser => {
            return {
                ...prevUser,
                [id]: value
            }
        })
    }

    function submitSignUp(event){
       if(user.password!== user.confirmPassword){
             alert("Password and ConfirmPassword should match.. Please recheck and submit");
       }else {
            //TODO 
            // first check if user exists in db
            // if not exist add to db and then return success alert 
            // if exist then return error alert
            // for now just adding success message
            alert("SuccessFully Registered. Please login ");
            setUser(emptyUser);
       }
       event.preventDefault();
    }
 
    return <form onSubmit={submitSignUp}>
            <h1 className="h3 mt-5 mb-3 fw-normal sign-up-title ">Sign up</h1>
            <Input type="text" id="username" value={user.username} placeholder="Username" onChange={handleOnChange}/>
            <Input type="password" id="password" value={user.password} placeholder="Password" onChange={handleOnChange}/>
            <Input type="password" id="confirmPassword" value={user.confirmPassword} placeholder="ConfirmPassword" onChange={handleOnChange}/>
            <button className="btn btn-primary mt-3 w-100 py-10" type="submit" >Sign up</button>
            <h2 className= "h6 mt-3 fw-normal">Already had an account ? <span><Link className="login-link" to="/LoginPage">Login</Link></span></h2>
        </form>
        
}

export default SignUpForm;