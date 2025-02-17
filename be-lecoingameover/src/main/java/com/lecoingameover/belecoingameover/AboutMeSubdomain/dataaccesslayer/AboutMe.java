package com.lecoingameover.belecoingameover.AboutMeSubdomain.dataaccesslayer;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "about_me")
public class AboutMe {

    @Id
    private String infoId;
    private List<String> skillsEn;

    private List<String> skillsFr;

    private List<String> hobbiesEn;

    private List<String> hobbiesFr;
}
