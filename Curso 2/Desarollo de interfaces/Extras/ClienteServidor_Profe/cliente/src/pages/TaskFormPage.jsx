import { useForm } from 'react-hook-form';
import { createTaskRequest, getTasksRequest } from '../api/tasks.js';

function TaskFormPage() {

  const { register, handleSubmit } = useForm()
  

  const visualizarTareas = async () => {
    const res = await getTasksRequest();
    
    res.data.forEach(dato => console.log(dato._id))
    

  }



  const onSubmit = handleSubmit((data) => {
    try {
      console.log("Respuesta del servidor")
      const res = createTaskRequest(data);
      console.log(res);
      console.log("Tareas");
      visualizarTareas()
    } catch (err) {
      console.log(err.data)
    }
  });



  return (
    <div className='bg-zinc-800 max-w-md w-full p-10 rounded-md'>
      <form onSubmit={onSubmit}>

        <input
          type="text"
          placeholder="Title"
          {...register("title")}
          className='w-full bg-zinc-700 text-white px-4 py-2 rounded-md my-2'
          autoFocus
        />
        <textarea
          rows="3"
          placeholder="Descripcion"
          {...register("description")}
          className='w-full bg-zinc-700 text-white px-4 py-2 rounded-md my-2'>

        </textarea>
        <button>
          Guardar
        </button>

      </form>





    </div>
  )
}

export default TaskFormPage