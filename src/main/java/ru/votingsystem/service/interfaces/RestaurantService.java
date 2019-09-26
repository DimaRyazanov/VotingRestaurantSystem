package ru.votingsystem.service.interfaces;

import ru.votingsystem.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    Restaurant create(Restaurant restaurant);
    Restaurant update(Restaurant restaurant);
    List<Restaurant> getAll();
}
