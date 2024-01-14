import express from "express";
import userController from "../controllers/userController.js";

const router = express.Router();

router.post('/authenticate', userController.authenticate);

router.post('/checkIfUserExists', userController.checkIfUserExists);

router.post('/addUserDetails', userController.addUserDetails);
export default router;