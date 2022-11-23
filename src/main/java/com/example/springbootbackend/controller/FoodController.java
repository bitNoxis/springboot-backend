package com.example.springbootbackend.controller;

import com.example.springbootbackend.model.Food;
import com.example.springbootbackend.model.repository.FoodRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class FoodController {

    private final FoodRepository foodRepository;

    public FoodController(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @GetMapping
    public List<Food> getClients() {
        return foodRepository.findAll();
    }

    @GetMapping("/{id}")
    public Food getClient(@PathVariable Integer id) {
        return foodRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createClient(@RequestBody Food food) throws URISyntaxException {
        Food savedFood = foodRepository.save(food);
        return ResponseEntity.created(new URI("/foods/" + savedFood.getProductid())).body(savedFood);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFood(@PathVariable Integer id) {
        foodRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}