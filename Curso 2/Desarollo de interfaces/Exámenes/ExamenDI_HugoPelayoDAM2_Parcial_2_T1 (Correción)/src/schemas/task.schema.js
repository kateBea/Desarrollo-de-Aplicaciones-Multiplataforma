import { z } from 'zod';

export const createTaskSchema = z.object({
    title: z
        .string({
            required_error: "Debes añadir un título",
        }),
    description: z
        .string({
            required_error: "La descripción debe de ser un string",
        }),
    date: z
        .string().datetime().optional(),
});