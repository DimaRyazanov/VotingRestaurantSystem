package ru.votingsystem.graduation.to;

import ru.votingsystem.graduation.model.City;
import ru.votingsystem.graduation.model.Menu;

import java.util.List;

public class RestaurantTO {
    private final Integer id;

    private final String name;

    private final City city;

    private final List<Menu> menus;

    private final double rating;

    public RestaurantTO(Integer id, String name, City city, List<Menu> menus, double rating) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.menus = menus;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public City getCity() {
        return city;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "RestaurantTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city +
                ", menus=" + menus +
                ", rating=" + rating +
                '}';
    }
}
