package com.cydeo.java10;

import java.util.Optional;

public class OrElseThrow2MyCode {
    public static void main(String[] args) {

        // create a Optional
        Optional<Integer> op = Optional.empty();

        // print supplier
        System.out.println("Optional: " + op);

        try {

            // orElseThrow supplier
            System.out.println("Value by orElseThrow(" + "ArithmeticException::new) method: " + op.orElseThrow(ArithmeticException::new));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}