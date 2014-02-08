package com.shahbaz.springdata.mongo;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 * Hello world!
 * 
 */
public class App {

	public static void main(String[] args) {
		System.out.println("Starting Application ...");
		ApplicationContext apx = new GenericXmlApplicationContext(
				"application-context.xml");

		MongoOperations mongoOperation = (MongoOperations) apx
				.getBean("mongoTemplate");

		/**
		 * inserting record
		 */
		// insertingRecord(mongoOperation);

		/**
		 * using repository
		 */
		// userRepositoryOperations(apx);
		
		/**
		 * user blog operation
		 * basically adding an extra field to already existing documet
		 */

		userBlogsOpertaion(mongoOperation);
		
		

		

	}

	public static void insertingRecord(MongoOperations opr) {

		User user = new User();
		user.setUsername("zooby");
		user.setPassword("secret");
		opr.insert(user);
	}

	/**
	 * 
	 * @param apx
	 */
	public static void userRepositoryOperations(ApplicationContext apx) {
		UserRepository userRepo = apx.getBean("userRepository",
				UserRepository.class);

		User userAgain = userRepo.findByUsername("shahbaz");
		System.out.println(userAgain.getUsername());
	}

	/**
	 * 
	 */
	public static void userBlogsOpertaion(MongoOperations opr) {

		UserBlogs userBlogs = new UserBlogs();
		userBlogs.setAddress("tumblr");
		userBlogs.setDatePublished(new Date());
		userBlogs.setTitle("Mongo DB incremented");
		

		Query query = new Query();
		query.addCriteria(Criteria.where("username").is("zooby"));
 
		/*
		 * Adding a totally new set of data in an existing document  
		 */
		//opr.upsert(query, new Update().push("userBlogs", userBlogs) , User.class);
		
		
		/*
		 * Adding by incrementing a counter
		 * 
		 */
		opr.upsert(query, new Update().push("userBlogs", userBlogs).inc("bolg_count", 1) , User.class);
		
		

	}


}
