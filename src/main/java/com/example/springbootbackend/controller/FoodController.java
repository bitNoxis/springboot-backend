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
   @DeleteMapping( "/delete")
    public String delete(@RequestBody int id){
        foodService.deleteFoodByID(id);
        return "Food is deleted";
    }

    @GetMapping("/getAll")
    public List<Food> getAllFood(){
        return foodService.getAllFood();
    }
}
