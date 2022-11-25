package gb.hw.education.services.classes;

import gb.hw.education.data.classes.EducationGroup;
import gb.hw.education.services.interfaces.IGroupService;

import java.io.*;
import java.util.logging.Logger;


public class EducationGroupService implements IGroupService {
    @Override
    public String saveGroupToTxt(String fileName, EducationGroup group){
        String result = "OK";

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(group);
            outputStream.close();
        } catch (IOException e) {
            result = e.getMessage();
        }
        Logger logger = Logger.getAnonymousLogger();
        logger.info(result);

        return result;
    }

    @Override
    public EducationGroup loadGroupFromTxt(String fileName){
        EducationGroup group;
        try{
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            group = (EducationGroup) inputStream.readObject();
            inputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            Logger logger = Logger.getAnonymousLogger();
            logger.info(e.getMessage());
            group = null;
        }

        return group;
    }

    public EducationGroupService() {
    }
}
