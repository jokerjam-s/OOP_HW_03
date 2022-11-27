package gb.hw.education.data.classes;

import gb.hw.education.data.interfaces.IAcademicStream;
import gb.hw.education.data.interfaces.IGroup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Класс учебный поток
 */
public class AcademicStream implements IAcademicStream, Iterable<IGroup> {
    private List<IGroup> groups;

    public AcademicStream(List<IGroup> groups) {
        this.groups = groups;
    }

    public AcademicStream(){
        this(new ArrayList<IGroup>());
    }

    @Override
    public List<IGroup> getGroups() {
        return this.groups;
    }

    @Override
    public void addGroup(IGroup group) {
        this.groups.add(group);
    }

    @Override
    public int getCountGroups() {
        return this.groups.size();
    }

    @Override
    public IGroup getGroup(int index) {
        if(index < 0 || index>= this.groups.size()){
            return null;
        }
        else {
            return this.groups.get(index);
        }
    }

    @Override
    public Iterator<IGroup> iterator() {
        Iterator<IGroup> groupIterator = new Iterator<IGroup>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < groups.size();
            }

            @Override
            public IGroup next() {
                return groups.get(index++);
            }

            @Override
            public void remove() {
                if(index < groups.size()){
                    groups.remove(index);
                }
            }
        };
        return groupIterator;
    }
}
