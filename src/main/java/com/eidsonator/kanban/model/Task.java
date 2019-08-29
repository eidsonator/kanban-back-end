package com.eidsonator.kanban.model;

import com.eidsonator.kanban.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.Max;
import java.util.List;

public class Task {

    @Autowired
    private TaskMapper taskMapper;

    private Long id;
    private String title;
    private String description;
    private Long parent;
    private List<Task> children;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public void setChildren(List<Task> children) {
        this.children = children;
    }

    public List<Task> getChildren() {
       return children;
    }
}
