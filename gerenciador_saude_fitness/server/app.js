import express from 'express';
import cors from 'cors';
import dotenv from 'dotenv';
import userRoutes from './routes/userRoutes.js';
import planRoutes from './routes/planRoutes.js';
import healthRoutes from './routes/healthRoutes.js'; // ✅ Import correto

dotenv.config();
const app = express();

app.use(cors());
app.use(express.json());

app.use('/api/usuarios', userRoutes);
app.use('/api/planos', planRoutes);
app.use('/api/usuarios', healthRoutes); 

app.listen(process.env.PORT, () => {
  console.log(`Servidor rodando na porta ${process.env.PORT}`);
});
