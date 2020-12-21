package ru.innopolis.university.lesson19.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Buyer {
    private long id;
    private String name;
}
