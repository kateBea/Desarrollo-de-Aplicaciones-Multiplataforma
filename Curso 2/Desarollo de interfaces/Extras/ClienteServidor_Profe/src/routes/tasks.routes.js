import { Router } from 'express';
import { authRequired } from '../middlewares/validateToken.js';
import { getTasks, getTask, createTask, updateTask, deleteTask } from '../controllers/tasks.controller.js';
import { validateSchema } from '../middlewares/validator.middleware.js';
import { createTaskSchema } from '../schemas/task.schema.js';

const router = new Router();

router.get('/tasks', authRequired, getTasks);  //coger tareas
router.get('/tasks/:id', authRequired, getTask);
router.post('/tasks', authRequired, validateSchema(createTaskSchema), createTask);  //añadir tareas
router.delete('/tasks/:id', authRequired, deleteTask);  //eliminar tareas
router.put('/tasks/:id', authRequired, updateTask); //actualizar las tareas

export default router;