package com.cydeo.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class SquareNumberTest {
    public static void main(String[] args) {
        List<Integer> list=Arrays.asList(1,2,3,4,5);

        List<Integer> squares = list.stream()
                .map(p->p*p)
                .collect(toList());
        System.out.println(squares);
    }
}
