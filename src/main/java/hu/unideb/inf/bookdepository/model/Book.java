package hu.unideb.inf.bookdepository.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String author;
    private String name;
    private String category;
    private String publisher;
    @Column(nullable = false)
    private int price;
    private String releaseDate;
    @Column(nullable = false, updatable = false)
    private String bookCode;

}
