package com.cbs.pojos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;//
	
	@Column(length = 30)
	private String title;//
	private int duration;//
	@Column(length = 30)
	private String director;//
	@Column(length = 30)
	private String category;//
	private LocalDate releaseDate;//
	@Column(length = 10)
	private String viewingExp;//
	@Column(length = 30)
	private String language;//
	@Column(length = 500)
	private String imageLink;//

	@ManyToMany(cascade = { CascadeType.ALL })
	@JsonIgnore
	@JoinTable(name = "theaters_movies", 
					joinColumns = @JoinColumn(name = "theater_id"),
					inverseJoinColumns = @JoinColumn(name = "movie_id"))
	private Set<Theater> theaters = new HashSet<>();

	@Override
	public String toString() {
		return "Movie id= " + id + ", title=" + title + ", duration=" + duration + ", director=" + director
				+ ", category=" + category + ", releaseDate=" + releaseDate + ", viewingExp=" + viewingExp
				+ ", language=" + language + "  imageLink=" + imageLink + "]";
	}

	public Movie(String title, int duration, String director, String category, LocalDate releaseDate, String viewingExp,
			String language, String imageLink) {
		super();
		this.title = title;
		this.duration = duration;
		this.director = director;
		this.category = category;
		this.releaseDate = releaseDate;
		this.viewingExp = viewingExp;
		this.language = language;
		this.imageLink = imageLink;
	}
		

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Movie(Integer id, String category, String director,
			int duration, String imageLink,
			String language,
			LocalDate releaseDate,String title,
			String viewingExp
			) {
		
		this.id = id;
		this.category = category;
		this.director = director;
		this.duration = duration;
		this.imageLink = imageLink;
		this.language = language;
		this.releaseDate = releaseDate;
		this.title = title;
		this.viewingExp = viewingExp;
	}

	
	
}
