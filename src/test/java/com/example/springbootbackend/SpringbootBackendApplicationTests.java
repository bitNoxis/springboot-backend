package com.example.springbootbackend;

import com.example.springbootbackend.model.Food;
import com.example.springbootbackend.service.FoodServiceImpl;
import org.junit.jupiter.api.*;

import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class SpringbootBackendApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	void testSortList(){
//arrange
		Food testFoodAlt = new Food();
		testFoodAlt.setExpirationdate(new Date(2020-11-10));

		Food testFoodMitte= new Food();
		testFoodMitte.setExpirationdate(new Date(2021-11-10));

		Food testFoodNeu = new Food();
		testFoodNeu.setExpirationdate(new Date(2022-11-10));

		List<Food> unsortedFoodTest= Arrays.asList(testFoodAlt,testFoodNeu,testFoodMitte);
		List<Food> sortedFoodTest= Arrays.asList(testFoodAlt,testFoodMitte,testFoodNeu);

		FoodServiceImpl impl = new FoodServiceImpl();
//assert
 assertEquals(sortedFoodTest,impl.sortFood(unsortedFoodTest));




	}

}
