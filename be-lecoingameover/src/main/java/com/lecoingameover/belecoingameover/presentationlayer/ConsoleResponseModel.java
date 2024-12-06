package com.lecoingameover.belecoingameover.presentationlayer;

import com.lecoingameover.belecoingameover.dataaccess.ConsoleIdentifier;
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


    private ConsoleIdentifier consoleIdentifier;
    private String consoleName;
    private LocalDate releaseDate;
    private double price;
    private int quantityInStock;
    private String company;
}