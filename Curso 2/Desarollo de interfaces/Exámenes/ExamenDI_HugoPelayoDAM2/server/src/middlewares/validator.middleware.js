/**
 * Para validar esquemas de datos.
 * 
 * 6 nov 2023
 * Hugo Pelayo
 * Node ver: v18.8.0
 * */

export const validateSchema = (schema) => (req, res, next) => {
    try {
        schema.parse(req.body);
        next();
    }
    catch(error) {
        return res.status(400).json({ error: error.errors.map(error => error.message) });
    }
}