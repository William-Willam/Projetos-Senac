import express from 'express';
import { cadastrar, login } from '../controllers/userController.js';

const router = express.Router();

router.post('/register', cadastrar);
router.post('/login', login);

export default router;
