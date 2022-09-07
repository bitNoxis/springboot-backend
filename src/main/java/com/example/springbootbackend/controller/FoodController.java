package com.example.springbootbackend.controller;

import com.example.springbootbackend.model.Food;
import com.example.springbootbackend.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
@CrossOrigin

public class FoodController {
    @Autowired
    private FoodService foodService;

    @PostMapping("/add")
    public String add(@RequestBody Food food){
        foodService.saveFood(food);
        return  "New food is added";
    }

    @GetMapping("/getAll")
    public List<Food> getAllFood(){
        return foodService.getAllFood();
    }
}
