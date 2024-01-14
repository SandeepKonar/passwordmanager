import user from "../schema/userSchema.js";

const userController = {};

userController.authenticate = (req, res) => {
    let response;
    user.findOne({username: req.body.username})
        .then(usr => {
            if(!usr) {
                res.status(400).send({message: 'user not found!'});
            } else if(usr.password !== req.body.password) {
                res.status(400).send({message: 'password is invalid'});
            } else {
                res.status(200).json(usr);
            }
        }).catch(err => {
            console.log(err);
            console.log("validation failed!");
        })
}; 


userController.checkIfUserExists = (req,res) => {
    //for now just hardcoding the message
    res.status(400).send({message: "user does not exists"});
}

userController.addUserDetails = (req,res) => {
     //for now just hardcoding the message
    res.status(200).send({message: "Successfully saved User details"})
}

export default userController;