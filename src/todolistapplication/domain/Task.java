/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolistapplication.domain;

import java.util.Objects;

/**
 *
 * @author antti
 */
public class Task {
    private String name;
    private boolean done;
    private Category category;
    
    public Task(String name, Category category) {
        this.name = name;
        this.done = false;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public boolean isDone() {
        return done;
    }
    
    public void markAsDone() {
        this.done = true;
    }
    
    public void markAsUndone() {
        this.done = false;
    }
    
    public void changeCategory(Category newCategory) {
        this.category = newCategory;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.name);
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
        final Task other = (Task) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    

    @Override
    public String toString() {
        return this.name;
    }
    
    
}
