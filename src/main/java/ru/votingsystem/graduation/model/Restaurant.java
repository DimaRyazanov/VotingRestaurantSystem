package ru.votingsystem.graduation.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurants", uniqueConstraints = {@UniqueConstraint(columnNames = "name", name = "restaurants_unique_name_idx")})
public class Restaurant extends AbstractNamedEntity {

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "restaurant_city", joinColumns = @JoinColumn(name = "restaurant_id"))
    @Column(name = "city", nullable = false)
    private City city;

    @OneToMany(mappedBy = "restaurant")
    @OrderBy("date DESC")
    private List<Menu> menus;

    @OneToMany(mappedBy = "menu")
    @OrderBy("rate DESC")
    private List<Vote> votes;

    public Restaurant() {
    }

    public Restaurant(Restaurant r) {
        this(r.id, r.name, r.city);
    }

    public Restaurant(String name, City city) {
        this(null, name, city);
    }

    public Restaurant(Integer id, String name, City city) {
        super(id, name);
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "city=" + city +
                ", menus=" + menus +
                ", votes=" + votes +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
