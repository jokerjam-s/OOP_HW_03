package gb.hw.education.services.interfaces;

import gb.hw.education.data.classes.EducationGroup;

public interface IGroupService {
    String saveGroupToTxt(String fileName, EducationGroup group);

    EducationGroup loadGroupFromTxt(String fileName);
}
