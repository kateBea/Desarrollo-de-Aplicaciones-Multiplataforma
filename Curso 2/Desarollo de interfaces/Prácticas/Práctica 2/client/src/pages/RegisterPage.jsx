import React from "react";
import { useForm } from "react-hook-form";
import RegisterRequest from "../api/auth.js"

function RegisterPage() {
    const { register, handleSubmit } = useForm();

    return (
        <div className="bg-zinc-800 max-w-md p-10 rounded-md">
            <form onSubmit={ handleSubmit((values) => { 
                console.log(values);
                const res = RegisterRequest(values)
                    .then((results) => {
                        console.log(results);
                    })
                    .catch((err) => {
                        console.log(err)
                    })
            }) }>

                <input type="text" {...register("username", { required: true})}  className="w-full bg-zinc-700 text-white px-4 py-2 rounded-m my-2" placeholder="Correo electrónico"/>
                <input type="password" {...register("password", { required: true })} className="w-full bg-zinc-700 text-white px-4 py-2 rounded-m my-2" placeholder="Contraeña"/>

                <button type="submit" className="bg-slate-600 text-white rounded-md py-2 px-4 my-2">
                    Registrar
                </button>
            </form>
        </div>
    )
};

export default RegisterPage