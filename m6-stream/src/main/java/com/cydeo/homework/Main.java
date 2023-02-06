package com.cydeo.homework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul","Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian,2011,300),
                new Transaction(raoul,2012,1000),
                new Transaction(raoul,2011,400),
                new Transaction(mario,2012,710),
                new Transaction(mario,2012,700),
                new Transaction(alan,2012,950)
        );
        System.out.println("1-----------------------------------------------------------------------------");
       // 1. Find all transactions in the year 2011 and sort them by value(small to high)
        transactions.stream()
                .filter(p->p.getYear()==2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);
        System.out.println("2-----------------------------------------------------------------------------");
        //2. What are all the unique cities where the traders work?
        transactions.stream()
                .map(p->p.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

        System.out.println("3-----------------------------------------------------------------------------");
       // 3. Find all traders from Cambridge and sort them by name.
        transactions.stream()
                        .filter(p->p.getTrader().getCity()=="Cambridge")
                        .map(p->p.getTrader().getName())
                        .sorted()
                        .forEach(System.out::println);


        System.out.println("4-----------------------------------------------------------------------------");
       // 4. Return a string of all traders’ names sorted alphabetically.
        transactions.stream()
                .map(p->p.getTrader().getName())
                .collect(Collectors.toList())
                .stream().sorted()
                .forEach(System.out::println);

        System.out.println("5-----------------------------------------------------------------------------");
       //  5.Are any traders based in Milan?

        boolean MilanBased =
                transactions.stream()
                        .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(MilanBased);

        System.out.println("6-----------------------------------------------------------------------------");
        //  6. Print the values of all transactions from the traders living in Cambridge.

        transactions.stream()
                .filter(p->p.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);


        System.out.println("7-----------------------------------------------------------------------------");
     // 7. What is the highest value of all the transactions?

        transactions.stream()
                .sorted(Comparator.comparing(Transaction::getValue).reversed())
                .limit(1)
                .map(Transaction::getValue)
                .forEach(System.out::println);
        //second solution
        Optional<Integer> highestValue =
        transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);

        System.out.println("8-----------------------------------------------------------------------------");
     // 8. Find the transaction with the smallest value.

        transactions.stream()
                .sorted(Comparator.comparing(Transaction::getValue))
                .limit(1)
                .map(Transaction::getValue)
                .forEach(System.out::println);

        //second solution
        Optional<Integer> smallestTransaction =
                transactions.stream()
                      //  .reduce((t1, t2) ->t1.getValue() < t2.getValue() ? t1 : t2);
                        .map(Transaction::getValue)
        .reduce(Integer::min);
        System.out.println(smallestTransaction);


    }
}
