package gb.hw.education.data.classes;

import gb.hw.education.data.interfaces.IStream;
import gb.hw.education.data.interfaces.IGroup;
import gb.hw.education.services.classes.StreamComparator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Класс учебный поток
 */
public class Stream implements IStream, Iterable<IGroup> {
    private String name;
    private List<IGroup> groups;

    public Stream(String name, List<IGroup> groups) {
        this.name = name;
        this.groups = groups;
    }

    public Stream(String name) {
        this(name, new ArrayList<IGroup>());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
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
    public String toString() {
        return String.format("Поток [%s, групп - %d]", this.name, this.getCountGroups());
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
