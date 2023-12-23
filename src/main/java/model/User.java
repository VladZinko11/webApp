package model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users", schema = "new_schema1")
public class User {

    @GeneratedValue
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;


}
