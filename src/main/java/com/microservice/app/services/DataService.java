package com.microservice.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.app.entity.KeyStore;
import com.microservice.app.entity.Person;
import com.microservice.app.repositories.KeyStoreDAO;
import com.microservice.app.repositories.PersonDAO;

@Service
public class DataService {
	@Autowired
	  PersonDAO people;
	
	@Autowired
	   KeyStoreDAO keystore;
	
    
    public List<Person> getPeople(){
  	 return people.findAll();
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void addPerson(Person person) {
  	  people.save(person);
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void addKey(int sno) {
    	 String keydata= String.valueOf(Math.round(Math.random()*10000)); // 9999
    	 KeyStore key=new KeyStore();
    	 key.setId(sno);
    	 key.setKey(keydata);
    	 keystore.save(key);
    }
}
