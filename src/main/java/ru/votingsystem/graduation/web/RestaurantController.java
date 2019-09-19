package ru.votingsystem.graduation.web;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.votingsystem.graduation.model.Restaurant;
import ru.votingsystem.graduation.service.interfaces.RestaurantService;
import ru.votingsystem.graduation.util.UriBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = RestaurantController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantController {
    public static final String REST_URL = "/api/restaurant";

    private final RestaurantService service;

    public RestaurantController(RestaurantService service) {
        this.service = service;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> create(@Valid @RequestBody Restaurant restaurant) {
        Restaurant newRestaurant = service.create(restaurant);

        return ResponseEntity
                .created(UriBuilder.buildUriEntity(REST_URL, newRestaurant))
                .body(newRestaurant);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> update(@Valid @RequestBody Restaurant restaurant, @PathVariable Integer id) {
        restaurant.setId(id);
        Restaurant updatedRestaurant = service.update(restaurant);

        return ResponseEntity
                .created(UriBuilder.buildUriEntity(REST_URL, updatedRestaurant))
                .body(updatedRestaurant);
    }
}
