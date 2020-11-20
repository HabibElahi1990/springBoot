package model;

import lombok.*;

import javax.persistence.*;
import java.beans.ConstructorProperties;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Habib, on 05/11/2020
 */
@Entity
@Table
@Data
@NoArgsConstructor
@RequiredArgsConstructor(onConstructor_=
@ConstructorProperties({"title","certificate"}))
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private String certificate;

    @ManyToOne(cascade = CascadeType.ALL)
    private Author author;



}
