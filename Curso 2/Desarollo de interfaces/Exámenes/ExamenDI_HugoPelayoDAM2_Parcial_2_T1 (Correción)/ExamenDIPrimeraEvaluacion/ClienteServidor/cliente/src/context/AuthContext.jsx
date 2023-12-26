import { createContext, useState, useContext, useEffect } from 'react';
import { registerRequest, getProductosRequest } from '../api/auth.js'


export const AuthContext = createContext();

export const useAuth = () => {
    const context = useContext(AuthContext);
    if (!context) {
        throw new Error("useAuth debe ser usado dentro de un provider");
    }
    return context;
};

export const AuthProvider = ({ children }) => {
    const [user, setUser] = useState(null);
    const [productos, setProductos] = useState([]);
    
    const [errors, setErrors] = useState([]);


    const cogerProductos = async () => {
        console.log("Aquí estoy")
        const res = await getProductosRequest()
        console.log(res.data)
        setProductos(res.data)
    }

    const regProductos = async (user) => {
        try {
            const res = await registerRequest(user);
            console.log(res.data);
            setUser(res.data);
            
        } catch (error) {
            console.log(error);
            setErrors(error.response.data);
        }
    };

    return (
        <AuthContext.Provider
            value={{
                cogerProductos,
                user,
                productos,
                errors,
                regProductos,
            }}
        >
            {children}
        </AuthContext.Provider>
    )
}