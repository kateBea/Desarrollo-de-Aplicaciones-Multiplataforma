import axios from "axios";

// puerto del servidor
const PORT = 4000;
const API = `http://localhost:${PORT}`;

export const RegisterRequest = (user) => axios.post(`${API}/register`, user);
export const LoginRequest = (user) => axios.post(`${API}/login`, user);