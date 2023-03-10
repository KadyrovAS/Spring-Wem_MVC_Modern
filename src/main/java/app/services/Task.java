package app.services;

import java.util.Date;

public class Task {
    private Long id;
    private String name;
    private Date created;
    private PriorityType priority;
    private Type type;

    public Task(Long id, String name, Date created, PriorityType priority, Type type) {
        this.id = id;
        this.name = name;
        this.created = created;
        this.priority = priority;
        this.type = type;
    }

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public PriorityType getPriority() {
        return priority;
    }

    public void setPriority(PriorityType priority) {
        this.priority = priority;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created=" + created +
                ", priority=" + priority +
                ", type=" + type +
                '}';
    }
}
