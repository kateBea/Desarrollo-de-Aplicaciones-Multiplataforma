import React from 'react'
import { useForm } from "react-hook-form"
import { dataContext } from "../context/Context.jsx";

function RegisterProductsPage() {
    const { register, handleSubmit, formState: { errors } } = useForm();
    const { send, getProducts, errors: registerErrors } = dataContext();

    // se hace cargo de mandar los datos a nuestr DB
    const submitData = handleSubmit(async function(values) {
        send(values);
    })

    return (
        <div
            className="flex min-h-full flex-col justify-center px-6 py-5 lg:px-8">
            <div
                className='container mx-auto'>
                <nav
                    className="flex justify-between px-5 py-5 items-center bg-slate-600 rounded-md">
                    <h1
                        className="text-xl text-white font-bold">Examen 2 DAM - Inicio</h1>
                    <div
                        className="flex items-center">
                        <ul
                            className="flex items-center space-x-6">
                            <li
                                className="mr-3">
                                <a
                                    className="inline-block border border-blue-500 rounded py-1 px-3 bg-blue-500 text-white" href="/">Inicio</a>
                            </li>

                            <li
                                className="mr-3">
                                <a
                                    className="inline-block border border-blue-500 rounded py-1 px-3 bg-blue-500 text-white" href="/registro">Registro</a>
                            </li>
                            <li
                                className="mr-3">
                                <a
                                    className="inline-block border border-blue-500 rounded py-1 px-3 bg-blue-500 text-white" href="/productos">Consulta</a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>

            <div
                className="mt-10 rounded-md sm:mx-auto sm:w-full sm:max-w-sm bg-slate-600 p-5 shadow-lg">
                <h2
                    className="text-2xl font-bold leading-9 tracking-tight text-white">Villablanca - Registro piezas</h2>
                <form
                    className="space-y-6 mt-5"
                    onSubmit={ submitData }>
                    <div>
                        <div
                            className="mt-2">
                            <input
                                id="nombre"
                                name="nombre"
                                type="text"
                                {...register("nombre", { required: true })}
                                placeholder='Nombre de pieza'
                                className="block w-full rounded-md border-0 px-2 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6" />

                            {errors.nombre && (<p className="text-red-700 mt-1">El nomnbre de producto es obligatorio.</p>)}
                        </div>
                    </div>

                    <div>
                        <div
                            className="mt-2">
                            <input
                                id="precio"
                                name="precio"
                                type="text"
                                {...register("precio", { required: true })}
                                placeholder='Introduce el precio'
                                className="block w-full rounded-md border-0 px-2 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6" />

                            {errors.precio && (<p className="text-red-700 mt-1">El precio de producto es obligatoria.</p>)}
                        </div>
                    </div>

                    <div>
                        <div
                            className="mt-2">
                            <textarea
                                placeholder='Descripción'
                                name='descripcion'
                                {...register("descripcion", { required: true })}
                                className="block w-full rounded-md border-0 px-2 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"></textarea>

                            {errors.descripcion && (<p className="text-red-700 mt-1">La descripción del producto es obligatoria.</p>)}
                        </div>
                    </div>

                    <div>
                        <button
                            type="submit"
                            className="flex rounded-md bg-indigo-600 px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">Grabar</button>
                    </div>

                    <div className="flex">
                        <div className="w-1/5 h-12 text-white">
                            <a href='/productos'>Consulta</a>
                        </div>

                        <div className="w-3/5 h-12"></div>

                        <div className="w-1/5 h-12 text-right text-white">
                            <a href='/'>Inicio</a>
                        </div>
                        </div>
                </form>
            </div>
        </div>
    )
}

export default RegisterProductsPage