package ru.votingsystem.graduation.repository.restaurant;

import ru.votingsystem.graduation.model.City;
import ru.votingsystem.graduation.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    Restaurant save(Restaurant restaurant);
    boolean delete(int id);
    Restaurant get(int id);
    List<Restaurant> getAll();
    List<Restaurant> getAllByCity(City city);
    List<Restaurant> getAllByContainsName(String name);
}
