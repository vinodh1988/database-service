package com.microservice.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.app.entity.Person;

public interface PersonDAO extends JpaRepository<Person,Long>{

}
