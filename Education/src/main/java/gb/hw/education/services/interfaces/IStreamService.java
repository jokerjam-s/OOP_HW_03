package gb.hw.education.services.interfaces;

import gb.hw.education.data.interfaces.IStream;

import java.util.List;

public interface IStreamService {
    void sortByGroupCount(List<IStream> stream);
}
