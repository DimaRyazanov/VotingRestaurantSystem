package ru.votingsystem.graduation.service;

import org.springframework.stereotype.Service;
import ru.votingsystem.graduation.model.Restaurant;
import ru.votingsystem.graduation.repository.restaurant.RestaurantRepository;
import ru.votingsystem.graduation.util.ValidationUtil;

@Service
public class RestaurantService {
    private RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant get(int id) {
        Restaurant restaurant = ValidationUtil.checkNotFoundWithId(restaurantRepository.get(id), id);
        return restaurant;
    }
}
