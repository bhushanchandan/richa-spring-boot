package com.javasampleapproach.springrest.mysql.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.springrest.mysql.model.MusicAlbum;
import com.javasampleapproach.springrest.mysql.model.Musicians;
import com.javasampleapproach.springrest.mysql.repo.MusicalbumRepositry;
import com.javasampleapproach.springrest.mysql.repo.MusicianRepositry;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MusicAlbumController {

	@Autowired
	MusicalbumRepositry repository;
	
	@Autowired
	MusicianRepositry musicianRepositry;

	
	  @GetMapping("/musicalbum") public List<MusicAlbum> getAllMusicAlbum() {
	  System.out.println("Get all musicalbum...");
	  List<MusicAlbum> customers = new ArrayList<>();
	  repository.findAll().forEach(customers::add);
	  customers.sort(Comparator.comparing(MusicAlbum::getDateOfRelease).reversed().thenComparing(MusicAlbum:: getPrice));
	  
	  return customers; }
	
	  
	  @GetMapping("/misicians") public List<Musicians> getAllMusicians() {
		  System.out.println("Get all musicalbum...");
		  
		  List<Musicians> customers = new ArrayList<>();
		  musicianRepositry.findAll().forEach(customers::add);
		  customers.stream().sorted(Comparator.comparing(Musicians:: getName).
		  reversed());
		  
		  return customers; }
	 

	@PostMapping(value = "/musicalbum/createupdate")
	public ResponseEntity<String> postEmployee(@RequestBody MusicAlbum customer) {

		MusicAlbum _customer = repository.save(customer);
		return new ResponseEntity<>("Registration successful", HttpStatus.OK);
	}
	
	@PostMapping(value = "/musician/createupdate")
	public ResponseEntity<String> postEmployee(@RequestBody Musicians customer) {

		Musicians _customer = musicianRepositry.save(customer);
		return new ResponseEntity<>("Registration successful", HttpStatus.OK);
	}
	
	

}
