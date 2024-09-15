package com.library.api.domain.book;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Reference;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private String id;

    private String title;
    private String synopsis;
    private String[] genres;
    private int pages;
    private Date release;

    @OneToMany
    private String publisherId;

    @ManyToMany
    private List<String> authorsIds;
}
