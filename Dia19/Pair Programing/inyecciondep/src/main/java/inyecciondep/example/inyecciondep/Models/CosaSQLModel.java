package inyecciondep.example.inyecciondep.Models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "cosas")
public class CosaSQLModel extends CosaModel {   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    private String type, description;

    public CosaSQLModel(int _id, String _type, String _description) {
        this.id = _id;
        this.type = _type;
        this.description = _description;
    }
}
