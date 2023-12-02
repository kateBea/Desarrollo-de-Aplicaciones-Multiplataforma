import { z } from 'zod'

export const registerSchema = z.object({
    username: z
        .string({
            required_error: 'Debes introducir el username'
        }),
    email: z
        .string({
            message: "El e-mail es inválido"
        }),
    password: z
        .string({
            required_error: "La password es requerida",
        })
        .min(6, {
            message: "Password debe de ser como mínimo de 6 caracteres",

        }),
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