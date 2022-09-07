package com.example.springbootbackend.service;

import com.example.springbootbackend.model.Food;

import java.util.List;

public interface FoodService {
    public Food saveFood(Food food);
    public List<Food> getAllFood();
}
