package ru.votingsystem.graduation.service.interfaces;

import ru.votingsystem.graduation.model.Restaurant;

public interface RestaurantService {
    Restaurant create(Restaurant restaurant);
    Restaurant update(Restaurant restaurant);
}
