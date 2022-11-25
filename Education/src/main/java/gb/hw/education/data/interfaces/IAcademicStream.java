package gb.hw.education.data.interfaces;

import java.util.List;

/**
 * Интерфейс академического потока
 */
public interface IAcademicStream {
    /**
     * Получить список групп
     * @return
     */
    List<IGroup> getGroups();

    /**
     * добавить группу в поток
     * @param group - добавляемая группа
     */
    void addGroup(IGroup group);

    /**
     * получить количество групп в потоке
     * @return
     */
    int getGroupCount();

    /**
     * Получить группу по индексу
     * @param index - индекс нужной группы
     * @return      - если групппы с нужным индексом нет вернет null
     */
    IGroup getGroup(int index);

}
