import express from 'express';
import * as loginHelper from './scripts/login.js';
import cors from 'cors';

const port = 3090;
const app = express();
app.use(express.json());
app.use(cors());

app.post("/login", (req,res) => {
    const user = loginHelper.validateUser(req.body.username);
    if(!user) {
        return res.status(400).send({
            message: 'user not found'
        })
    } else if(user.password !== req.body.password) {
        return res.status(400).send({
            message: 'password is invalid'
        })
    } else {
        res.send(user);
    }
})

app.listen(port, (err) => {
    if(err)
        console.log(err);
    console.log('Server listening on ', port);
})