/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolistapplication.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author antti
 */
public class TodoList {
    private List<Task> taskList;
    private List<Category> categoryList;
    
    public TodoList() {
        this.taskList = new ArrayList<>();
        this.categoryList = new ArrayList<>();
    }
    
    public List<Task> getTasks() {
        return this.taskList;
    }
    
    public List<Task> getDoneTasks() {
        List<Task> doneTasks = new ArrayList<>();
        
        for (Task task : this.taskList) {
            if (task.isDone()) {
                doneTasks.add(task);
            }
        }
        
        return doneTasks;
    }
    
    public List<Task> getUndoneTasks() {
        List<Task> undoneTasks = new ArrayList<>();
        
        for (Task task : this.taskList) {
            if (!task.isDone()) {
                undoneTasks.add(task);
            }
        }
        
        return undoneTasks;
    }
    
    public void addTask(Task task) {
        if (!this.taskList.contains(task)) {
            this.taskList.add(task);
        }
        
        for (Category category : this.categoryList) {
            if (category.hasTask(task)) {
                category.removeTaskFromCategory(task);
            }
        }
    }
    
    public void removeTask(Task task) {
        if (this.taskList.contains(task)) {
            this.taskList.remove(task);
        }
        
        for (Category category : this.categoryList) {
            if (category.hasTask(task)) {
                category.removeTaskFromCategory(task);
            }
        }
    }
    
    public void addCategory(String name) {
        if (!this.categoryList.contains(new Category(name))) {
            this.categoryList.add(new Category(name));
        }
    }
    
    public void removeCategory(String name) {
        for (Category category : this.categoryList) {
            if (category.getName().equals(name)) {
                this.categoryList.remove(category);
            }
        }
    }
    
    public List<Category> getCategories() {
        return this.categoryList;
    }
    
    public void addTaskToCategory(Task task, Category category) {
        if (this.taskList.contains(task) 
                && this.categoryList.contains(category)) {
            for (int i = 0; i < this.categoryList.size(); i++) {
                if (this.categoryList.get(i).equals(category)) {
                    this.categoryList.get(i).addTaskInCategory(task);
                }
            }
        }
    }
    
    public void removeTaskFromCategory(Task task, Category category) {
        if (this.taskList.contains(task) 
                && this.categoryList.contains(category)) {
            for (int i = 0; i < this.categoryList.size(); i++) {
                if (this.categoryList.get(i).equals(category)) {
                    this.categoryList.get(i).removeTaskFromCategory(task);
                }
            }
        }
    }
   
}
