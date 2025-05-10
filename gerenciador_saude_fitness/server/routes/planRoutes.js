import express from 'express';
import { escolherPlano } from '../controllers/planController.js';

const router = express.Router();

router.post('/escolher', escolherPlano);

export default router; 
