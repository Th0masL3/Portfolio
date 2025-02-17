package com.lecoingameover.belecoingameover.AboutMeSubdomain.businesslayer;

import com.lecoingameover.belecoingameover.AboutMeSubdomain.dataaccesslayer.AboutMe;
import com.lecoingameover.belecoingameover.AboutMeSubdomain.dataaccesslayer.AboutMeRepository;
import com.lecoingameover.belecoingameover.AboutMeSubdomain.presentationlayer.HobbyRequestModel;
import com.lecoingameover.belecoingameover.AboutMeSubdomain.presentationlayer.HobbyResponseModel;
import com.lecoingameover.belecoingameover.AboutMeSubdomain.presentationlayer.SkillRequestModel;
import com.lecoingameover.belecoingameover.AboutMeSubdomain.presentationlayer.SkillResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AboutMeServiceImpl implements AboutMeService {
    private final AboutMeRepository aboutMeRepository;

    @Override
    public SkillResponseModel getAllSkills(String lang) {
        AboutMe aboutMe = aboutMeRepository.findById("about_me")
                .orElse(new AboutMe("about_me", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));

        // Choose skills based on language
        List<String> skills = lang.equalsIgnoreCase("fr") ? aboutMe.getSkillsFr() : aboutMe.getSkillsEn();
        return new SkillResponseModel(skills);
    }

    @Override
    public HobbyResponseModel getAllHobbies(String lang) {
        AboutMe aboutMe = aboutMeRepository.findById("about_me")
                .orElse(new AboutMe("about_me", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));

        // Choose hobbies based on language
        List<String> hobbies = lang.equalsIgnoreCase("fr") ? aboutMe.getHobbiesFr() : aboutMe.getHobbiesEn();
        return new HobbyResponseModel(hobbies);
    }

    @Override
    public SkillResponseModel addSkill(SkillRequestModel skillRequest, String lang) {
        AboutMe aboutMe = aboutMeRepository.findById("about_me")
                .orElse(new AboutMe("about_me", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));

        List<String> skillsList = lang.equalsIgnoreCase("fr") ? aboutMe.getSkillsFr() : aboutMe.getSkillsEn();

        if (!skillsList.contains(skillRequest.getSkill())) {
            skillsList.add(skillRequest.getSkill());
            aboutMeRepository.save(aboutMe);
        }
        return new SkillResponseModel(skillsList);
    }

    @Override
    public void deleteSkill(String skill, String lang) {
        AboutMe aboutMe = aboutMeRepository.findById("about_me")
                .orElse(new AboutMe("about_me", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));

        List<String> skillsList = lang.equalsIgnoreCase("fr") ? aboutMe.getSkillsFr() : aboutMe.getSkillsEn();
        skillsList.remove(skill);
        aboutMeRepository.save(aboutMe);
    }

    @Override
    public HobbyResponseModel addHobby(HobbyRequestModel hobbyRequest, String lang) {
        AboutMe aboutMe = aboutMeRepository.findById("about_me")
                .orElse(new AboutMe("about_me", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));

        List<String> hobbiesList = lang.equalsIgnoreCase("fr") ? aboutMe.getHobbiesFr() : aboutMe.getHobbiesEn();

        if (!hobbiesList.contains(hobbyRequest.getHobby())) {
            hobbiesList.add(hobbyRequest.getHobby());
            aboutMeRepository.save(aboutMe);
        }
        return new HobbyResponseModel(hobbiesList);
    }

    @Override
    public void deleteHobby(String hobby, String lang) {
        AboutMe aboutMe = aboutMeRepository.findById("about_me")
                .orElse(new AboutMe("about_me", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));

        List<String> hobbiesList = lang.equalsIgnoreCase("fr") ? aboutMe.getHobbiesFr() : aboutMe.getHobbiesEn();
        hobbiesList.remove(hobby);
        aboutMeRepository.save(aboutMe);
    }
}
