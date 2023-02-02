package com.cydeo.task;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data //@Getter @Setter @ToString
@AllArgsConstructor
public class User {
    private String firstName;
    private String lastname;
    private int age;
}
