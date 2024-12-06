package com.lecoingameover.belecoingameover.dataaccess;


import lombok.Getter;

import java.util.UUID;


@Getter
public class ConsoleIdentifier
{
private String consoleId;
public ConsoleIdentifier(){ this.consoleId = UUID.randomUUID().toString();
}
}
