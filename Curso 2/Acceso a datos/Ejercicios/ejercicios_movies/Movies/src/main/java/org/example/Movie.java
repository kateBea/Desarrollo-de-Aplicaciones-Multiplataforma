package org.example;

import lombok.*;

import javax.xml.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

// Lombok
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Movie {
    @XmlElement
    private String title;

    @XmlElement
    private int year;

    @XmlElementWrapper
    @XmlElement
    private List<String> genres;

    @XmlList
    private List<Integer> ratings;

    @XmlElement
    private String duration;

    @XmlElement
    private LocalDate releaseDate;

    @XmlElement
    private String originalTitle;

    @XmlElement
    private String storyline;

    @XmlElementWrapper
    @XmlElement
    private List<String> actors;

    @XmlElement
    private String posterurl;
}
