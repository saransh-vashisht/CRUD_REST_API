package com.project.springboot_restful_webservices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//An Entity annotation specifies that this class is an JPA Entity
//Table annotation is used to configure the Table details
// we can also give the unique schema and the unique constraints
// Id annotation is used to configure the Id annotation
//GeneratedValue will define how will our primary key will be generated eventually 
// And there are four types of the GenerationType --> They are Auto, Identity,Table and Sequence.
//If we want to customize the column we can use the @column annotations 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// here we have set the not null = false
	// we can also set the column name independently . but since we have the two words then the JPA will automatically make it the first_name. 
	@Column(name = "first_name", nullable=false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false,unique = true)
	private String email;
}
