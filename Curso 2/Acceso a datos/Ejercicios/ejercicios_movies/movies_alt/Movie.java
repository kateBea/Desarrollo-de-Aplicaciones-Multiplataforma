package movies;

import java.time.LocalDate;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.Data;

@Data
@XmlType(propOrder= {"title", "year","genres",
					"ratings","duration","releaseDate",
					"originalTitle","actors","posterurl"})

@XmlAccessorType(XmlAccessType.FIELD)
public class Movie {
	private String title;
	private String year;
	private Genres genres;
	@XmlList
	private List<Integer> ratings;
	private String duration;
	@XmlJavaTypeAdapter(LocalDateAdapterXML.class)
	private LocalDate releaseDate;
	private String originalTitle;
	@XmlElementWrapper
	@XmlElement (name="actor")
	private List<String> actors;
	private String posterurl;
}
