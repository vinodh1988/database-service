package com.microservice.app.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.app.entity.KeyStore;

public interface KeyStoreDAO extends JpaRepository<KeyStore, Long> {

}
