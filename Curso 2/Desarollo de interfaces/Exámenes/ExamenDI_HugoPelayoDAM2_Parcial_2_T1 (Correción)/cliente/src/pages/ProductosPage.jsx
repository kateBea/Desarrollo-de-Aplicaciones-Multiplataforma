import { useEffect } from "react";
import { useAuth } from "../context/AuthContext"

function ProductosPage() {
  const { cogerProductos, productos } = useAuth();
  

  useEffect(()=>{
    cogerProductos();
  },[])

  return (
    <div className="grid grid-cols-3 gap-2">
    {
      productos.map((producto) =>(
        <div className="bg-zinc-800 max-w-md w-full p-10 rounded-md">
          <h1 className="text-2xl font-bold">{producto.pieza}</h1>
          <h1 className="text-2xl font-bold">{producto.precio}</h1>
          <p className="text-slate-300">{producto.descripcion}</p>
        </div>
      ))
    }
    </div>
  );
}

export default ProductosPage