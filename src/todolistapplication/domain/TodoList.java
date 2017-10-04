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
    private Category inbox;
    
    public TodoList() {
        this.taskList = new ArrayList<>();
        this.categoryList = new ArrayList<>();
        this.inbox = new Category("Inbox");
        this.categoryList.add(inbox);
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
    
    public void addTask(String name) {
        Task task = new Task(name, this.inbox);
        if (!this.taskList.contains(task)) {
            this.taskList.add(task);
        }
        this.categoryList.get(0).addTaskInCategory(task);
        
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
        if (name.equals("Inbox")) {
            return;
        }
        for (Category category : this.categoryList) {
            if (category.getName().equals(name)) {
                for (int i = 0; i < category.getTasksInCategory().size(); i++) {
                    category.getTasksInCategory().get(i).changeCategory(inbox);
                }
                this.categoryList.remove(category);
            }
        }
    }
    
    public void changeCategoryOfATask(Task task, Category newCategory) {
        // Get the task from taskList and change its category
        for (Task taskInList : this.taskList) {
            if (taskInList.equals(task)) {
                taskInList.changeCategory(newCategory);
            }
        }
        
        // Remove the task from the old category's list
        for (Category categoryInList : this.categoryList) {
            if (categoryInList.hasTask(task)) {
                categoryInList.removeTaskFromCategory(task);
            }
        }
        
        // Add the task to the new category's list
        newCategory.addTaskInCategory(task);
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
