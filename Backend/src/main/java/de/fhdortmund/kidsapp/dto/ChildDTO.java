package de.fhdortmund.kidsapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChildDTO {
    private Long id;
    private String name;
    private int age;
    private String interests;
    private String hobbies;
}