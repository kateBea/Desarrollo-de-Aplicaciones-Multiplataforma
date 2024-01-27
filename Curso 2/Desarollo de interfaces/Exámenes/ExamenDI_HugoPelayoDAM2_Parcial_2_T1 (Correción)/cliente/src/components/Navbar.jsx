import React from 'react'
import { Link } from 'react-router-dom'

function Navbar() {
  return (
    <nav className="bg-zinc-700 my-3 flex justify-between py-5 px-10 rounded-lg">
        <h1 className='text-2xl font-bold'>Examen 2DAM - Trabajando con Productos</h1>
        <ul className='flex gap-x-2'>
            <li>
                <Link to='/' className='bg-indigo-500 px-4 py-1 rounded-sm'>Inicio</Link>
            </li>
            <li>
                <Link to='/registro' className='bg-indigo-500 px-4 py-1 rounded-sm'>Registro</Link>
            </li>
            <li>
                <Link to='/productos' className='bg-indigo-500 px-4 py-1 rounded-sm'>Consulta</Link>
            </li>
        </ul>
    </nav>
  )
}

export default Navbar