import { useState, useContext, createContext } from "react";
import { RegisterRequest }  from "../api/auth.js";

export const Context = createContext();

export const dataContext = () => {
    const context = useContext(Context);

    if (!context) {
        throw Error("Context debe ser usado con un Provider");
    }

    return context;
};

export const Provider = ({ children }) => {
    const [errors, setErrors] = useState([]);

    const send = async function(data) {
        console.log(data);

        try {

            RegisterRequest(data)
            .then((result) => {
                console.log(result.data);
            })
            
        } catch (error) {
            setErrors(error.response.data);
        }
    };

    const getProducts = async function() {
        try {

            ConsultaRequest()
            .then((result) => {
                console.log(result);
            })
            
        } catch (error) {
            setErrors(error.response.data);
        }
    };

    return (
        <Context.Provider value={{ send, getProducts, errors, }}>
            { children }
        </Context.Provider>
    );
}; 