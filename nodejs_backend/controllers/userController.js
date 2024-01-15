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
    user.findOne({username: req.body.username})
    .then(usr => {
        if(!usr) {
            res.status(404).send({message: 'user not found!'});
        }else {
            res.status(200).json(usr);
        }
    }).catch(err => {
        console.log(err);
        console.log("Error occured while finding user");
        res.status(500).send({message: 'Error occured while finding user'});
    })
}

userController.addUserDetails = (req,res) => {
     const newUser = new user({
        username: req.body.username,
        password: req.body.password
     });
     newUser.save().then(usr => {
        if(!usr){
            res.status(500).send({message: "Error while saving user data"})
        }else {
            res.status(200).send({message: "Successfully saved User details"})
        }
     }).catch(err => {
        console.log(err);
        res.status(500).send({message: "Error while saving user data"})
    })
}


export default userController;