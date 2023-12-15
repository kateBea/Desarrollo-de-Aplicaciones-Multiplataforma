/////////////////////////////////////////////////////////////////
///Ciclo: Desarrollo de Aplicaciones Multiplataforma.
///Módulo: Desarrollo de Interfaces.
///Profesores: Raquel Rojo y Mario Santos.
///En este script hacemos las llamadas a los métodos del script DataService.cs.
///Fijaros en que creamos una variable de tipo DataService 'ds', que es con la
///que realizamos la conexión a la bbdd.
///El script, lo tenéis que personalizar para vuestro proyecto.
////////////////////////////////////////////////////////////////

using UnityEngine;
using System.Collections.Generic;
using UnityEngine.UI;

public class ExistingDBScript : MonoBehaviour {

	//variable global para conectarnos contra la base de datos 'Autenticacion'.
	//Este valor lo tendréis que personalizar para vuestro proyecto.
	private DataService ds = new DataService("CursoDAM.db");

	private GameObject inpname;
    private InputField inppassword;

    private void Start()
    {
        inpname = GameObject.Find("InpNombre");
        inppassword = GameObject.Find("InpContrasenna").GetComponent<InputField>();
    }

    public void Registrar()
    {
        ds.InsertarRegistro(inpname.GetComponent<InputField>().text, inppassword.text);
    }

    public void Buscar()
    {
        var datos = ds.BuscarRegistro(inpname.GetComponent<InputField>().text);

        foreach(var linea in datos)
        {
            inppassword.text = linea.Password;
        }
    }

    public void EliminarRegistro()
    {
        ds.eliminar(inpname.GetComponent<InputField>().text);
    }





}
