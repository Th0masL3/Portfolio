package com.lecoingameover.belecoingameover.dataaccess;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Document(collection = "consoles")
public class Console {
    @Id
    private String consoleId;
    //check for id

    @Indexed(unique = true)
    private ConsoleIdentifier consoleIdentifier;
    private String consoleName;
    private LocalDate releaseDate;
    private double price;
    private int quantityInStock;
    private String company;
    private String image;
}
