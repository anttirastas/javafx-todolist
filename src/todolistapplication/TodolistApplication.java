/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolistapplication;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import todolistapplication.domain.TodoList;

/**
 *
 * @author antti
 */
public class TodolistApplication extends Application {
    
    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        
        TodoList todolist = new TodoList();
        
        // Create HBox to contain action buttons
        HBox hbox = new HBox();
        Button addTaskButton = new Button("Add task");
        Button addCategoryButton = new Button("Add category");
        
        hbox.getChildren().addAll(addTaskButton, addCategoryButton);
        
        
        // Create GridPane to contain actual todolist
        GridPane gridPane = new GridPane();
        for (int i = 0; i < todolist.getTasks().size(); i++) {
            Label task = new Label(todolist.getTasks().get(i).getName());
        }
        
        
        // Add appropriate event handlers
        
        // Add everything to same layout and show stage
        root.setTop(hbox);
        root.setCenter(gridPane);
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    public static void main(String[] args) {
        launch(TodolistApplication.class);
        
    }
    
}
