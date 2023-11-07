package org.example;

import java.util.Arrays;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class StyleXmlAdapter extends XmlAdapter<String, Style> {

	@Override
	public Style unmarshal(String v) throws Exception {
		// TODO Auto-generated method stub
		return Style.crearStyle(v);
	}

	@Override
	public String marshal(Style v) throws Exception {
		// TODO Auto-generated method stub
		return v.toString();
	}

}
