import React, { useEffect } from "react";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../context/AuthContext.jsx";

function RegisterPage() {
    const navigate = useNavigate();

    const { register, handleSubmit, formState: { errors } } = useForm();
    const { signup, user, isAuthenticated, erros: registerErros } = useAuth();

    useEffect(() => {
        if (isAuthenticated) {
            navigate("/tasks");
        }
    }, [isAuthenticated]);

    const onSubmit = handleSubmit(async (values) => {
        signup(values);
    });

    return (
        <div className="bg-zinc-800 p-10 rounded-md flex justify-center items-center">
            {
                registerErros.map((error, i) => {
                    <div className="bg-red-500 p-2 text-white" key={i}>
                        { error }
                    </div>
                })
            }

            <form onSubmit={ onSubmit }>

                <input type="text" {...register("username", { required: true})}  className="w-full bg-zinc-700 text-white px-4 py-2 rounded-m my-2" placeholder="Usuario"/>

                {
                    errors.username && (
                        <p className="text-red-500">
                            El usuario es requerido
                        </p>
                    )
                }


                <input type="email" {...register("email", { required: true})}  className="w-full bg-zinc-700 text-white px-4 py-2 rounded-m my-2" placeholder="Correo electrónico"/>
                
                {
                    errors.email && (
                        <p className="text-red-500">
                            El e-mail es requerido
                        </p>
                    )
                }

                <input type="password" {...register("password", { required: true })} className="w-full bg-zinc-700 text-white px-4 py-2 rounded-m my-2" placeholder="Contraeña"/>

                {
                    errors.password && (
                        <p className="text-red-500">
                            La contraseña es requerida
                        </p>
                    )
                }
                <button type="submit" className="bg-slate-600 text-white rounded-md py-2 px-4 my-2">
                    Registrar
                </button>
            </form>
        </div>
    )
};

export default RegisterPage