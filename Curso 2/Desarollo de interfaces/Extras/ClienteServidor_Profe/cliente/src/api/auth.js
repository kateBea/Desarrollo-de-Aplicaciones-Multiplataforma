//import axios from 'axios';
import axios from './axios.js'

//const API='http://localhost:4000/api';

//export const registerRequest = user => axios.post(`${API}/register`, user)
export const registerRequest = user => axios.post(`/register`, user);

//export const loginRequest = user => axios.post(`${API}/login`, user)
export const loginRequest = (user) => axios.post(`/login`, user);

export const verityTokenRequest = () => axios.get('/verify')