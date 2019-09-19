package ru.votingsystem.graduation.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.votingsystem.graduation.model.Restaurant;
import ru.votingsystem.graduation.repository.RestaurantRepository;
import ru.votingsystem.graduation.service.interfaces.RestaurantService;
import ru.votingsystem.graduation.util.ValidationUtil;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository repository;

    public RestaurantServiceImpl(RestaurantRepository repository) {
        this.repository = repository;
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
        Assert.notNull(restaurant, "New restaurant must be not null");
        ValidationUtil.checkNew(restaurant);
        return repository.save(restaurant);
    }

    @Override
    public Restaurant update(Restaurant restaurant) {
        Assert.notNull(restaurant, "New restaurant must be not null");
        ValidationUtil.checkNotNew(restaurant);
        return repository.save(restaurant);
    }
}
