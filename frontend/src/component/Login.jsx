function Login() {
    return (
        <>
            <div className="login-container">
                <div className="logo-container">

                </div>
                <div className="login-form-container">
                    <form className="login-form" action="#">
                        <input type="text" placeholder="username"></input>
                        <input type="password" placeholder="password"></input>
                        <button type="submit" className="login-button">Login</button>
                    </form>
                    <a href="#">Signup</a>
                </div>
            </div>
        </>
    );
}

export default Login;

//  bo_eps1@licindia.com.