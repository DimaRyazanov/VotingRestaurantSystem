package ru.votingsystem.graduation.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "menus", uniqueConstraints = {@UniqueConstraint(columnNames = {"restaurant_id", "date"}, name = "menus_unique_restaurant_date_idx")})
public class Menu extends AbstractBaseEntity {

    @Column(name = "date", nullable = false, columnDefinition = "timestamp default now()")
    @NotNull
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Restaurant restaurant;

    @OneToMany(mappedBy = "menu")
    private List<Meal> meals;

    public Menu() {
    }

    public Menu(Menu m) {
        this(m.id, m.date, m.restaurant);
    }

    public Menu(@NotNull LocalDate date, @NotNull Restaurant restaurant) {
        this(null, date, restaurant);
    }

    public Menu(Integer id, @NotNull LocalDate date, @NotNull Restaurant restaurant) {
        super(id);
        this.date = date;
        this.restaurant = restaurant;
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

    @Override
    public String toString() {
        return "Menu{" +
                "date=" + date +
                ", restaurant=" + restaurant +
                ", meals=" + meals +
                ", id=" + id +
                '}';
    }
}
