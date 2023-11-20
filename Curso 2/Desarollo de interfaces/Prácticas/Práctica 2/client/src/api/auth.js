import axios from "axios";

// puerto del servidor
const PORT = 4000;
const API = `http://localhost:${PORT}`;

const RegisterRequest = (user) => axios.post(`${API}/register`, user);


export default RegisterRequest;