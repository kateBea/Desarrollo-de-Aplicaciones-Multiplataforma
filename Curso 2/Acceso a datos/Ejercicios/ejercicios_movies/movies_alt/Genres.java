package movies;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlValue;

import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Genres {
	@XmlList
	@XmlValue
	private List<String> valores;

}
