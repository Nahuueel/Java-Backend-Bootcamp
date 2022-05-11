package inyecciondep.example.inyecciondep.Models;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "Cosas")
public class CosaMongoModel extends CosaModel {

    public CosaMongoModel(int _id, String _type, String _description) {
        this.id = _id;
        this.type = _type;
        this.description = _description;
    } 
}
