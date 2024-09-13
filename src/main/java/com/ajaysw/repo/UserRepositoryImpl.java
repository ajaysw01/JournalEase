package com.ajaysw.repo;

import com.ajaysw.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepositoryImpl {

    @Autowired
    private MongoTemplate mongoTemplate;

        public List<User> getUserForSA(){
            Query query = new Query();

//            Criteria criteria = new Criteria();
//            query.addCriteria(criteria.orOperator(
//                    Criteria.where("email").exists(true),
//                    Criteria.where("sentimentAnalysis").exists(true)
//            ));
            query.addCriteria(Criteria.where("email").exists(true));
            query.addCriteria(Criteria.where("email").ne(null).ne(""));
            query.addCriteria(Criteria.where("sentimentAnalysis").exists(true));
//            query.addCriteria(Criteria.where("roles").in("USER","ADMIN"));
//            query.addCriteria(Criteria.where("").type(JsonSchemaObject.Type.bsonTypes()));
            List<User> users = mongoTemplate.find(query, User.class);

            return users;
        }
}
