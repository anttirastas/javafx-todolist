/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolistapplication;

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import todolistapplication.domain.TodoList;

/**
 *
 * @author antti
 */
public class TodolistApplication extends Application {

    /**
     * @param args the command line arguments
     */
    
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();
        
        TodoList todolist = new TodoList();
        
        // Create HBox to contain action buttons
        
        // Create GridPane to contain actual todolist
        
        // Add appropriate event handlers
        
        // Add everything to same layout and show stage
        
        
    }
    
    public static void main(String[] args) {
        launch(TodolistApplication.class);
        
    }
    
}
