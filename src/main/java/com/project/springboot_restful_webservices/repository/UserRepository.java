package com.project.springboot_restful_webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.springboot_restful_webservices.entity.User;

//the repository is created to provide us with the basic functionalities of the CRUD operations and provide  us with the support of it .
//The userRepository extends the Jpa Repository which then extends the CRUDRepository which has all the CRUD methods that we can implement 
// in extending the JpaRepository we have to pass the two entities the one being the type of the Entity we have create and the next being the type of the primary key
public interface UserRepository extends JpaRepository<User, Long> {

}
