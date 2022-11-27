package gb.hw.education.services.classes;

import gb.hw.education.data.interfaces.IStream;
import gb.hw.education.services.interfaces.IStreamService;

import java.util.Collections;
import java.util.List;

public class StreamService implements IStreamService {
   @Override
   public void sortByGroupCount(List<IStream> stream){
       StreamComparator comparator = new StreamComparator();
       Collections.sort(stream, comparator);
    }
}
