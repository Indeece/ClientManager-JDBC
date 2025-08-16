package ru.indeece.clientmanagerjdbc.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Customer {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private LocalDateTime created;
}
