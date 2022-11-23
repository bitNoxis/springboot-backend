package com.example.springbootbackend.service;

import com.example.springbootbackend.model.Food;
import com.example.springbootbackend.model.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class FoodServiceImpl implements FoodService{



    @Autowired
    private FoodRepository foodRepository;

    @Override
    public void saveFood(Food food) {
        foodRepository.save(food);
    }

    @Override
    public void deleteFood(Food food) {
        foodRepository.delete(food);
    }

    @Override
    public List<Food> getAllFood() {
        return  sortFood();
    }

    private  List<Food> sortFood(){
        List<Food> unsortedFoods = foodRepository.findAll();
        Collections.sort(unsortedFoods,BY_DATE);
       return unsortedFoods; }

    protected static final Comparator<Food>BY_DATE = Comparator.comparing(Food::getExpirationdate);

}
