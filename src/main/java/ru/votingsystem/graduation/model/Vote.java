package ru.votingsystem.graduation.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "votes")
public class Vote extends AbstractBaseEntity {

    @Column(name = "date_time", nullable = false)
    @NotNull
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private User user;

    public Vote() {
    }

    public Vote(Vote v) {
        this(v.id, v.dateTime, v.restaurant, v.user);
    }

    public Vote(@NotNull LocalDateTime dateTime, @NotNull Restaurant restaurant, @NotNull User user) {
        this(null, dateTime, restaurant, user);
    }

    public Vote(Integer id, @NotNull LocalDateTime dateTime, @NotNull Restaurant restaurant, @NotNull User user) {
        super(id);
        this.dateTime = dateTime;
        this.restaurant = restaurant;
        this.user = user;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public User getUser() {
        return user;
    }
}
