import { webClient } from "./config";

function validateUser(username, password) {
    webClient.post('/login', {
        'username': username,
        'password': password
    }).then( response => {
        alert("success");
    }).catch(

    );
}