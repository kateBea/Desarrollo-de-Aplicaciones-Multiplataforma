import { z } from 'zod'

export const registerSchema = z.object({
    pieza: z
        .string({
            required_error: 'Se debe de introducir una pieza'
        }),
    precio: z
        .string({precio: {
            type: String,
            require: true,
        },
            message: "Se debe de introducir el precio"
        }),
    descripcion: z
        .string({descripcion: {
            type: String,
            require: true,
        },
            message: 'Se debe introducir una descripción'
        })
    
});

export const loginSchema = z.object({
    email: z
        .string({
            required_error: "Email es obligatorio",
        })
        .email({
            message: "Es obligatorio",
        }),
    password: z
        .string({
            required_error: "La password es obligatoria",
        })
        .min(6, { message: "Al menos de 6 caracteres", }),
});