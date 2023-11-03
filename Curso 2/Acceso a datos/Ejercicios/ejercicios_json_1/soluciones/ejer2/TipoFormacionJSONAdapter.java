package org.dam2.ejer2;

import java.io.IOException;


import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class TipoFormacionJSONAdapter extends TypeAdapter<TipoFormacion> {

	@Override
	public void write(JsonWriter out, TipoFormacion value) throws IOException {
		// TODO Auto-generated method stub
		out.value(value.toString());
	}

	@Override
	public TipoFormacion read(JsonReader in) throws IOException {
		// TODO Auto-generated method stub
		return TipoFormacion.crearTipoFormacion(in.nextString());
	}

}
