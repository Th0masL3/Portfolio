package com.lecoingameover.belecoingameover.presentationlayer;

import com.lecoingameover.belecoingameover.buisnesslayer.ConsoleService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/consoles")
@Slf4j
public class ConsoleController {
private ConsoleService consoleService;
public ConsoleController(ConsoleService consoleService) {this.consoleService = consoleService;}

@GetMapping
public ResponseEntity<List<ConsoleResponseModel>> getAllConsoles() {
    return ResponseEntity.ok().body(consoleService.getAllConsoles());
}
}
