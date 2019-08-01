package ru.votingsystem.graduation.repository.restaurant;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.votingsystem.graduation.model.City;
import ru.votingsystem.graduation.model.Restaurant;

import java.util.List;

@Repository
public class DataJpaRestaurantRepository implements RestaurantRepository {

    private final CrudRestaurantRepository crudRestaurantRepository;
    private static final Sort SORT_NAME_CITY = new Sort(Sort.Direction.DESC, "name", "city");

    public DataJpaRestaurantRepository(CrudRestaurantRepository crudRestaurantRepository) {
        this.crudRestaurantRepository = crudRestaurantRepository;
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        return crudRestaurantRepository.save(restaurant);
    }

    @Override
    public boolean delete(int id) {
        return crudRestaurantRepository.delete(id) != 0;
    }

    @Override
    public Restaurant get(int id) {
        return crudRestaurantRepository.findById(id).orElse(null);
    }

    @Override
    public List<Restaurant> getAll() {
        return crudRestaurantRepository.findAll(SORT_NAME_CITY);
    }

    @Override
    public List<Restaurant> getAllByCity(City city) {
        return crudRestaurantRepository.findAllByCity(city, SORT_NAME_CITY);
    }

    @Override
    public List<Restaurant> getAllByContainsName(String name) {
        return crudRestaurantRepository.findAllByNameContaining(name, SORT_NAME_CITY);
    }
}
