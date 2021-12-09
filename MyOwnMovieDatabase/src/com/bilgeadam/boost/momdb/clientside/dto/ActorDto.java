package com.bilgeadam.boost.momdb.clientside.dto;

import java.io.Serializable;
import java.util.List;

public class ActorDto implements Serializable {
	private static final long serialVersionUID = -5096601538522711030L;
	
	private String name;
	private String birthYear;
	private String deathYear;
	private String primaryProfession;
	private String knownForTitles;
	private List<MovieDto> actorMovieList;
	
	public ActorDto() {
		// TODO Auto-generated constructor stub
	}
	
	public ActorDto(String name, String birthYear, String deathYear, String primaryProfession, String knownForTitles) {
		super();
		this.name = name;
		this.birthYear = birthYear;
		this.deathYear = deathYear;
		this.primaryProfession = primaryProfession;
		this.knownForTitles = knownForTitles;
	}
	
	public void logActorInformation() {
		System.out
				.println("\tName= " + this.name + " Birth Year= " + this.birthYear + " Death Year= " + this.deathYear);
		for (MovieDto movieDto : actorMovieList) {
			System.out.println("\t" + movieDto.getStartYear() + "/ " + movieDto.getPrimaryTitle() + " ("
					+ movieDto.getGenres() + ") ");
			
		}
	}
	
	@Override
	public String toString() {
		return "ActorDto name=" + name + ", BirthYear=" + birthYear + ", DeathYear=" + deathYear
				+ ", PrimaryProfession=" + primaryProfession + ", actorMovieList=" + actorMovieList;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBirthYear() {
		return birthYear;
	}
	
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}
	
	public String getDeathYear() {
		return deathYear;
	}
	
	public void setDeathYear(String deathYear) {
		this.deathYear = deathYear;
	}
	
	public String getPrimaryProfession() {
		return primaryProfession;
	}
	
	public void setPrimaryProfession(String primaryProfession) {
		this.primaryProfession = primaryProfession;
	}
	
	public String getKnownForTitles() {
		return knownForTitles;
	}
	
	public void setKnownForTitles(String knownForTitles) {
		this.knownForTitles = knownForTitles;
	}
	
	public List<MovieDto> getListArtistMovies() {
		return actorMovieList;
	}
	
	public void setListArtistMovies(List<MovieDto> listArtistMovies) {
		this.actorMovieList = listArtistMovies;
	}
	
}
