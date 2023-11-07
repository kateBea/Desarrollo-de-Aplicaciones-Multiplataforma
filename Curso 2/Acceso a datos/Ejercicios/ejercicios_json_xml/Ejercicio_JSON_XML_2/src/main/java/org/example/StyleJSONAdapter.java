package org.example;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class StyleJSONAdapter extends TypeAdapter<Style> {

	@Override
	public void write(JsonWriter out, Style value) throws IOException {
		// TODO Auto-generated method stub
		out.value(value.toString());
	}

	@Override
	public Style read(JsonReader in) throws IOException {
		// TODO Auto-generated method stub
		return Style.crearStyle(in.nextString());
	}

}
