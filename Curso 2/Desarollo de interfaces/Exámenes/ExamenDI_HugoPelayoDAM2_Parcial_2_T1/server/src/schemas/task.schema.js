/**
 * Genera esquemas.
 * 
 * 6 nov 2023
 * Hugo Pelayo
 * Node ver: v18.8.0
 * */

import { z } from "zod";

export const createSchema = z.object({
    title: z.string({
        required_error: "Debes añadir un título",
    }),
    description: z.string({
        required_error: "La descripción debe de ser un string",
    }),
    date: z.string().datetime().optional(),
});