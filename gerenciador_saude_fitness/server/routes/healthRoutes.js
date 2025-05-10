import express from 'express';
import { getDados, putDados } from '../controllers/healthController.js';

const router = express.Router();

router.get('/:id/dados', getDados);
router.put('/:id/dados', putDados);

export default router;
