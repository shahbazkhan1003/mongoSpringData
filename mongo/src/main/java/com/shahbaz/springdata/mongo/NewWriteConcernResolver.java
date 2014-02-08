package com.shahbaz.springdata.mongo;

import org.springframework.data.mongodb.core.MongoAction;
import org.springframework.data.mongodb.core.WriteConcernResolver;

import com.mongodb.WriteConcern;

public class NewWriteConcernResolver implements WriteConcernResolver{

	public WriteConcern resolve(MongoAction action) {
		if(action.getCollectionName().equals("user")){
			return WriteConcern.JOURNAL_SAFE;
		}
		
		return WriteConcern.NORMAL;
	}

}
