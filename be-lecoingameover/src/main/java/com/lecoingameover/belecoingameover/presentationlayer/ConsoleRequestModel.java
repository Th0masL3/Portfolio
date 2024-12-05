package com.lecoingameover.belecoingameover.presentationlayer;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConsoleRequestModel {

    private String consoleName;
    private LocalDate releaseDate;
    private double price;
    private int quantityInStock;
    private String company;
}