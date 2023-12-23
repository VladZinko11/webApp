package model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "images", schema = "new_schema1")
public class Image {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "file", nullable = false)
    private Byte file;

    @Column(name = "description", nullable = true)
    private String description;
}
