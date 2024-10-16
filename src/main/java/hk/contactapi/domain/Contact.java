package hk.contactapi.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Entity
// these are lombok annotations
// lombok is a library that helps reduce the boilerplate code by
// automatically generating common methods like getter,setters,constructors
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// it is part of the Jackson library which is used for serializing and deserializing
// java object to and from JSON
// this only includes properties that do not have their default values when serializing and deserializing the object to JSON
@JsonInclude(NON_DEFAULT)
@Table(name = "contacts")
public class Contact {
    @Id
    @UuidGenerator
    @Column(name = "id",unique = true,updatable = false)
    // serves as a primary key
    private String id;
    private String name;
    private String email;
    private String title;
    private String phone;
    private String address;
    private String status;
    private String photoUrl;
}
