/////////////////////////////////////////////////////////////////
///Ciclo: Desarrollo de Aplicaciones Multiplataforma.
///Módulo: Desarrollo de Interfaces.
///Profesores: Raquel Rojo y Mario Santos.
///En este script se declara el nombre de la carpeta en la que tenemos
///las bbdd, en la variable dbPath. Se realizan consultas, se generan BBDD,
///se insertan registros, etc.
////////////////////////////////////////////////////////////////

using SQLite4Unity3d;
using UnityEngine;
#if !UNITY_EDITOR
using System.Collections;
using System.IO;
#endif
using System.Collections.Generic;

public class DataService  {

	private SQLiteConnection _connection;

	public DataService(string DatabaseName){

//Importante la varialbe dbPath. Fijaros que le damos la ruta a la carpeta en la que
//guardamos la bbdd, en este caso 'StreamingAssets'. Si se cambia este nombre, recordar cambiar el nombre
//en el proyecto.

#if UNITY_EDITOR
		var dbPath = string.Format(@"Assets/StreamingAssets/{0}", DatabaseName);
		
#else
        // check if file exists in Application.persistentDataPath
        var filepath = string.Format("{0}/{1}", Application.persistentDataPath, DatabaseName);

        if (!File.Exists(filepath))
        {
            Debug.Log("Database not in Persistent path");
            // if it doesn't ->
            // open StreamingAssets directory and load the db ->

#if UNITY_ANDROID 
            var loadDb = new WWW("jar:file://" + Application.dataPath + "!/assets/" + DatabaseName);  // this is the path to your StreamingAssets in android
            while (!loadDb.isDone) { }  // CAREFUL here, for safety reasons you shouldn't let this while loop unattended, place a timer and error check
            // then save to Application.persistentDataPath
            File.WriteAllBytes(filepath, loadDb.bytes);
#elif UNITY_IOS
                 var loadDb = Application.dataPath + "/Raw/" + DatabaseName;  // this is the path to your StreamingAssets in iOS
                // then save to Application.persistentDataPath
                File.Copy(loadDb, filepath);
#elif UNITY_WP8
                var loadDb = Application.dataPath + "/StreamingAssets/" + DatabaseName;  // this is the path to your StreamingAssets in iOS
                // then save to Application.persistentDataPath
                File.Copy(loadDb, filepath);

#elif UNITY_WINRT
		var loadDb = Application.dataPath + "/StreamingAssets/" + DatabaseName;  // this is the path to your StreamingAssets in iOS
		// then save to Application.persistentDataPath
		File.Copy(loadDb, filepath);
		
#elif UNITY_STANDALONE_OSX
		var loadDb = Application.dataPath + "/Resources/Data/StreamingAssets/" + DatabaseName;  // this is the path to your StreamingAssets in iOS
		// then save to Application.persistentDataPath
		File.Copy(loadDb, filepath);
#else
	var loadDb = Application.dataPath + "/StreamingAssets/" + DatabaseName;  // this is the path to your StreamingAssets in iOS
	// then save to Application.persistentDataPath
	File.Copy(loadDb, filepath);

#endif

            Debug.Log("Database written");
        }

        var dbPath = filepath;
#endif
		//En esta línea, hacemos la conexión con la bbdd que hemos cargado en nuestro proyecto.
		//La abrimos en modo ReadWrite.

            _connection = new SQLiteConnection(dbPath, SQLiteOpenFlags.ReadWrite | SQLiteOpenFlags.Create);
        

	}

    public void InsertarRegistro(string nom, string contr)
    {
        _connection.CreateCommand("Insert into Usuarios(Nombre, Password) values ('" + nom + "', '" + contr + "');").ExecuteQuery<Usuarios>();
    }

    public IEnumerable<Usuarios> BuscarRegistro(string nom)
    {
        return _connection.CreateCommand("Select * from Usuarios where Nombre='" + nom + "';").ExecuteQuery<Usuarios>();
    }

    public void eliminar(string nom)
    {
        _connection.CreateCommand("delete from Usuarios where Nombre='" + nom + "';").ExecuteQuery<Usuarios>();
    }

	
}
