package gb.hw.education.services.classes;

import gb.hw.education.data.interfaces.IStream;
import gb.hw.education.services.interfaces.IStreamService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StresamService implements IStreamService {
    List<IStream> streams;

    /**
     * Конструктора с параметрами
     * @param streams - список групп
     */
    public StresamService(List<IStream> streams) {
        this.streams = streams;
    }

    /**
     * Конструктор без параметров
     */
    public StresamService() {
        this(new ArrayList<>());
    }

    @Override
    public int getCountStream() {
        return this.streams.size();
    }

    @Override
    public void addStream(IStream stream) {
        this.streams.add(stream);
    }

    @Override
    public boolean removeStream(IStream stream) {
        return this.streams.remove(stream);
    }

    @Override
    public IStream removeStream(int index) {
        return this.streams.remove(index);
    }

    public void sortByGroupCount(){
        this.streams.sort(new StreamComparator());
    }
}
