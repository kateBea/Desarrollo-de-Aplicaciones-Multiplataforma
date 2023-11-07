package org.example;

import java.util.Arrays;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class AlignmentXMLAdapter extends XmlAdapter<String, Alignment> {

	@Override
	public Alignment unmarshal(String v) throws Exception {
		// TODO Auto-generated method stub
		return Alignment.crearAlignment(v);
	}

	@Override
	public String marshal(Alignment v) throws Exception {
		// TODO Auto-generated method stub
		return v.toString();
	}

}
