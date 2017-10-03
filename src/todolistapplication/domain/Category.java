/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolistapplication.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author antti
 */
public class Category {
    private String name;
    private List<Task> tasksInCategory;

    public Category(String name) {
        this.name = name;
        this.tasksInCategory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasksInCategory() {
        return tasksInCategory;
    }
    
    public List<Task> getDoneTasksInCategory() {
        List<Task> doneTasks = new ArrayList<>();
        
        for (Task task : this.tasksInCategory) {
            if (task.isDone()) {
                doneTasks.add(task);
            }
        }
        
        return doneTasks;
    }
    
    public List<Task> getUndoneTasksInCategory() {
        List<Task> undoneTasks = new ArrayList<>();
        
        for (Task task : this.tasksInCategory) {
            if (!task.isDone()) {
                undoneTasks.add(task);
            }
        }
        
        return undoneTasks;
    }
    
    public void addTaskInCategory(Task task) {
        if (!this.tasksInCategory.contains(task)) {
            this.tasksInCategory.add(task);
        }
    }
    
    public void removeTaskFromCategory(Task task) {
        if (this.tasksInCategory.contains(task)) {
            this.tasksInCategory.remove(task);
        }
    }
    
    public boolean hasTask(Task task) {
        return this.tasksInCategory.contains(task);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Category other = (Category) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
