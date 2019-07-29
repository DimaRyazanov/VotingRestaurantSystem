package ru.votingsystem.graduation.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "menus", uniqueConstraints = {@UniqueConstraint(columnNames = {"restaurant_id", "date"}, name = "menus_unique_restaurant_date_idx")})
public class Menu extends AbstractBaseEntity {

    @Column(name = "date", nullable = false)
    @NotNull
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Restaurant restaurant;

    @OneToMany(mappedBy = "menu")
    private List<Meal> meals;

    @OneToMany(mappedBy = "menu")
    @OrderBy("rate DESC")
    private List<Vote> votes;

    public Menu() {
    }

    public Menu(Menu m) {
        this(m.id, m.date, m.restaurant, m.meals, m.votes);
    }

    public Menu(@NotNull LocalDate date, @NotNull Restaurant restaurant, List<Meal> meals, List<Vote> votes) {
        this(null, date, restaurant, meals, votes);
    }

    public Menu(Integer id, @NotNull LocalDate date, @NotNull Restaurant restaurant, List<Meal> meals, List<Vote> votes) {
        super(id);
        this.date = date;
        this.restaurant = restaurant;
        setMeals(meals);
        setVotes(votes);
    }

    public void setMeals(Collection<Meal> meals) {
        this.meals = CollectionUtils.isEmpty(meals) ? Collections.EMPTY_LIST : List.copyOf(meals);
    }

    public void setVotes(Collection<Vote> votes) {
        this.votes = CollectionUtils.isEmpty(votes) ? Collections.EMPTY_LIST :  List.copyOf(votes);
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public LocalDate getDate() {
        return date;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "date=" + date +
                ", restaurant=" + restaurant +
                ", meals=" + meals +
                ", votes=" + votes +
                ", id=" + id +
                '}';
    }
}
