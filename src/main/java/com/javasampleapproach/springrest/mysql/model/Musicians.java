package com.javasampleapproach.springrest.mysql.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "musicians")
public class Musicians {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "musician_ID", updatable=false, nullable=false)
		private long id;
		@Column(name = "name")
		public String name;
		@Column(name = "musician_type")
		public String musician_type;
		
		
		
		@ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "musicalbum_ID", nullable = false)
	    @OnDelete(action = OnDeleteAction.CASCADE)
	    @JsonIgnore
	    private MusicAlbum musicAlbum;
		
		
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getMusician_type() {
			return musician_type;
		}
		public void setMusician_type(String musician_type) {
			this.musician_type = musician_type;
		}
		
		
		
		
		
		public MusicAlbum getMusicAlbum() {
			return musicAlbum;
		}
		public void setMusicAlbum(MusicAlbum musicAlbum) {
			this.musicAlbum = musicAlbum;
		}
		@Override
		public String toString() {
			return "Musicians [id=" + id + ", name=" + name + ", musician_type=" + musician_type + ", musicAlbum="
					+ musicAlbum + "]";
		}
		
		
		
		
		
		
		
		

}
