import axios from 'axios';

export const registerRequest = user => axios.post(`http://localhost:4000/api/register`, user);

export const getProductosRequest = () => axios.get(`http://localhost:4000/api/tasks`);