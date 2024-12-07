package com.lecoingameover.belecoingameover.presentationlayer;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsoleRequestModel {

    private String consoleName;
    private LocalDate releaseDate;
    private double price;
    private int quantityInStock;
    private String company;
}