package com.lecoingameover.belecoingameover.AboutMeSubdomain.presentationlayer;

import com.lecoingameover.belecoingameover.AboutMeSubdomain.businesslayer.AboutMeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/aboutme")
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class AboutMeController {

    private final AboutMeService aboutMeService;

    @GetMapping("/skills")
    public ResponseEntity<SkillResponseModel> getAllSkills(@RequestParam(name = "lang", defaultValue = "en") String lang) {
        return ResponseEntity.ok(aboutMeService.getAllSkills(lang));
    }

    @GetMapping("/hobbies")
    public ResponseEntity<HobbyResponseModel> getAllHobbies(@RequestParam(name = "lang", defaultValue = "en") String lang) {
        return ResponseEntity.ok(aboutMeService.getAllHobbies(lang));
    }

    @PostMapping("/skills")
    public ResponseEntity<SkillResponseModel> addSkill(@RequestBody SkillRequestModel skillRequest) {
        return ResponseEntity.ok(aboutMeService.addSkill(skillRequest, skillRequest.getLang()));
    }

    @DeleteMapping("/skills/{skill}")
    public ResponseEntity<Void> deleteSkill(@PathVariable String skill, @RequestParam(name = "lang", defaultValue = "en") String lang) {
        aboutMeService.deleteSkill(skill, lang);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/hobbies")
    public ResponseEntity<HobbyResponseModel> addHobby(@RequestBody HobbyRequestModel hobbyRequest) {
        return ResponseEntity.ok(aboutMeService.addHobby(hobbyRequest, hobbyRequest.getLang()));
    }

    @DeleteMapping("/hobbies/{hobby}")
    public ResponseEntity<Void> deleteHobby(@PathVariable String hobby, @RequestParam(name = "lang", defaultValue = "en") String lang) {
        aboutMeService.deleteHobby(hobby, lang);
        return ResponseEntity.noContent().build();
    }
}
