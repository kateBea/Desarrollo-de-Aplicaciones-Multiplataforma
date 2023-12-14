import axios from "axios";

// puerto del servidor
const PORT = 4000;
const API = `http://localhost:${PORT}`;

export const RegisterRequest = (valores) => axios.post(`${API}/registro`, valores);
export const ConsultaRequest = () => axios.post(`${API}/productos`);