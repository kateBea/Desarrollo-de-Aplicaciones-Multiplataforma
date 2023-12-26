import { Link } from 'react-router-dom';
import logo from '../assets/react.svg'




function HomePage() {
  return (
    <div className="flex h-[calc(100vh-100px)] items-center justify-center">

      <div className='flex flex-col bg-zinc-800 max-w-md w-full px-20 rounded-md items-center justify-center'>
        
          <img className='h-12 w-12' src={ logo } />
      
          <br></br>
          <h1 className='text-2xl font-bold text-white'>Nombre Alumno</h1>
          <h1 className='text-2xl font-bold text-white'>Examen 2 de DAM</h1>
          <h1 className='text-2xl font-bold text-white'>4 de diciembre de 2023</h1>
          <br></br>
          <br></br>
          <div className='w-40 bg-cyan-700 text-xl font-bold text-white flex items-center justify-center rounded-md'>
            <Link to="/registro" className='text-white'>Comenzar</Link>
          </div>       
          <br></br> 
        
      </div>



    </div>
  )
}

export default HomePage