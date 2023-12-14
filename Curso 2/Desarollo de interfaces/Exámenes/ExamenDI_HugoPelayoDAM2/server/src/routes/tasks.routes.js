/**
 * Define las rutas para las operaciones CRUD.
 * 
 * 6 nov 2023
 * Hugo Pelayo
 * Node ver: v18.8.0
 * */

import { Router } from "express";
import { createSchema } from "../schemas/task.schema.js";
import { validateSchema } from "../middlewares/validator.middleware.js";
import { autorizacionRequerida } from "../middlewares/validate.token.js";
import { getTasks, getTask, createTask, updateTask, deleteTask } from "../controllers/tasks.controller.js";

const router = new Router();

router.get("/tasks", autorizacionRequerida, getTasks);
router.get("/tasks/:id", autorizacionRequerida, getTask);

router.post("/tasks", autorizacionRequerida, validateSchema(createSchema), createTask);

router.delete("/tasks/:id", autorizacionRequerida, deleteTask);

router.put("/tasks/:id", autorizacionRequerida, updateTask);

export default router;