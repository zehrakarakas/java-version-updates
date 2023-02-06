package com.cydeo.homework;

import com.cydeo.task.Dish;
import com.cydeo.task.DishData;

import java.util.stream.Collectors;

public class CountNumberDishes {
    public static void main(String[] args) {
         Long dishes=   DishData.getAll().stream()
                 // .map(p -> 1)
                //.reduce(0,(a,b)->a+b);

                        .collect(Collectors.counting());
        System.out.println(dishes);






    }
}