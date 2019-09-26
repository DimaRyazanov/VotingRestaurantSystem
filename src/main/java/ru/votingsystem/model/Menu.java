package ru.votingsystem.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "menus", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"restaurant_id", "date_menu"}, name = "menus_unique_date_menu_restaurant_idx")})
public class Menu extends AbstractBaseEntity {
    @Column(name = "date_menu", nullable = false)
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateMenu;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Restaurant restaurant;

    @CollectionTable(name = "menu_dishes", joinColumns = @JoinColumn(name = "menu_id"))
    @Column(name = "dish")
    @ElementCollection
    private List<String> dishes;

    public Menu() {
    }

    public Menu(@NotNull LocalDate dateMenu, @NotNull Restaurant restaurant) {
        this.dateMenu = dateMenu;
        this.restaurant = restaurant;
    }

    public Menu(@NotNull LocalDate dateMenu, @NotNull Restaurant restaurant, List<String> dishes) {
        this.dateMenu = dateMenu;
        this.restaurant = restaurant;
        this.dishes = dishes;
    }

    public Menu(Integer id, @NotNull LocalDate dateMenu, @NotNull Restaurant restaurant, List<String> dishes) {
        super(id);
        this.dateMenu = dateMenu;
        this.restaurant = restaurant;
        this.dishes = dishes;
    }

    public LocalDate getDateMenu() {
        return dateMenu;
    }

    public void setDateMenu(LocalDate dateMenu) {
        this.dateMenu = dateMenu;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<String> getDishes() {
        return dishes;
    }

    public void setDishes(List<String> dishes) {
        this.dishes = dishes;
    }
}
