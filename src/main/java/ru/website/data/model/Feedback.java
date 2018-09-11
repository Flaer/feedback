package ru.website.data.model;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by FAMILY on 11.09.2018.
 */
@Entity
@Table(name="feedbacks")
public class Feedback {


    @Id
    @Column(name="id", nullable=false, unique=true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feedbacks_seq")
    @SequenceGenerator(name = "feedbacks_seq", sequenceName = "feedbacks_seq", allocationSize = 1)
    private Long id;

    private String positive;
    private String negative;
    private String wishes;
    private LocalDateTime created;


    public Feedback() {
        this.created = LocalDateTime.now();
    }

    public Feedback(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getPositive() {
        return positive;
    }

    public void setPositive(String positive) {
        this.positive = positive;
    }

    public String getNegative() {
        return negative;
    }

    public void setNegative(String negative) {
        this.negative = negative;
    }

    public String getWishes() {
        return wishes;
    }

    public void setWishes(String wishes) {
        this.wishes = wishes;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
