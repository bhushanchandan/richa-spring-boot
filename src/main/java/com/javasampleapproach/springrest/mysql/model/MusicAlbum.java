package com.javasampleapproach.springrest.mysql.model;



import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.context.annotation.Role;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;

@Entity
@Table(name = "musicAlbum")
public class MusicAlbum {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "musicalbum_ID", updatable=false, nullable=false)
	private long id;
	@Column(name = "almumName")
	private String almumName;
	
	@Column(name = "price")
	private String price;
	@Column(name = "dateOfRelease")
	private String dateOfRelease;
	

	@Column(name = "genre")
	private String genre;
	@Column(name = "description")
	private String description;
	
	@OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "musician_ID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<Musicians> musicians;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAlmumName() {
		return almumName;
	}
	public void setAlmumName(String almumName) {
		this.almumName = almumName;
	}
	public String getDateOfRelease() {
		return dateOfRelease;
	}
	public void setDateOfRelease(String dateOfRelease) {
		this.dateOfRelease = dateOfRelease;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	
}
	public List<Musicians> getMusicians() {
		return musicians;
	}
	public void setMusicians(List<Musicians> musicians) {
		this.musicians = musicians;
	}
	@Override
	public String toString() {
		return "MusicAlbum [id=" + id + ", almumName=" + almumName + ", price=" + price + ", dateOfRelease="
				+ dateOfRelease + ", genre=" + genre + ", description=" + description + ", musicians=" + musicians
				+ "]";
	}
	
	
	
	
	
}