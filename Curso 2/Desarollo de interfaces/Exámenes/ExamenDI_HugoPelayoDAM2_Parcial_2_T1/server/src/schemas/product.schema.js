/**
 * Define el esquema de tipos de campos para
 * nuestro productos a la hora de registrarlos.
 * 
 * 4 dec 2023
 * Hugo Pelayo
 * Node ver: v18.8.0
 * */

import { z } from "zod";

export const createSchema = z.object({
    nombre: z.string({
        required_error: "El nombre es un string y es obligatorio",
    }),
    precio: z.string({
        required_error: "El precio es un string y es obligatorio",
    }),
    descripcion: z.string({
        required_error: "La descripción debe de ser un string y es oblihgatoria",
    }),
    date: z.string().datetime().optional(),
});