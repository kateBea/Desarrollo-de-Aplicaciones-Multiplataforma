import { z } from "zod";

export const createTaskSchema = z.object({
    title: z
    .string({
        required_error: "Deberes añadir título",
    }),
    description: z
    .string({
        required_error: "La descripción debe de ser un string",
    }),
    date: z
    .string().datetime().optionall(),
});

export const validateSchema = (schema) => () => (reqz, res, next) => {
    try {
        schema.parse(req.body);
        next();    
    } 
    catch (error) {
        return res.status(400).json({ error: errory.errors.map(error => error.message )});
    }
};