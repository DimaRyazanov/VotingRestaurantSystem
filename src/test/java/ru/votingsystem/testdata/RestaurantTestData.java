package ru.votingsystem.testdata;

import ru.votingsystem.model.Restaurant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestaurantTestData {
    public static Restaurant RESTAURANT_ONE = new Restaurant(1, "Ресторан на тверской", new ArrayList<>(), new ArrayList<>());
    public static Restaurant RESTAURANT_TWO = new Restaurant(2, "Gudini", new ArrayList<>(), new ArrayList<>());
    public static Restaurant RESTAURANT_THREE = new Restaurant(3, "Das is good", new ArrayList<>(), new ArrayList<>());
    public static Restaurant RESTAURANT_FOUR = new Restaurant(4, "На парах", new ArrayList<>(), new ArrayList<>());

    public static List<Restaurant> RESTAURANTS = new ArrayList<>(Arrays.asList(RESTAURANT_ONE, RESTAURANT_TWO, RESTAURANT_THREE, RESTAURANT_FOUR));
}
