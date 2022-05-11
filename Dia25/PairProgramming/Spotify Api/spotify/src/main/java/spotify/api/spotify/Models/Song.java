package spotify.api.spotify.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="Songs"); 
public class Song {
@Id
@GeneratedValue(strategy = GenerationType.AUTO) 
int id;

String name;

Float duration;

String artist;
    
}
