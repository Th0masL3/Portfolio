package com.lecoingameover.belecoingameover.presentationlayer;

import com.lecoingameover.belecoingameover.buisnesslayer.ConsoleService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/consoles")
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class ConsoleController {
private ConsoleService consoleService;
public ConsoleController(ConsoleService consoleService) {this.consoleService = consoleService;}

@GetMapping
public ResponseEntity<List<ConsoleResponseModel>> getAllConsoles() {
    return ResponseEntity.ok().body(consoleService.getAllConsoles());
}
    @PutMapping("/{consoleId}")
    public ResponseEntity<ConsoleResponseModel> updateConsole(
            @PathVariable String consoleId,
            @Valid @RequestBody ConsoleRequestModel consoleRequestModel) {
        return ResponseEntity.ok(consoleService.updateConsole(consoleId, consoleRequestModel));
    }

    @GetMapping("/{consoleId}")
    public ResponseEntity<ConsoleResponseModel> getConsoleById(@PathVariable String consoleId) {
        return ResponseEntity.ok(consoleService.getConsoleById(consoleId));
    }

    @PostMapping
    public ResponseEntity<ConsoleResponseModel> addConsole(@Valid @RequestBody ConsoleRequestModel consoleRequestModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(consoleService.addConsole(consoleRequestModel));
    }

    @DeleteMapping("/{consoleId}")
    public ResponseEntity<Void> deleteConsoleById(@PathVariable String consoleId) {
        consoleService.deleteConsoleByConsoleId(consoleId);
        return ResponseEntity.noContent().build();
    }

}
