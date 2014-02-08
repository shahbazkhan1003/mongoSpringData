package com.shahbaz.springdata.mongo;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, ObjectId>{
	
	public User findByUsername(String username);

}
