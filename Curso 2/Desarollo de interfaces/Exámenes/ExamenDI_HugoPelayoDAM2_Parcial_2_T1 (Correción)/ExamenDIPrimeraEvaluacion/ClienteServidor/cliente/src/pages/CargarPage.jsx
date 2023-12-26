import { useForm } from 'react-hook-form';
import { useAuth } from '../context/AuthContext';
import { useNavigate, Link } from 'react-router-dom';
import { useState } from 'react';

function CargarPage() {
  const { register, handleSubmit, formState: { errors } } = useForm();
  const { regProductos, user } = useAuth();
  const navigate = useNavigate();


  const onSubmit = handleSubmit((data) => {
    console.log(data);
    regProductos(data);
    console.log(user);
  });

  return (
    <div className="flex h-[calc(100vh-100px)] items-center justify-center">

      <div className='bg-zinc-800 max-w-md w-full p-10 rounded-md'>


        <h1 className='text-2xl font-bold'>Villablanca - Registro Piezas</h1>
        <br></br>

        <form onSubmit={onSubmit}>
          <input type="text" {...register('pieza', { required: true })}
            className='w-full bg-zinc-700 text-white px-4 py-2 rounded-md my-2'
            placeholder='Nombre de pieza'
            autoFocus
          />
          {
            errors.pieza && (
              <p className='text-red-500'>
                Debes introducir una pieza
              </p>
            )
          }
          <input type="text" {...register('precio', { required: true })}
            className='w-full bg-zinc-700 text-white px-4 py-2 rounded-md my-2'
            placeholder='Introduce el precio'
          />
          {
            errors.precio && (
              <p className='text-red-500'>
                Introduce el precio de la pieza
              </p>
            )
          }
          <textarea
            rows="3"
            placeholder="Descripción"
            {...register('descripcion', { required: true })}
            className='w-full bg-zinc-700 text-white px-4 py-2 rounded-md my-2'>
          </textarea>
          {
            errors.descripcion && (
              <p className='text-red-500'>
                Introduce una Descripción
              </p>
            )
          }

          <button type='submit' className="bg-slate-600 text-white rounded-md py-2 px-4 my-2">
            Grabar
          </button>
        </form>
        <br></br>
        <p className="flex gap-x-2 justify-between">
          <Link to="/productos" className='text-sky-500'>Consulta</Link>
          <Link to="/" className='text-sky-500'>Inicio</Link>
        </p>


      </div>



    </div>
  )
}

export default CargarPage