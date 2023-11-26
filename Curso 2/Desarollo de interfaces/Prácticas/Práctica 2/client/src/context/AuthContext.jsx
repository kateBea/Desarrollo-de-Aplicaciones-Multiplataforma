import { creareContext, useState, useContext, createContext } from "react";
import RegisterRequest from "../api/auth.js";

export const AuthContext = createContext();

export const useAuth = () => {
    const context = useContext(AuthContext);

    if (!context) {
        throw Error("useAuth de ser usado sin un authProvider");
    }

    return context;
};

export const AuthProvider = ({ children }) => {
    const [user, setUser] = useState(null);
    const [isAuthenticated, setIsAuthenticated] = useState(false);
    const [erros, setErrors] = useState([]);

    const signup = async (user) => {
        try {
            const res = RegisterRequest(user);

            console.log(res.data);

            setUser(res.data);
            setIsAuthenticated(true);
        } catch (error) {
            setErrors(error.response.data);
        }
    };

    return (
        <AuthContext.Provider value={{signup, user, isAuthenticated, erros, }}>
            { children }
        </AuthContext.Provider>
    );
}; 