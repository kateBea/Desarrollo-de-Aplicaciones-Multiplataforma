import { useForm } from 'react-hook-form';
import { useAuth } from '../context/AuthContext';
import { useEffect } from 'react';
import { useNavigate, Link } from 'react-router-dom';

function RegisterPage() {
    const { register, handleSubmit, formState: {
        errors
    } } = useForm();
    const { signup, isAuthenticated, errors: registerErrors } = useAuth();
    const navigate = useNavigate();

    useEffect(() => {
        if (isAuthenticated) navigate("/tasks");
    }, [isAuthenticated]);


    const onSubmit = handleSubmit(async (values) => {
        signup(values);
    })

    return (
        <div className="flex h-[calc(100vh-100px)] items-center justify-center">
            <div className="bg-zinc-800 max-w-md p-10 rounded-md">
                {
                    registerErrors.map((error, i) => (
                        <div className='bg-red-500 p-2 text-white' key={i}>
                            {error}
                        </div>
                    ))
                }
                <form onSubmit={onSubmit}>
                    <input type="text" {...register('username', { required: true })}
                        className='w-full bg-zinc-700 text-white px-4 py-2 rounded-md my-2'
                        placeholder='User Name'
                    />
                    {
                        errors.username && (
                            <p className='text-red-500'>
                                El usuario es requerido
                            </p>
                        )
                    }
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
                        Registrar
                    </button>
                </form>
                <br></br>
                <p className="flex gap-x-2 justify-between">
                    Tienes cuenta? <Link to="/login" className='text-sky-500'>Logearse</Link>
                </p>

            </div>

        </div>
    )
}

export default RegisterPage