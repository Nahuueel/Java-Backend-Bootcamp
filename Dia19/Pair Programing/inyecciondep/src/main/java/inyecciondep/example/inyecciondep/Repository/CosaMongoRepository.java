package inyecciondep.example.inyecciondep.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import inyecciondep.example.inyecciondep.Models.CosaMongoModel;

@Repository
public interface CosaMongoRepository extends MongoRepository<CosaMongoModel,String>{   
}
