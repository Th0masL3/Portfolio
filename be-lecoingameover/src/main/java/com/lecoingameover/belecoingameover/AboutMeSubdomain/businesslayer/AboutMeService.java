package com.lecoingameover.belecoingameover.AboutMeSubdomain.businesslayer;

import com.lecoingameover.belecoingameover.AboutMeSubdomain.presentationlayer.HobbyRequestModel;
import com.lecoingameover.belecoingameover.AboutMeSubdomain.presentationlayer.HobbyResponseModel;
import com.lecoingameover.belecoingameover.AboutMeSubdomain.presentationlayer.SkillRequestModel;
import com.lecoingameover.belecoingameover.AboutMeSubdomain.presentationlayer.SkillResponseModel;

public interface AboutMeService {
    SkillResponseModel getAllSkills(String lang);
    HobbyResponseModel getAllHobbies(String lang);

    SkillResponseModel addSkill(SkillRequestModel skillRequest, String lang);
    void deleteSkill(String skill, String lang);

    HobbyResponseModel addHobby(HobbyRequestModel hobbyRequest, String lang);
    void deleteHobby(String hobby, String lang);
}
