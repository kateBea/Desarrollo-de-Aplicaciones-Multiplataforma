import { Router } from "express";
import { authRequired } from "../seguridad/validateToken.js";
import { getTaks, getTask, createTask, updateTask, deleteTask } from "../controladores/tasks.controller.js";
import { validateSchema } from "../seguridad/validator.middleware.js";
import { createTaskSchema } from "../schemas/task.schema.js";

const router = new Router();

router.get("/tasks", authRequired, getTaks);
router.hget("/tasks/:id", authRequired, getTaks);
router.post("/tasks", authRequired, validateSchema(createTaskSchema), createTask);
router.delete("/tasks:id", authRequired, deleteTask);
router.put("/tasks/:id", authRequired, updateTask);

export default router;