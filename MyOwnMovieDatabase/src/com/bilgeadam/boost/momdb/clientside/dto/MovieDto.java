package com.bilgeadam.boost.momdb.clientside.dto;

import java.io.Serializable;
import java.util.Date;

public class MovieDto implements Serializable {
	private static final long serialVersionUID = -3735319310948289418L;
	
	private String primaryTitle;
	private String startYear;
	private String genres;
	private double maxRating;
	private double minRating;
	private Date maxTimeStamp;
	private Date minTimeStamp;
	
	public MovieDto() {
		
	}
	
	public MovieDto(String primaryTitle, String startYear, String genres) {
		super();
		this.primaryTitle = primaryTitle;
		this.startYear = startYear;
		this.genres = genres;
	}
	
	public MovieDto(String primaryTitle, String startYear, String genres, double maxRating, double minRating,
			Date maxTimeStamp, Date minTimeStamp) {
		super();
		this.primaryTitle = primaryTitle;
		this.startYear = startYear;
		this.genres = genres;
		this.maxRating = maxRating;
		this.minRating = minRating;
		this.maxTimeStamp = maxTimeStamp;
		this.minTimeStamp = minTimeStamp;
	}
	
	@Override
	public String toString() {
		return "MovieDto [primaryTitle=" + primaryTitle + ", startYear=" + startYear + ", genres=" + genres
				+ ", maxRating=" + maxRating + ", minRating=" + minRating + ", maxTimeStamp=" + maxTimeStamp
				+ ", minTimeStamp=" + minTimeStamp + "]";
	}
	
	public String getPrimaryTitle() {
		return primaryTitle;
	}
	
	public void setPrimaryTitle(String primaryTitle) {
		this.primaryTitle = primaryTitle;
	}
	
	public String getStartYear() {
		return startYear;
	}
	
	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}
	
	public String getGenres() {
		return genres;
	}
	
	public void setGenres(String genres) {
		this.genres = genres;
	}
	
	public double getMaxRating() {
		return maxRating;
	}
	
	public void setMaxRating(double maxRating) {
		this.maxRating = maxRating;
	}
	
	public double getMinRating() {
		return minRating;
	}
	
	public void setMinRating(double minRating) {
		this.minRating = minRating;
	}
	
	public Date getMaxTimeStamp() {
		return maxTimeStamp;
	}
	
	public void setMaxTimeStamp(Date maxTimeStamp) {
		this.maxTimeStamp = maxTimeStamp;
	}
	
	public Date getMinTimeStamp() {
		return minTimeStamp;
	}
	
	public void setMinTimeStamp(Date minTimeStamp) {
		this.minTimeStamp = minTimeStamp;
	}
	
}
