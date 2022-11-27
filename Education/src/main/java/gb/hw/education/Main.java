package gb.hw.education;

import gb.hw.education.controllers.EducationController;
import gb.hw.education.data.classes.Stream;
import gb.hw.education.data.interfaces.IStream;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();

        List<IStream> streams = new ArrayList<>();

        streams.add(EducationController.newStream("Economy", 5, 10, 25));
        streams.add(EducationController.newStream("Biology", 3, 10, 25));
        streams.add(EducationController.newStream("History", 4, 10, 30));

        logger.info("-- CREATE --");;
        for (IStream s : streams) {
            logger.info(s.toString());
        }

        EducationController.sortListStream(streams);

        logger.info("-- SORT --");;
        for (IStream s : streams) {
            logger.info(s.toString());
        }

        logger.info("-- ITERATION --");
        logger.info(streams.get(2).getName());
        EducationController.showGroupList((Stream) streams.get(2));

    }
}