package ru.votingsystem.graduation.model;

import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "restaurants", uniqueConstraints = {@UniqueConstraint(columnNames = "name", name = "restaurants_unique_name_idx")})
public class Restaurant extends AbstractNamedEntity {

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "restaurant_city", joinColumns = @JoinColumn(name = "restaurant_id"))
    @Column(name = "city", nullable = false)
    @ElementCollection(fetch = FetchType.EAGER)
    private City city;

    @OneToMany(mappedBy = "restaurant")
    @OrderBy("date DESC")
    private List<Menu> menus;

    public Restaurant() {
    }

    public Restaurant(Restaurant r) {
        this(r.id, r.name, r.city, r.menus);
    }

    public Restaurant(String name, City city, List<Menu> menus) {
        this(null, name, city, menus);
    }

    public Restaurant(Integer id, String name, City city, List<Menu> menus) {
        super(id, name);
        this.city = city;
        setMenus(menus);
    }

    public void setMenus(Collection<Menu> menus) {
        this.menus = CollectionUtils.isEmpty(menus) ? Collections.EMPTY_LIST : List.copyOf(menus);
    }
}
