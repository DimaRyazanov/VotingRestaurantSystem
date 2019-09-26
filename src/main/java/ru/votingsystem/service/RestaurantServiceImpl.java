package ru.votingsystem.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.votingsystem.model.Restaurant;
import ru.votingsystem.repository.RestaurantRepository;
import ru.votingsystem.service.interfaces.RestaurantService;
import ru.votingsystem.util.ValidationUtil;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository repository;
    private final Sort SORT_ID = Sort.by(Sort.Direction.ASC, "id");

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

    @Override
    public List<Restaurant> getAll() {
        return repository.findAll(SORT_ID);
    }
}
