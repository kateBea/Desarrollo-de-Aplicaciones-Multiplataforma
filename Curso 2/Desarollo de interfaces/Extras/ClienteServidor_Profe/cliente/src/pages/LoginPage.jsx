import { useForm } from 'react-hook-form';
import { useAuth } from '../context/AuthContext';
import { useEffect } from 'react';
import { useNavigate, Link } from 'react-router-dom';

function LoginPage() {
  const { register, handleSubmit, formState: { errors } } = useForm();
  const { signin, isAuthenticated, errors: signinErrors } = useAuth();
  const navigate = useNavigate();

    useEffect(() => {
        if (isAuthenticated) navigate("/add-task");
    }, [isAuthenticated]);



  const onSubmit = handleSubmit((data) => {
    signin(data);
  });

  return (
    <div className="flex h-[calc(100vh-100px)] items-center justify-center">

      <div className='bg-zinc-800 max-w-md w-full p-10 rounded-md'>

        {
          signinErrors.map((error, i) => (
            <div className='bg-red-500 p-2 text-white text-center' key={i}>
              {error}
            </div>
          ))
        }


        <h1 className='text-2xl font-bold'>Login - Villablanca</h1>
        <br></br>

        <form onSubmit={onSubmit}>
          <input type="email" {...register('email', { required: true })}
            className='w-full bg-zinc-700 text-white px-4 py-2 rounded-md my-2'
            placeholder='E-mail'
          />
          {
            errors.email && (
              <p className='text-red-500'>
                El e-mail es requerido
              </p>
            )
          }
          <input type="password" {...register('password', { required: true })}
            className='w-full bg-zinc-700 text-white px-4 py-2 rounded-md my-2'
            placeholder='Password'
          />
          {
            errors.password && (
              <p className='text-red-500'>
                El usuario es requerido
              </p>
            )
          }
          <button type='submit' className="bg-slate-600 text-white rounded-md py-2 px-4 my-2">
            Acceder
          </button>
        </form>
        <br></br>
        <p className="flex gap-x-2 justify-between">
          Crear cuenta? <Link to="/register" className='text-sky-500'>Registrarse</Link>
        </p>


      </div>



    </div>
  )
}

export default LoginPage