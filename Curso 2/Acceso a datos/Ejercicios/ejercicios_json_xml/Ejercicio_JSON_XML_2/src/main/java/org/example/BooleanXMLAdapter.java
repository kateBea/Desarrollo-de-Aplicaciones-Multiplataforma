package org.example;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class BooleanXMLAdapter extends XmlAdapter<String, Boolean> {

	@Override
	public Boolean unmarshal(String v) throws Exception {
		// TODO Auto-generated method stub
		return v.equalsIgnoreCase("on");
	}

	@Override
	public String marshal(Boolean v) throws Exception {
		// TODO Auto-generated method stub
		return v?"on":"off";
	}

}
