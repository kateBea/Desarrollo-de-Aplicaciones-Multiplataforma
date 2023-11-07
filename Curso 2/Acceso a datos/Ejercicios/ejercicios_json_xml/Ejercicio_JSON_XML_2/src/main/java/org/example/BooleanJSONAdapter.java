package org.example;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class BooleanJSONAdapter extends TypeAdapter<Boolean> {

	@Override
	public void write(JsonWriter out, Boolean value) throws IOException {
		// TODO Auto-generated method stub
		out.value(value?"on":"off");
	}

	@Override
	public Boolean read(JsonReader in) throws IOException {
		// TODO Auto-generated method stub
		String valor = in.nextString();
		
		return valor.equals("on");
	}

}
