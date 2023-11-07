package org.example;

import java.io.IOException;
import java.util.Arrays;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class AlignmentJSONAdapter extends TypeAdapter<Alignment> {

	@Override
	public void write(JsonWriter out, Alignment value) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("adaptando...");
		System.out.println(value.toString());
		out.value(value.toString());
	}

	@Override
	public Alignment read(JsonReader in) throws IOException {
		// TODO Auto-generated method stub
		String valor = in.nextString();
		return Alignment.crearAlignment(valor);
	}

}
