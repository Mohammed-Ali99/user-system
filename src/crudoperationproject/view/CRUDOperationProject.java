/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudoperationproject.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Mohamed
 */
public class CRUDOperationProject extends Application{

    static LeftPane leftPane = new LeftPane();
    static RightPane rightPane = new RightPane();
    
    public static void main(String[] args) {
        launch();
    
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        HBox main = new HBox();
        main.getChildren().addAll(leftPane , rightPane);
        
        leftPane.prefWidthProperty().bind(main.widthProperty().divide(4));
        rightPane.prefWidthProperty().bind(main.widthProperty().subtract(main.widthProperty().divide(4)));
        
        Scene scene = new Scene(main , 1000 , 500);
        stage.setScene(scene);
        stage.show();
        
    }
    
}
