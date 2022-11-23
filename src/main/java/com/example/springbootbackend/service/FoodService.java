package com.example.springbootbackend.service;

import com.example.springbootbackend.model.Food;

import java.util.List;

public interface FoodService {
    public void saveFood(Food food);

   public void deleteFood(Food food);

    public List<Food> getAllFood();
}
