import express from "express";
import userController from "../controllers/userController.js";

const router = express.Router();

router.post('/authenticate', userController.authenticate);

export default router;