package de.fhdortmund.kidsapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Child {
    private Long id;
    private String name;
    private int age;
    private String interests;
    private String hobbies;
}