package com.lecoingameover.belecoingameover.AboutMeSubdomain.dataaccesslayer;

import lombok.Getter;

import java.util.UUID;

@Getter
public class AboutMeIdentifier
{
    private final String infoId;
    public AboutMeIdentifier(){ this.infoId = UUID.randomUUID().toString();
    }
}
