package ru.votingsystem.graduation.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "meals")
public class Meal extends AbstractNamedEntity {

    @Column(name = "price", nullable = false)
    @Range(min = 0, max = 50000)
    private double price;

    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Menu menu;

    public Meal() {
    }

    public Meal(Meal m) {
        this(m.id, m.name, m.price, m.menu);
    }

    public Meal(String name, @Range(min = 0, max = 50000) double price, @NotNull Menu menu) {
        this(null, name, price, menu);
    }

    public Meal(Integer id, String name, @Range(min = 0, max = 50000) double price, @NotNull Menu menu) {
        super(id, name);
        this.price = price;
        this.menu = menu;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public double getPrice() {
        return price;
    }

    public Menu getMenu() {
        return menu;
    }
}
