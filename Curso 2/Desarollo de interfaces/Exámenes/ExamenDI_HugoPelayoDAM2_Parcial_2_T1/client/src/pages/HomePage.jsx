import React from 'react'
import ReactLogo from '../assets/react.svg'


function HomePage() {
    return (
        <div className="flex min-h-full flex-col justify-center px-6 py-5 lg:px-8">
            <div className='container mx-auto'>
                <nav className="flex justify-between px-5 py-5 items-center bg-slate-600 rounded-md">
                    <h1 className="text-xl text-white font-bold">Examen 2 DAM - Inicio</h1>
                    <div className="flex items-center">
                        <ul className="flex items-center space-x-6">
                            <li className="mr-3">
                                <a className="inline-block border border-blue-500 rounded py-1 px-3 bg-blue-500 text-white" href="/">Inicio</a>
                            </li>
                            <li className="mr-3">
                                <a className="inline-block border border-blue-500 rounded py-1 px-3 bg-blue-500 text-white" href="/registro">Registro</a>
                            </li>
                            <li className="mr-3">
                                <a className="inline-block border border-blue-500 rounded py-1 px-3 bg-blue-500 text-white" href="/productos">Consulta</a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>

            <div className="mt-10 rounded-md sm:mx-auto sm:w-full sm:max-w-sm bg-slate-600 p-5 shadow-lg">
                <div className='container mx-auto flex justify-center items-center'>
                    <img src={ ReactLogo } alt="React logo" />
                </div>

                <h2 className="text-2xl font-bold leading-9 text-center tracking-tight text-white pt-5">Hugo Pelayo</h2>
                <h2 className="text-2xl font-bold leading-9 text-center tracking-tight text-white">Examen 2 de DAM</h2>
                <h2 className="text-2xl font-bold leading-9 text-center tracking-tight text-white">4 de diciembre de 2023</h2>
                <a className="flex justify-center m-5 border border-blue-500 rounded py-1 px-3 bg-blue-500 text-white" href="/registro">Comenzar</a>
            </div>
        </div>


    )
}

export default HomePage