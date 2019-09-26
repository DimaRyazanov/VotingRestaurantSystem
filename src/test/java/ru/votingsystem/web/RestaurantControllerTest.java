package ru.votingsystem.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.votingsystem.util.TestMatcher;
import ru.votingsystem.model.Restaurant;
import ru.votingsystem.service.interfaces.RestaurantService;
import ru.votingsystem.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

import static ru.votingsystem.testdata.RestaurantTestData.RESTAURANTS;

class RestaurantControllerTest extends AbstractControllerTest {

    @Autowired
    private RestaurantService service;

    @Test
    void createNewRestaurant() throws Exception {
        Restaurant newRestaurant = new Restaurant("Мягкие рестораны");
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post(RestaurantController.REST_URL)
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .content(JsonUtil.writeValueToJson(newRestaurant)));
        Restaurant returnedRestaurant = JsonUtil.readFromJsonResultAction(action, Restaurant.class);
        newRestaurant.setId(returnedRestaurant.getId());

        TestMatcher.assertMatch(returnedRestaurant, newRestaurant);
        List<Restaurant> expected = new ArrayList<>(RESTAURANTS);
        expected.add(newRestaurant);
        List<Restaurant> actual = new ArrayList<>(service.getAll());
        TestMatcher.assertMatch(actual, expected);
    }

    @Test
    void updateRestaurant() {

    }
}