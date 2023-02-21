package app.services;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class TaskService {
    private static List<Task>store = new ArrayList<>();
    static {
        store.add(new Task(1L, "Создание обращения", new Date(), PriorityType.CRITICAL, Type.TASK));
        store.add(new Task(2L, "Исправить ошибку подключения", new Date(), PriorityType.BLOCKER, Type.BUG));
        store.add(new Task(3L, "Создать метод для парсинга строки", new Date(), PriorityType.MINOR, Type.TASK));
        store.add(new Task(4L, "Создать сущность событие", new Date(), PriorityType.MAJOR, Type.TASK));
    }

    public void create(Task task){
        store.add(task);
    }

    public List<Task> get(){
        return store;
    }

    public Task get(Long id){
        return store.stream().filter(item->item.getId().equals(id)).findFirst().get();
    }

    public void update(Task task){
        Task oldTask = this.get(task.getId());
        store.remove(oldTask);
        store.add(task);
    }

    public void delete(Long id){
        Task task = get(id);
        store.remove(task);
    }

    public int size(){
        return store.size();
    }
}