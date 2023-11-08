package movies;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement (name="movies")
public class MovieWrapper {
	@XmlElement(name = "movie")
	List<Movie> movies;
}
