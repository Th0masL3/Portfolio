package com.lecoingameover.belecoingameover.presentationlayer;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Builder
@AllArgsConstructor
@Getter
@Setter

public class ConsoleResponseModel {
    private String consoleId;
    private String consoleName;
    private LocalDate releaseDate;
    private double price;
    private int quantityInStock;
    private String company;
}