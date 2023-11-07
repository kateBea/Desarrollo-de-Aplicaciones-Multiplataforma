// parte 7 de mongo db pratica. No está en los puntes
// sirve para establevcer conexión con axios. Está incompleo
// falta la parte del export, mira por la web como debe ser.

import axios from "axios";

const API = "http://localhost:4000/api";

export const registerRequest = user => axios.post(API + "/register")