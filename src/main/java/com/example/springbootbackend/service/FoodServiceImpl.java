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
    public Food saveFood(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public List<Food> getAllFood() {
        //hier sortieren

        return  sortFood();
    }

    private  List<Food> sortFood(){
        List<Food> unsortedFoods = foodRepository.findAll();
        Collections.sort(unsortedFoods,BY_DATE);
       return unsortedFoods; }

    protected static final Comparator<Food>BY_DATE = new Comparator<Food>() {
        @Override
        public int compare(Food o1, Food o2) {
            return o1.getExpirationdate().compareTo(o2.getExpirationdate()) ;

        }
    };

}
