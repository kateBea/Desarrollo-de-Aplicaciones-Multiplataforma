import React from 'react'
import { dataContext } from "../context/Context.jsx";

function CheckPage() {
    const { send, getProducts, errors: registerErrors } = dataContext();

    return (
        <div 
            className="flex min-h-full flex-col justify-center px-6 py-5 lg:px-8">
            <div 
                className='container mx-auto'>
                <nav 
                    className="flex justify-between px-5 py-5 items-center bg-slate-600 rounded-md">
                    <h1 
                        className="text-xl text-white font-bold">Examen 2 DAM - Consulta</h1>
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
        </div>

    )
}

export default CheckPage