package com.javasampleapproach.springrest.mysql.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.javasampleapproach.springrest.mysql.model.Musicians;

public interface MusicianRepositry extends JpaRepository<Musicians, Long> {

}
